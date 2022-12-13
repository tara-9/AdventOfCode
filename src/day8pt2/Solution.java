package day8pt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        s.main();
        System.out.println(s.ans);
    }
}
// Phew. A tricky one bcz of this(basically a directory with same name can refer another directory with same name
// Even though they are same name they are different. So if we use Map<String, Integer> to map size it will be wrong

/** a
 *     x
*      a
 *       y
 *       a
 *         z
 */
class Solution {
    long ans = 0;
    List<List<Integer>> grid = new ArrayList<>();
    public  void main() throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);

        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            readLine(val);
        }

        int m = grid.size();
        int n = grid.get(0).size();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++){
                if(i == 0 || j== 0 || i== m-1 || j == n-1) {
                    continue;
                }
                else {
                    int s = grid.get(i).get(j);
                    int left = 0;
                    int right = 0;
                    int top= 0;
                    int bottom = 0;
                    for(int k=i-1;k>=0;k--) {
                        int num = grid.get(k).get(j);
                        top++;
                        if(num >= s) {
                            break;
                        }
                    }
                    for(int k=i+1;k<m;k++) {
                        bottom++;
                        int num = grid.get(k).get(j);
                        if(num >= s) {
                            break;
                        }
                    }
                    for(int k=j+1;k<n;k++) {
                        right++;
                        int num = grid.get(i).get(k);
                        if(num >= s) {
                            break;
                        }
                    }
                    for(int k=j-1;k>=0;k--) {
                        left++;
                        int num = grid.get(i).get(k);
                        if(num >= s) {
                            break;
                        }
                    }
                    ans = Math.max(ans, left*right*top*bottom);
                }

            }

        }

    }

    public void readLine(String val) {
        List<Integer> data = new ArrayList<>();
        for(char ch:val.toCharArray()) {
            Integer i = Character.getNumericValue(ch);
            data.add(i);
        }
        grid.add(data);
    }

}