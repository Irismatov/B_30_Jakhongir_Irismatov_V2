import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 3:
        System.out.println(findNumOfPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));

        // Task 4:
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        set1.add("olma");
        set1.add("behi");
        set1.add("nok");
        set1.add("tuxum");
        set1.add("guruch");

        set2.add("behi");
        set2.add("nok");
        set2.add("test");
        set2.add("shaftoli");
        set2.add("tuxum");

        System.out.println(set2.contains("olma"));

        set3.add("susambil");
        set3.add("daraxt");
        set3.add("nok");
        set3.add("guruch");
        set3.add("olma");

        HashSet<String> res = mergeSets(set1, set2, set3);
        System.out.println("res = " + res);
    }

    public static HashSet<String> mergeSets(Set<String> set1, Set<String> set2, Set<String> set3) {
        HashSet<String> res = new HashSet<>();
        for (String s : set1) {
            if (set2.contains(s)) {
                res.add(s);
            }
        }
        for (String s : set3) {
            if (set2.contains(s) || set1.contains(s)) {
                continue;
            }
            res.add(s);
        }
        return res;
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