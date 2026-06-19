package ThirtyDayPrep.Day_1;

public class ValidAnagram {
    static void main() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            //add for s, subtract for t
            alphabet[s.charAt(i)-'a']++;
            alphabet[t.charAt(i)-'a']--;
        }

        //check if all are zero or not
        for(int i=0; i<26; i++){
            if(alphabet[i] != 0){
                return false;
            }
        }
        return true;
    }
}
