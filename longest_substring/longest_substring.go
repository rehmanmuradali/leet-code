package main

func main() {

	print(lengthOfLongestSubstring("tmmzuxt"))

}




func lengthOfLongestSubstring(s string) int {

	if len(s) <= 0 {
		return 0
	}
	max := 0
	freq := map[byte]int64{}

	for i, j := 0,0 ; j< len(s) ; j++ {

		if _, ok := freq[s[j]]; !ok  {
			freq[s[j]] = 1
			if max < j-i {
				max = j-i
			}
		} else {
			for s[i] != s[j] {
				delete(freq, s[i])
				i++
			}
			i++
		}

	}
	return max + 1
}