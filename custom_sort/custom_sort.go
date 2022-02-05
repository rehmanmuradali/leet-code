package main

import (
	"bufio"
	"io"
	"sort"
	"strings"
)

/*
 * Complete the 'customSorting' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY strArr as parameter.
 */

func customSorting(strArr []string) []string {
	sort.Slice(strArr, func(i, j int) bool {

		lenI := len(strArr[i])
		lenJ := len(strArr[j])
		lenModI := lenI % 2
		lenModJ := lenJ % 2
		if lenModI < lenModJ {
			return false
		}
		if lenModJ < lenModI {
			return true
		}

		if lenModJ == 1 {
			if lenI == lenJ {
				return strArr[i] < strArr[j]
			}
			if lenI < lenJ {
				return true
			}
			return false
		}

		if lenModJ == 0 {
			if lenI == lenJ {
				return strArr[i] < strArr[j]
			}
			if lenI < lenJ {
				return false
			}
			return true
		}

		return false
	})
	return strArr
}

func main() {
	//reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)
	//
	//stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
	//checkError(err)
	//
	//defer stdout.Close()
	//
	//writer := bufio.NewWriterSize(stdout, 16*1024*1024)
	//
	//strArrCount, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	//checkError(err)
	//
	//var strArr []string
	//
	//for i := 0; i < int(strArrCount); i++ {
	//	strArrItem := readLine(reader)
	//	strArr = append(strArr, strArrItem)
	//}
	//
	//result := customSorting(strArr)
	//
	//for i, resultItem := range result {
	//	fmt.Fprintf(writer, "%s", resultItem)
	//
	//	if i != len(result)-1 {
	//		fmt.Fprintf(writer, "\n")
	//	}
	//}
	//
	//fmt.Fprintf(writer, "\n")
	//
	//writer.Flush()

	str := customSorting([]string{"abc", "ab", "cde", "abcde", "a", "bc", "abcd"})
	for _, s := range str {
		print(s)
	}
}

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
