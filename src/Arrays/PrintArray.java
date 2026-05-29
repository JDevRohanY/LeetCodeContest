package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
1
2 3
4 5 6
 */
/*
['1', '2 3', '4 5 6']
 */

public class PrintArray {
    static void main() {
        int n = 5;
        print(n);
    }

    public static List<String> print(int n) {
        int currNumber = 1;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                sb.append(currNumber);
                sb.append(' ');
                currNumber++;
            }
            ans.add(sb.toString().trim());
        }
        return ans;
    }
}
