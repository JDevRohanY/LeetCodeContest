package ArrayAndHashing;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> sFreq = new HashMap<>();

        int have = 0;
        int need = 0;

        //fill the tFreq map
        for(char c: t.toCharArray()){
            tFreq.put(c, tFreq.getOrDefault(c,0)+1);
        }
        //calculate need too
        need = tFreq.size();

        //now we will iterate on s
        int start = 0;
        int end = 0;

        int minLength = Integer.MAX_VALUE;
        int ansStart = 0;
        while(start<n && end <n){
            //update the char in freq map
            char currChar = s.charAt(end);
            sFreq.put(currChar, sFreq.getOrDefault(currChar, 0) +1);

            //check the sFreq with tfreq
            if(tFreq.containsKey(currChar) && sFreq.get(currChar).equals(tFreq.get(currChar))){
                have++;
            }

            //now check have == need
            while(have == need){
                if(end-start+1<minLength){
                    minLength = end-start+1;
                    ansStart = start;
                }

                //shrink from left
                char startC = s.charAt(start);
                sFreq.put(startC, sFreq.get(startC) - 1);
                if (tFreq.containsKey(startC) && tFreq.get(startC) < tFreq.get(startC)) {
                    have--;
                }
                start++;
            }

            end++;
        }

        return minLength == Integer.MAX_VALUE? "" : s.substring(ansStart, ansStart + minLength);
    }
}
