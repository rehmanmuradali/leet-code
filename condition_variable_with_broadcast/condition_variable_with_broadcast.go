package main

import (
	"fmt"
	"strconv"
	"sync"
	"time"
)

var (
	money     = 10
	rwMutex   = sync.Mutex{}
	moneyCond = sync.NewCond(&rwMutex)
)

func stingy(id string) {

	for i := 0; i < 1000; i++ {
		rwMutex.Lock()
		money += 10
		fmt.Printf("Stingy %s sees balance of: %d\n", id, money)
		moneyCond.Broadcast()
		rwMutex.Unlock()
		time.Sleep(1 * time.Millisecond)
	}
	println("Spendy Done")
}

func spendy(id string) {

	for i := 0; i < 1000; i++ {
		rwMutex.Lock()
		for money-20 < 0 {
			moneyCond.Wait()
		}
		money -= 20
		fmt.Printf("Spendy %s sees balance of: %d\n", id, money)
		rwMutex.Unlock()
		time.Sleep(1 * time.Millisecond)
	}
	println("Stringy Done")
}

func main() {

	for i := 0; i < 5; i++ {
		go stingy(strconv.Itoa(i))
		go spendy(strconv.Itoa(i))
	}

	time.Sleep(3000 * time.Millisecond)
}
