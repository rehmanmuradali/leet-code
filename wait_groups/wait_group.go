package main

import (
	"fmt"
	"io/ioutil"
	"path/filepath"
	"strings"
	"sync"
)

var matches []string
var wg = sync.WaitGroup{}
var loc = sync.Mutex{}

func fileSearch(root string, filename string) {
	fmt.Println("Searching file in ", root)
	files, _ := ioutil.ReadDir(root)
	for _, file := range files {
		if strings.Contains(file.Name(), filename) {
			loc.Lock()
			matches = append(matches, filepath.Join(root, file.Name()))
			loc.Unlock()
		}
		if file.IsDir() {
			wg.Add(1)
			fileSearch(filepath.Join(root, file.Name()), filename)
		}

	}
	wg.Done()
}

func main() {
	wg.Add(1)
	go fileSearch("/Users/rehman/leetcode", "main.go")
	wg.Wait()
	for _, file := range matches {
		fmt.Println("Matched", file)
	}
}
