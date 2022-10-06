package main

import (
	"fmt"
	"net/http"
	"time"
)

func main() {
	urls := []string{
		"https://google.com",
		"https://facebook.com",
		"https://instagram.com",
	}

	done := make(chan string)

	for i := 0; i < len(urls); i++ {
		go fetch(urls[i], done)
	}

	for link := range done {
		go func(link string) {
			time.Sleep(time.Second * 1)
			fetch(link, done)
		}(link)
	}

}

func fetch(url string, done chan<- string) {
	resp, err := http.Get(url)
	if err != nil {
		fmt.Println(fmt.Printf("Got error in getting response from %s", url))
	} else {
		fmt.Println(fmt.Printf("responseStatus %s returned from url: %s ", resp.Status, url))
	}
	done <- url
}
