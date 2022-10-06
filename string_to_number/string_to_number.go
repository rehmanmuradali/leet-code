package main

import (
	"math"
	"strings"
)

func main() {
	print(myAtoi("-0012a42"))
}

func myAtoi(s string) int {
	num := int64(0)
	s = strings.TrimSpace(s)
	if len(s) <= 0 {
		return 0
	}
	mul := 1
	if s[0] == '-' {
		mul = -1
	}
	if s[0] == '-' || s[0] == '+' {
		s = s[1:]
	}

	for _, b := range s {
		diff := b - '0'
		if diff > 9 || diff < 0 {
			return int(num) * mul
		}
		num = num*10 + int64(diff)
		if mul < 0 {
			if num > math.MaxInt32+1 {
				return math.MinInt32
			}
		} else {
			if num > math.MaxInt32 {
				return math.MaxInt32
			}
		}
	}
	return int(num) * mul
}
