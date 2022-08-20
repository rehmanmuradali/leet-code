package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emirate extends Thread
{
    public void run()
    {
        System.out.println("Before start method");
        this.stop();
        System.out.println("After stop method");
    }
    public static void main(String[] args)
    {
//        String line = "IOException|The file requested does not exist";
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("IOException", "High|100|");
//        map.put("MemoryException", "High|110|");
//        map.put("ThreadAbortException", "Medium|200|");
//        map.put("ResponseTimeoutException", "Low|300|");
//        map.put("ParameterException", "Low|301|");
//
//
//        String[] param = line.split("\\|");
//        System.out.println("param[0]: " +  param[0]);
//        System.out.println(map.get(param[0]) + line );

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.]+@[a-z-]+.[com|net|org]{1,}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("good123@bad.com");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

    }
}
