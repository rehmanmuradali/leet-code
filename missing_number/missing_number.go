package main

import "fmt"

func main() {
	num := []int{1, 0, 3}
	fmt.Printf("%v", missingNumber(num))
}

func missingNumber(nums []int) int {
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
	}
	return (len(nums)*(len(nums)+1))/2 - sum
}
