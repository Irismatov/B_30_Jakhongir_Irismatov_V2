import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Task 3:
        System.out.println(findNumOfPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
    }

    public static int findNumOfPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (Objects.equals(words[i], reverseWord(words[j]))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String reverseWord(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }
}