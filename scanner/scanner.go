package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	testCasesString, _ := reader.ReadString('\n')
	testCasesString = strings.Replace(testCasesString, "\n", "", -1)
	tt, _ := strconv.Atoi(testCasesString)

	sentences := make([]string, 0)
	for i := 0; i < tt; i++ {
		sentence, _ := reader.ReadString('\n')
		sentence = strings.Replace(sentence, "\n", "", -1)
		sentences = append(sentences, sentence)
	}

	for _, sentence := range sentences {

		words := strings.Fields(sentence)
		result := ""
		for i := len(words) - 1; i >= 0; i-- {
			result += words[i] + " "
		}
		strings.Trim(result, " ")
		fmt.Println(result)
	}

}
