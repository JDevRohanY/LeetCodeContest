package ArrayAndHashing;

//https://leetcode.com/problems/longest-repeating-character-replacement/
//424. Longest Repeating Character Replacement
public class LongestSubstringWithRepeatChar {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        char[] ch = s.toCharArray();

        int start = 0;
        int end = 0;
        int maxLength = 0;
        int n = ch.length;
        while(end<n){
            //add curr char to freq
            freqArr[ch[end]-'A']++;
            if(end-start+1<=k){
                maxLength = Math.max(end-start+1, maxLength);
                end++;
            }else{
                //check the highest occuring char count
                int hoc = getHighestCount(freqArr);
                if(end-start+1-hoc<=k){
                    maxLength = Math.max(end-start+1, maxLength);
                    end++;
                }else{
                    //reduce from start
                    while(start<end){
                        freqArr[ch[start]-'A']--;
                        start++;
                        //calculate hoc
                        hoc = getHighestCount(freqArr);
                        if(end-start+1-hoc<=k){
                            maxLength = Math.max(end-start+1, maxLength);
                            end++;
                            break;
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    public int getHighestCount(int[] arr){
        //O(26) -> O(1)
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0 && arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
