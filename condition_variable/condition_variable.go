package main

import (
	"sync"
	"time"
)

var (
	money     = 10
	lock      = sync.Mutex{}
	moneyCond = sync.NewCond(&lock)
)

func stingy() {

	for i := 0; i < 1000; i++ {
		lock.Lock()
		money += 10
		println("Stingy sees balance of: ", money)
		moneyCond.Signal()
		lock.Unlock()
		time.Sleep(1 * time.Millisecond)
	}
	println("Spendy Done")
}

func spendy() {
	for i := 0; i < 1000; i++ {
		lock.Lock()
		for money-20 < 0 {
			moneyCond.Wait()
		}
		money -= 20
		println("Spendy sees balance of: ", money)
		lock.Unlock()
		time.Sleep(1 * time.Millisecond)
	}
	println("Stringy Done")
}

func main() {
	go stingy()
	go spendy()
	time.Sleep(3000 * time.Millisecond)
}
