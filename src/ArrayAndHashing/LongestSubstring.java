package ArrayAndHashing;
//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int n = s.length();
        int longest = 0;
        int start = 0;
        int end = 0;
        while(start<n && end<n){
            if(arr[s.charAt(end)]==0){
                //this char is unique
                arr[s.charAt(end)]++;
                //calculate length
                longest = Math.max(longest, end-start+1);
                end++;
            }else{
                arr[s.charAt(start)]--;
                start++;
            }
        }
        return longest;
    }
}
