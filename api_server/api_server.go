package main

import (
	"bufio"
	"encoding/json"
	"io"
	"log"
	"net/http"
	"os"
	"strconv"
	"strings"
	"time"
)

/*
 * Complete the 'postHandler', 'deleteHandler' and 'getHandler' functions below.
 *
 * All functions are expected to be void.
 * All functions accept http.ResponseWriter w and *http.Request req as parameters.
 */

func postHandler(w http.ResponseWriter, req *http.Request) {
	decoder := json.NewDecoder(req.Body)
	var requestJson Lake
	_ = decoder.Decode(&requestJson)
	store[requestJson.Id] = requestJson
}

func deleteHandler(w http.ResponseWriter, req *http.Request) {
	params1 := req.URL.Query().Get("id")
	if params1 != "" {

		delete(store, params1)
	}
}

func getHandler(w http.ResponseWriter, req *http.Request) {
	params1 := req.URL.Query().Get("id")
	if params1 != "" {
		v, _ := json.Marshal(store[params1])
		w.Write(v)
	}

}

type Adapter func(http.Handler) http.Handler

func Wrap() Adapter {
	return func(h http.Handler) http.Handler {
		return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			log.Println("before")
			defer log.Println("after")
			h.ServeHTTP(w, r)
		})
	}
}

//func Adapt(handler http.Handler, adapters ...Adapter) http.Handler {
//
//	for _, adapter := range adapters {
//		handler = adapter.Wrap(handler)
//	}
//}
type Logger struct {
	handler http.Handler
}

//ServeHTTP handles the request by passing it to the real
//handler and logging the request details
func (l *Logger) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	start := time.Now()
	l.handler.ServeHTTP(w, r)
	log.Printf("%s %s %v", r.Method, r.URL.Path, time.Since(start))
}

//NewLogger constructs a new Logger middleware handler
func NewLogger(handlerToWrap http.Handler) *Logger {
	return &Logger{handlerToWrap}
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	//stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	//checkError(err)
	//
	//defer stdout.Close()
	//
	//writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	actionsCount, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)

	mux := http.NewServeMux()
	mux.HandleFunc("/get", getHandler)
	mux.HandleFunc("/post", postHandler)
	mux.HandleFunc("/delete", deleteHandler)
	wrappedMux := NewLogger(mux)

	go http.ListenAndServe(portSuffix, wrappedMux)
	time.Sleep(100 * time.Millisecond)

	var actions []string

	for i := 0; i < int(actionsCount); i++ {
		actionsItem := readLine(reader)
		actions = append(actions, actionsItem)
	}

	for _, actionStr := range actions {
		var action Action
		err := json.Unmarshal([]byte(actionStr), &action)
		checkError(err)
		switch action.Type {
		case "post":
			_, err := http.Post(address+"/post", "application/json", strings.NewReader(action.Payload))
			checkError(err)
		case "delete":
			client := &http.Client{}
			req, err := http.NewRequest("DELETE", address+"/delete?id="+action.Payload, nil)
			checkError(err)
			resp, err := client.Do(req)
			checkError(err)
			if resp.StatusCode != 200 {
				//fmt.Fprintf(writer, "%s\n", resp.Status)
				continue
			}
		case "get":
			resp, err := http.Get(address + "/get?id=" + action.Payload)
			checkError(err)
			if resp.StatusCode != 200 {
				//fmt.Fprintf(writer, "%s\n", resp.Status)
				continue
			}
			var lake Lake
			err = json.NewDecoder(resp.Body).Decode(&lake)
			checkError(err)
			//fmt.Fprintf(writer, "%s\n", lake.Name)
			//fmt.Fprintf(writer, "%d\n", lake.Area)
		}
	}

	//fmt.Fprintf(writer, "\n")

	//writer.Flush()
}

const portSuffix = ":3333"

var address = "http://127.0.0.1" + portSuffix

type Lake struct {
	Id   string `json:"id"`
	Name string `json:"name"`
	Area int32  `json:"area"`
}

type Action struct {
	Type    string
	Payload string
}

var store = map[string]Lake{}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
