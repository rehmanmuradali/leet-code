package huspy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Huspy {

    List<Node> nodes;

    class Node {
        Integer id;
        String name;

        Integer parentId;
        List<Node> children;

        public Node(Integer id, String name, List<Node> children, Integer parentId) {
            this.id = id;
            this.name = name;
            this.children = children;
            this.parentId = parentId;
        }

        public List<Node> getChildren() {
            return children;
        }
    }


    public List<Node> getNodes() {
        return nodes;
    }

    public void addNodes(Integer id, String name, List<Node> childs, Integer parentId){
        nodes.add(new Node(id, name, childs, parentId));
    }

    public static void main(String[] args) {
        Huspy h = new Huspy();
        h.addNodes(1, "CEO", null, null);
        h.addNodes(1, "CTO", null, null);

        List<Node> persons = h.getNodes();

        // Create adjancy matrix
//        List<List<Node>> adjMatric =
//                Parent ->   Children
//                            for each children


        // First find node with Parent Null
        Node parent = null;
        for (int i = 0 ; i< persons.size(); i++) {
            if (persons.get(i).parentId == null) {
                parent = persons.get(i);
            }
        }



    }

//    public print(Node parent) {
//
//
//    }

    public static String reverseWord(String input) {

        String[] words = input.split(" ");
        for (int i=0; i< words.length ; i++ ) {
            if(words.length % 2 != 0) {
                words[i] = reverseString(words[i]);
            }
        }
        return  String.join(" ", words);
    }

    public static String reverseString(String input){
        char[] arr = input.toCharArray();
        int start = 0;
        int end = input.length() - 1;
        while(start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(arr);
    }
}
