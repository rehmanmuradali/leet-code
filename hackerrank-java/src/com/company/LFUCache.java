package com.company;

import java.util.HashMap;

public class LFUCache {

    final int capacity;
    int currSize;
    int minFrequency;

    HashMap<Integer , DLLNode > cache;
    HashMap<Integer , DoublyLinkedList > frequencyMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if(node == null){ return -1;}

        updateNode(node);
        return node.value;
    }

    public void put(int key, int value)
    {

        if(capacity == 0){ return; }

        if(cache.containsKey(key))
        {
            DLLNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        }
        else
        {
            currSize++;
            if(currSize > capacity)
            {
                DoublyLinkedList freqList = frequencyMap.get(minFrequency);
                cache.remove(freqList.tail.previous.key);
                freqList.removeNode(freqList.tail.previous);
                currSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            DoublyLinkedList currList = frequencyMap.getOrDefault(1, new DoublyLinkedList() );
            currList.addNode(newNode);

            cache.put(key,newNode);
            frequencyMap.put(1,currList);
        }
    }

    public void updateNode(DLLNode curNode)
    {

        int minFreq = curNode.frequency;
        DoublyLinkedList currList = frequencyMap.get(minFreq);
        currList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (minFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;

        DoublyLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoublyLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency,newList);
    }

    class DLLNode
    {
        int key;
        int value;
        int frequency;
        DLLNode next;
        DLLNode previous;
        public DLLNode(int key, int val)
        {
            this.key = key;
            this.value = val;
            this.frequency = 1;
        }

    }
    class DoublyLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoublyLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.previous = head;
        }

        public void addNode(DLLNode node)
        {
            cache.put(node.key, node);
            DLLNode headNext = head.next;
            head.next = node;
            node.previous = head;
            node.next = headNext;
            headNext.previous = node;
            listSize++;
        }

        public void removeNode(DLLNode node)
        {
            cache.remove(node.key);
            node.previous.next = node.next;
            node.next.previous = node.previous;
            listSize--;
        }

    }



}
