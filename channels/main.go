package main

import "time"

func main() {

	var a = make(chan int)
	go abc(a)

	for abc := range a {
		print(abc)
	}

}

func abc(a chan<- int) {
	var i = 0
	for {
		a <- i
		i++
		time.Sleep(time.Second * 1)
		if i == 10 {
			close(a)
			break
		}
	}
}
