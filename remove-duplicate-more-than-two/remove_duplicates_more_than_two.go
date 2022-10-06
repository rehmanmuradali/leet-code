package main

import "fmt"

func removeDuplicatesMoreThanTwo(input []int) []int {
	prevCount, prevElement := 1, 0
	for i := 0; i < len(input); i++ {
		if input[i] == prevElement {
			if prevCount >= 2 {
				input = append(input[0:i], input[i+1:]...)
				i--
			} else {
				prevCount++
			}
		} else {
			prevCount = 1
			prevElement = input[i]
		}
	}
	return input
}

func main() {
	list := []int{1, 1, 1, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6}
	fmt.Printf("%v", removeDuplicatesMoreThanTwo(list))
}
