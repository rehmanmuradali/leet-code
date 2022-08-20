package main

//func canMakePaliQueries(s string, queries [][]int) []bool {
//	n := len(queries)
//	ans := make([]bool, n)
//
//	prefix := make([][]int, 26)
//	for row := range prefix {
//		prefix[row] = make([]int, len(s)+1)
//
//		for i := 1; i <= len(s); i++ {
//			if s[i-1] == string('a' + row)[0] {
//				prefix[row][i] = prefix[row][i-1] + 1
//			} else {
//				prefix[row][i] = prefix[row][i-1]
//			}
//		}
//	}
//
//	for i := 0; i < n; i++ {
//		l, r := queries[i][0], queries[i][1]
//
//		odds := 0
//		for i := 0; i < 26; i++ {
//			if (prefix[i][r+1]-prefix[i][l])%2 == 1 {
//				odds += 1
//			}
//		}
//
//		if odds/2 <= queries[i][2] {
//			ans[i] = true
//		}
//	}
//
//	return ans
//}

func palindromeChecker(s string, startIndex []int32, endIndex []int32, subs []int32) string {
	// Write your code here
	n := len(startIndex)
	result := make([]byte, n)
	for i := 0; i < len(startIndex); i++ {
		result[i] = '0'
	}

	prefix := make([][]int, 26)
	for row := range prefix {
		prefix[row] = make([]int, len(s)+1)

		for i := 1; i <= len(s); i++ {
			if s[i-1] == string(rune('a' + row))[0] {
				prefix[row][i] = prefix[row][i-1] + 1
			} else {
				prefix[row][i] = prefix[row][i-1]
			}
		}
	}

	for i := 0; i < n; i++ {
		start, end := startIndex[i], endIndex[i]

		odds := int32(0)
		for i := 0; i < 26; i++ {
			if (prefix[i][end+1]-prefix[i][start])%2 == 1 {
				odds += 1
			}
		}

		if odds/2 <= subs[i] {
			result[i] = '1'
		}
	}

	return string(result[:])
}

func main() {

	//var startIndex = []int32{1, 2, 1}
	//var endIndex = []int32{3, 3, 1}
	//var subs = []int32{2, 0, 0}
	//print(palindromeChecker("bcba", startIndex, endIndex, subs))

	//var startIndex = []int32{0, 2, 1}
	//var endIndex = []int32{3, 3, 3}
	//var subs = []int32{0, 2, 2}
	//print(palindromeChecker("cbac", startIndex, endIndex, subs))

	var startIndex = []int32{1, 1, 2}
	var endIndex = []int32{4, 3, 3}
	var subs = []int32{3, 3, 0}
	print(palindromeChecker("bcbab", startIndex, endIndex, subs))
}
