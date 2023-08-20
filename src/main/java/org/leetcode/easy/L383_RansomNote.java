package org.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class L383_RansomNote {

    @Test
    public void ransomNoteTest() {
        System.out.println(canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));    // true
        System.out.println(canConstruct("bg", "bbbggg"));    // true
        System.out.println(canConstruct("aa", "ab"));    // false
        System.out.println(canConstruct("aa", "aab"));   // true
        System.out.println(canConstruct("a", "b"));      // false

        // singleMap
        System.out.println(canConstruct_singleMap("aa", "a"));      // false
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomNoteMap = frequencyMap(ransomNote);
        HashMap<Character, Integer> magazineMap = frequencyMap(magazine);

        for (Character ch : ransomNote.toCharArray()) {
            if ( !magazineMap.containsKey(ch) &&
                    !(ransomNoteMap.get(ch) <= magazineMap.get(ch)) )  {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> frequencyMap(String string) {
        char[] chars = string.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        return map;
    }


    public static boolean canConstruct_singleMap(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = frequencyMap(magazine);

        for (char c : ransomNote.toCharArray()) {
            if ( !magazineMap.containsKey(c)
                    || magazineMap.get(c) <= 0 ) {
                return false;
            }
            magazineMap.put(c, magazineMap.get(c) - 1);
        }
        return true;
    }

}
