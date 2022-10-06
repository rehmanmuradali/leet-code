package main

// Point out a potential issue with this code and how would you solve in go

import (
	"errors"
	"fmt"
	"os"
)

func main() {
	p := "/tmp/path_question1.txt"

	var f *os.File
	var err error

	if f, err = os.Create(p); err != nil {
		// Can we return that as  error ?
		// Add logs
		panic(err)
	}
	defer closeFile(f)

	if err = writeFile(f, "some data"); err != nil {
		// Add logs
		panic(err)
	}
}

// program continues doing other things ...

func writeFile(f *os.File, s string) error {
	_, err := fmt.Fprintln(f, s)
	// we fake the error for the sake of this example
	err = errors.New("something happens here")
	return err
}

func closeFile(f *os.File) {
	fmt.Println("closing")
	err := f.Close()

	if err != nil {
		fmt.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}
