package main

import (
	"fmt"
	"math"
)

func main() {
	num := []int{7, 1, 5, 3, 6, 4}
	// min < max
	// min > max
	//
	fmt.Printf("%v", maxProfit(num))
}

func maxProfit(prices []int) int {
	min := math.MaxInt32
	result := 0
	for i := 0; i < len(prices); i++ {

		if min > prices[i] {
			min = prices[i]
		} else {
			result = int(math.Max(float64(result), float64(prices[i]-min)))
		}
	}
	return result
}
