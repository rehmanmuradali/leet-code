package main

import (
	"strconv"
	"time"
)

func main() {

	topic := "topic1"
	ps := NewPubSub()
	p1 := NewPublisher("p1", ps)
	subs := make([]*Subscriber, 0)
	for i := 0; i < 10; i++ {
		subs = append(subs, NewSubscriber(strconv.Itoa(i), ps))
	}

	for i := 0; i < 10; i++ {
		go subs[i].Subscribe(topic)
	}

	for i := 0; i < 10; i++ {
		p1.Publish(topic, "msg"+strconv.Itoa(i))
		time.Sleep(time.Second)
	}

}
