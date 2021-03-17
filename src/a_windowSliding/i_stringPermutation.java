package a_windowSliding;

import java.util.HashMap;

public class i_stringPermutation {
    /*Permutation in a String (hard) #
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.*/
    public static void main(String[] args) {
        System.out.println(permutate("abcgedf","edc"));
    }

    private static boolean permutate(String word, String value) {
        int start = 0, matched =0;
        HashMap<Character, Integer> chars = new HashMap<>();
        for(char c : value.toCharArray()) chars.put(c, chars.getOrDefault(c, 0)+1);
        for (int end = 0; end < word.length(); end++) {
            char c = word.charAt(end);
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c)-1);
                if(chars.get(c) == 0) matched++;
            }
            if(matched == chars.size()) return true;
            if(end >= value.length()-1){
                char d = word.charAt(start ++);
                if(chars.containsKey(d)){
                    if(chars.get(d) == 0 ) matched --;
                    chars.put(d, chars.get(d)+1);
                }
            }
        }
        System.out.println(chars);
        return false;
    }
}
