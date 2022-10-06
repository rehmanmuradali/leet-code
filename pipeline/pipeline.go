package main

import (
	"fmt"
	"io/ioutil"
	"path/filepath"
	"strings"
	"sync"
)

var wg = sync.WaitGroup{}

func fileSearch(root string, filename string, fileChan chan<- string) {
	fmt.Println("Searching file in ", root)
	files, _ := ioutil.ReadDir(root)
	for _, file := range files {
		if strings.Contains(file.Name(), filename) {
			fileChan <- filepath.Join(root, file.Name())
		}
		if file.IsDir() {
			wg.Add(1)
			fileSearch(filepath.Join(root, file.Name()), filename, fileChan)
		}

	}
	wg.Done()
}

func filePrint(fileChan <-chan string) {
	for file := range fileChan {
		println("Found file", file)
	}
}

func main() {
	wg.Add(1)
	fileChan := make(chan string)
	go fileSearch("/Users/rehman/leetcode", "main.go", fileChan)
	go filePrint(fileChan)
	wg.Wait()
	close(fileChan)
}
