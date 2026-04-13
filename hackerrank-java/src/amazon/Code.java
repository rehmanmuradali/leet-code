package amazon;

import java.util.Map;

public class Code {
//
//    /*
//     * Given an array, return the first unique element.
//     *
//     * For example, given the array: a, 1, c, 1, a, a, d
//     *
//     * Your method should output: c
//     */
//
//
//    // Hahsmap -> Keep elements -> null ->
//    // If its null ->
//    // dont delete in linkedlist
//    // Doubly LinkedList -> head ->
//    // a , 1 , c , 1, a , a, d
//
//    // 1 -> Node
//    // node.prev -> node.next
//
//
//    // SortedSet
//    //
//    // a, 1, c, 1, a, a, d
//
//    // a ,a ,a,a
//    public Object getFirstUniqueElement (Object[] array) {
//        Map<Object, Object> map = new LinkedHashmap<>();
//        for(int i=0 ; i < array.length(); i++) {
//            if(!map.constainsKey()) {
//                map.put(array[i], array[i])
//            } else {
//                visited.put(array[i], null)
//            }
//        }
//        for(Map.Entry<Object, Object> entry : map.entrySet()){
//            if(entry.getValue() != null) {
//                return entry.getKey();
//            }
//        }
//        return null;
//    }
//
//    /*
//     * How would you restructure your solution if you now needed to read from a stream that never
//     * closed, and you wanted to be able to poll for the first unique element seen so far?
//     *
//     * For example, given the stream: a, 1, c, 1, a, a, d
//     *                                       ^     ^
//     * Your method would output:             a     c
//     */
//
//    // addElement(Object o)
//    // getFirstUnique();
//
//    //
//
//
//
//    //  map -> a 1 c 1 a
//    //  dll -> a 1 c
//
//    // hashmap a-> node in value (doubly linked list node) -> hashmap -> null
//    // not null -> node to be deleted- ->
//    // Doybly Linked List -> value -> node.prev -> node.next
//    //
//
//
//    Node  {
//        Node prev;
//        Node next;
//        Object val;
//    }
//
//    class Solution {
//        Node head;
//        Node tail;
//
//        Map<Object, Node> vistiedItemsMap = new Hashmap<>();
//
//        Solution(){
//            head = new Node();
//            tail = new Node();
//            head.next = tail;
//            tail.prev = head;
//        }
//
//        public addElement(Object val) {
//            if(!map.constainsKey(val)) {
//                Node newNode = new Node(val);
//                addToList(newNode);
//                map.put(array[i], newNode)
//            } else {
//                if (!map.get(val) == null ) {
//                    remove(map.get(val));
//                }
//            }
//
//        }
//
//        public Object getFirstUnique() {
//            return head.next.val;
//        }
//
//        private addToList(Node newNode){
//            // Head -> somthing ...  ,-> lasNode , -> tail
//            Node lastNode = tail.prev;
//            lastNode.next = newNode;
//            newNode.prev = lastNode;
//            newNode.next = tail;
//            tail.prev = newNode;
//        }
//
//        private remove(Node n) {
//            // Head -> somthing ...  ,Prev-> lasNode , -> next
//            Node prev = n.prev;
//            Node next = n.next;
//            prev.next = next;
//            next.prev = prev;
//
//        }
//
//    }
//
//


}
