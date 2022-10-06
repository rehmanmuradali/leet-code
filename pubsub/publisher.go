package main

import "fmt"

type Publisher struct {
	ps *PubSub
	id string
}

func NewPublisher(id string, ps *PubSub) *Publisher {
	return &Publisher{
		ps: ps,
		id: id,
	}
}

func (p *Publisher) Publish(topic string, content string) {
	fmt.Printf("Message sent from publisher %s, topic: %s,  message: %s\n", p.id, topic, content)
	p.ps.Publish(topic, content)
}
