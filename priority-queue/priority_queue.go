package main

import (
	"container/heap"
	"fmt"
)

type Node struct {
	x        int
	y        int
	distance int
}

type MinHeap []Node

func (m MinHeap) Len() int {
	return len(m)
}

func (m MinHeap) Swap(i, j int) {
	m[i], m[j] = m[j], m[i]
}

func (m MinHeap) Less(i, j int) bool {
	return m[i].distance < m[j].distance
}

func (m *MinHeap) Push(x interface{}) {
	*m = append(*m, x.(Node))
}

func (m *MinHeap) Pop() interface{} {
	old := *m
	n := len(old)
	*m = old[0 : n-1]
	return old[n-1]
}

func kClosest(points [][]int, k int) [][]int {
	m := MinHeap{}

	for i := 0; i < len(points); i++ {
		node := points[i]
		x := node[0]
		y := node[1]
		distance := x*x + y*y
		heap.Push(&m, Node{
			x,
			y,
			distance,
		})
	}

	output := [][]int{}
	for j := 0; j < k; j++ {
		root := heap.Pop(&m).(Node)
		output = append(output, []int{root.x, root.y})
	}
	return output
}

func main() {
	points := make([][]int, 0)
	points = append(points, []int{3, 3})
	points = append(points, []int{5, -1})
	points = append(points, []int{-2, 4})
	fmt.Printf("%v", kClosest(points, 2))
}
