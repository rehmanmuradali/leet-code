package main

import (
	"strings"
)

func main() {
	print(numberToWords(0))
}

var numberToString = map[int]string{
	0:   "Zero",
	1:   "One",
	2:   "Two",
	3:   "Three",
	4:   "Four",
	5:   "Five",
	6:   "Six",
	7:   "Seven",
	8:   "Eight",
	9:   "Nine",
	10:  "Ten",
	11:  "Eleven",
	12:  "Twelve",
	13:  "Thirteen",
	14:  "Fourteen",
	15:  "Fifteen",
	16:  "Sixteen",
	17:  "Seventeen",
	18:  "Eighteen",
	19:  "Nineteen",
	20:  "Twenty",
	30:  "Thirty",
	40:  "Forty",
	50:  "Fifty",
	60:  "Sixty",
	70:  "Seventy",
	80:  "Eighty",
	90:  "Ninety",
	100: "Hundred",
}
var multipleOfThousands = []int{1000000000, 1000000, 1000, 1}
var multipleOfThousandsInWords = []string{"Billion", "Million", "Thousand", ""}

func numberToWords(num int) string {
	if num == 0 {
		return "Zero"
	}

	var result = ""
	for i := range multipleOfThousands {
		if num/multipleOfThousands[i] > 0 {

			var prefix = num / multipleOfThousands[i]
			result = result + strings.Trim(numberToWordsPerThousand(prefix), " ") + " " + multipleOfThousandsInWords[i] + " "
			num = num - (prefix * multipleOfThousands[i])
		}
	}
	return strings.Trim(result, " ")
}

func numberToWordsPerThousand(num int) string {
	var result = ""
	var hundredth = num / 100
	if hundredth > 0 {
		result = result + numberToString[hundredth] + " Hundred "
	}

	num -= hundredth * 100
	if num < 20 {
		result = result + numberToString[num]
		return result
	}

	var unit = num % 10
	var tens = (num / 10) * 10
	if tens > 0 {
		result = result + numberToString[tens] + " "
	}

	if unit > 0 {
		result = result + numberToString[unit] + " "
	}

	return strings.Trim(result, " ")
}
