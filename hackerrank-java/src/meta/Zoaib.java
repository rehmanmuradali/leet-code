package meta;

public class Zoaib {

    public static void main(String[] args) {

        // Two Pointer
        // Start and End
        // Start ko agey barhatey rahi if not letters
        // End ko pechey barhatey rahi if not letters
        //

        System.out.println("Hello");
    }

    public static boolean isPalindrom(String s) {
        int start = 0;
        int end = s.length() - 1;
        while ( start < end ) {
            if(!isValidCharacter(s.charAt(start))){
                start++;
            }
            while(!isValidCharacter(s.charAt(end))){
                end++;
            }

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCharacter(char c) {
        // Ask if only letters allowed????
        return (c >= 'a' && c<='z') || (c >= 'A' && c<='Z');
    }
}
