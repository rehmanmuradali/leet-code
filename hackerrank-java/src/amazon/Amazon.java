package amazon;

import java.util.*;

public class Amazon {


    class Node {
        String time;
        String customerId;
        String page;

    }

    public static void main(String[] args) {
        Map<String, Integer> occurrenceOfSequence = new HashMap<>();
        Map<String, List<String>> customerMap = new HashMap<>();
        Node[] nodes = new Node[3];


        // Traverse all the logs
        // for each logs
        //      create map -> userId, sequence of visited pages
        //
        for (Node node:
                nodes) {
            List<String>  userList = customerMap.getOrDefault(node.customerId, new ArrayList<>());
            userList.add(node.page);
        }

        // for each user
        //          for each seq
        //              get 3 nodes and put that in map. (occurrence)
        //
        for (Map.Entry<String, List<String>> userVisited:
             customerMap.entrySet()) {
            List<String> pages = userVisited.getValue();

            // if user visited less then 3 pages then just continue
            if (pages.size() < 3) {
                continue;
            }
            // Because we need group of 3 pages

            for(int i=2; i<pages.size(); i++ ) {
                //              get 3 nodes and put that in map. (occurrence
                String firstPage = pages.get(i-2);
                String secondPage = pages.get(i-1);
                String thirdPage = pages.get(i);
                String key = firstPage + secondPage + thirdPage;
                occurrenceOfSequence.put(key,occurrenceOfSequence.getOrDefault(key, 0) + 1);
            }

        }

        // Get max occurrence
        // Now we will have occurrence of each sequnce
        // Lets get maximum of each seuquence
        int max = Integer.MIN_VALUE;
        String maxSeq = "";
        for (Map.Entry<String, Integer> seqOccurrence:
                occurrenceOfSequence.entrySet()) {

            if (max < seqOccurrence.getValue()) {
                max = seqOccurrence.getValue();
                maxSeq = seqOccurrence.getKey();
            }
        }
        // return max sequnce
        //return maxSeq;

    }


}
