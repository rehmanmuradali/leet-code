package main

import (
	"fmt"
	"sort"
)

func MinDiff(n int, earnings []int, k int) int {

	sort.Ints(earnings)
	fmt.Printf("%+v", earnings)

	diff := earnings[n-1] - earnings[0]

	for count := 0; count < k; count++ {
	}

	//math.Max()
	return diff
}

func main() {
	a := []int{4, 5, 6, 3, 6}
	print(MinDiff(len(a), a, 3))
}
