package main

import "fmt"

type Subscriber struct {
	ps *PubSub
	id string
}

func NewSubscriber(id string, ps *PubSub) *Subscriber {
	return &Subscriber{
		id: id,
		ps: ps,
	}
}

func (s *Subscriber) Subscribe(topic string) {
	for msg := range s.ps.Subscribe(topic) {
		fmt.Printf("Message from subscriber %s, topic: %s,  message: %s\n", s.id, topic, msg)
	}
}
