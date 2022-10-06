package main

import (
	"math"
	"strings"
)

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(S string, T string) bool {
	// write your code in Go 1.4
	S = transformInput(S)
	T = transformInput(T)

	if len(S) != len(T) {
		return false
	}

	for i := 0; i < len(S); i++ {
		if !(S[i] == '?') && !(T[i] == '?') && (S[i] != T[i]) {
			return false
		}
	}
	return true
}

func transformInput(S string) string {
	builder := strings.Builder{}
	var N = len(S)
	for i := 0; i < N; {
		var startNumber = i
		for i < N && S[i] >= '0' && S[i] <= '9' {
			i++
		}
		number := 0
		if startNumber < i {
			number = myAtoi(S[startNumber:i])
		}
		if number > 0 {
			for j := 0; j < number; j++ {
				builder.Write([]byte("?"))
			}
		} else {
			builder.Write([]byte(S[i : i+1]))
			i++
		}
	}
	return builder.String()
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

//func main() {
//	print(Solution("a10", "10a"))
//	print(Solution("A2Le", "2pL1"))
//	print(Solution("ba1", "1Ad"))
//}
