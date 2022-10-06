package main

import "fmt"

type deck []string

func (d deck) doSomething() {

}

//func (d deck) String() string {
//	return "a"
//}

func main() {

	deckInstance := deck{"abc", "def"}
	deckInstance = append(deckInstance, "hij")
	fmt.Printf("%v", deckInstance)

}
