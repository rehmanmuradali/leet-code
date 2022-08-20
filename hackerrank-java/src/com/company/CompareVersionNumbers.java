package com.company;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {

        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");
        int index = 0;
        while  ((index < v1Parts.length) || (index < v2Parts.length) ) {
            int v1 = 0, v2 = 0;
            if (index < v1Parts.length) {
                v1 = Integer.parseInt(v1Parts[index]);
            }
            if (index < v2Parts.length) {
                v2 = Integer.parseInt(v2Parts[index]);
            }

            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }

            index++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "0.1"));
    }
}
