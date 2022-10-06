package main

import (
	"fmt"
	"strings"
)

func main() {

	// GO throgh
	fmt.Printf(snakeCaseToCamelCase("chutya_banaya"))
}

func snakeCaseToCamelCase(inputUnderScoreStr string) (camelCase string) {
	// SPlIT BY '_'
	words := strings.Split(inputUnderScoreStr, "_")
	for pos, word := range words {
		// IF ITS FIRST POSITION THEN add that word
		if pos == 0 {
			camelCase += word
			continue
		}
		// FOR OTHER CASE:

		camelCase = camelCase +
			//Capitilize firt letter
			strings.ToUpper(word[:1]) +
			// Use Remaining Part word[1:]
			word[1:]
	}
	return

}
