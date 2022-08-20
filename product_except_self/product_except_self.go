package main

import "fmt"

func main() {
	nums := []int{1, 2, 3, 4}
	fmt.Printf("%v", productExceptSelf(nums))

}

func productExceptSelf(nums []int) []int {

	prefixProduct := make([]int, len(nums)+2)
	suffixProduct := make([]int, len(nums)+2)
	result := make([]int, len(nums))
	prefixProduct[0] = 1
	suffixProduct[len(nums)+1] = 1

	for i := 1; i < len(nums); i++ {
		prefixProduct[i] = prefixProduct[i-1] * nums[i-1]
	}

	for i := len(suffixProduct) - 2; i > 0; i-- {
		suffixProduct[i] = suffixProduct[i+1] * nums[i-1]
	}

	for i := 0; i < len(nums); i++ {
		result[i] = prefixProduct[i] * suffixProduct[i+2]

	}
	return result
}
