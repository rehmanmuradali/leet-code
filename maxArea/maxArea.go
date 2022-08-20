package main

import (
	"fmt"
)

type Shape interface {
	Area() float64
	Perimeter() float64
}
type Rect struct {
	width  float64
	height float64
}

func (r *Rect) Area() float64 {
	return r.width * r.height
}
func (r Rect) Perimeter() float64 {
	return 2 * (r.width + r.height)
}

func service() {
	fmt.Println("Hello")
}

const (
	i = 7
	j
	k
)

func main() {
	//r := Rect{5.0, 4.01}
	//var s Shape = r
	//area := s.Area()
	//fmt.Println(area)
	//var y = 458
	//var p = &y
	//*p = 500
	//fmt.Println(y)
	//a := []string{"a", "b", "c", "d", "e"}
	//a = nil
	//fmt.Println(a, len(a), cap(a))

	//go service()
	//select {}
	//fmt.Println("tt")
	//a := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	//s := a[2:4]
	//news := append(s, 55, 66)
	//fmt.Printf("len=%d cap= %d", len(news), cap(news))
	//fmt.Println(i)
	//fmt.Println(j)
	//fmt.Println(k)
	//
	//s1 := []int{1, 2}
	//s2 := []int{1, 2}
	//fmt.Println(s1 == s2)

	//var s *int
	//fmt.Println(s)

	//for {
	//	print("a")
	//}
	//
	//var s Shape
	//
	//fmt.Println("value of s is", s)
	//fmt.Printf("type of s is %T", s)

	//var x = 1
	//
	//x := 2

	//fmt.Println(runtime.NumGoroutine())

	//var m map[string]int
	//m["a"] = 1
	//if v, ok := m["b"]; ok {
	//	print(v)
	//}

	//var x = 1
	//x :=

	//c := make(chan string)
	//c <- "John"
	//fmt.Println("B")

	//a := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	//s := a[2:4]
	//s[0] = 33
	//fmt.Println(a[2])

	s2 := []int{1, 2, 3}
	s3 := []int{4, 5, 6, 7}
	n2 := copy(s2, s3)
	fmt.Printf("n2=%d s2 %v s3 %v", n2, s2, s3)

}

type S struct {
	a, b, c string
}
