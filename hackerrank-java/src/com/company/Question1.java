package com.company;


public class Question1 {

    public static void main(String[] args) {
        //System.out.println(winners(new String[]{"Michael Jackson 10 10 10","Fred Astaire 9 9 9"," Anna Pavlova 9 9 10"}));
        System.out.println(lucky_88(-2,90));
    }


    public static Boolean lucky_88( Integer a, Integer b ) {
        //Insert your code here
        return a == 88 || b == 88 || a+b ==88 || a-b == 88 || b-a == 88;
    }







    public static String winners( String[] participantsList ) {
        double [] average = new double[participantsList.length];
        java.util.Map<String, Double> averages = new java.util.LinkedHashMap<String, Double>();
        for(int i = 0; i< participantsList.length; i++) {
            String participant = participantsList[i];
            String[] words = participant.trim().split("\\W+");
            int sumOfScores = 0;
            int numberOfScores = 0;
            StringBuffer participantName = new StringBuffer();
            for(String word: words) {
                try{
                    sumOfScores += Integer.parseInt(word);
                    numberOfScores++;
                } catch (NumberFormatException ex) {
                    participantName.append(word).append(" ");
                }
            }
            averages.put(participantName.toString(), new Double((double) sumOfScores/numberOfScores));
        }

        System.out.println("I am here");
        java.util.Map<String, Double> sortedAverages = averages.entrySet().stream()
                .sorted(java.util.Map.Entry.<String, Double>comparingByValue(java.util.Comparator.reverseOrder()))
                .collect(java.util.stream.Collectors.toMap (java.util.Map.Entry::getKey, java.util.Map.Entry::getValue, (x, y) -> y, java.util.LinkedHashMap::new));


        java.util.Iterator it = sortedAverages.entrySet().iterator();
        int i = 0;
        String[] winners = new String[3];
        Double previousScore = 0.0;

        while(it.hasNext()&&(i < 3)) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            winners[i] =  entry.getKey().toString();
            previousScore = (Double)entry.getValue();
            i++;
        }

        StringBuilder sbWinners = new StringBuilder();
        sbWinners.append("The 1st place:").append(winners[0]).
                append(";The 2nd place:").append(winners[1]).
                append(";The 3rd place:").append(winners[2].trim()).
                append(";");

        return sbWinners.toString();
    }

}
