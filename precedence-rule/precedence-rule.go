package main

import "strings"

func main() {
	input := []string{"R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G"}
	print(findWord(input))

}

func findWord(rules []string) string {

	dac := map[string]string{}
	endingLetters := map[string]struct{}{}

	for _, rule := range rules {
		params := strings.Split(rule, ">")
		dac[params[0]] = params[1]
		endingLetters[params[1]] = struct{}{}
	}

	var head = ""
	for k := range dac {
		if _, ok := endingLetters[k]; !ok {
			head = k
			break
		}
	}

	result := ""
	for {
		_, ok := dac[head]
		if !ok {
			result += head
			break
		}
		result += head
		head = dac[head]
	}

	return result
}
