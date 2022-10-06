package main

import "sync"

type PubSub struct {
	rwLock sync.RWMutex
	subs   map[string][]chan string
}

func NewPubSub() *PubSub {
	return &PubSub{
		rwLock: sync.RWMutex{},
		subs:   map[string][]chan string{},
	}
}

func (ps *PubSub) Publish(topic string, content string) {
	ps.rwLock.RLock()
	defer ps.rwLock.RUnlock()

	for _, channel := range ps.subs[topic] {
		channel <- content
	}
}

func (ps *PubSub) Subscribe(topic string) <-chan string {
	ps.rwLock.Lock()
	defer ps.rwLock.Unlock()

	channel := make(chan string)
	if _, ok := ps.subs[topic]; !ok {
		ps.subs[topic] = make([]chan string, 0)
	}
	ps.subs[topic] = append(ps.subs[topic], channel)
	return channel
}
