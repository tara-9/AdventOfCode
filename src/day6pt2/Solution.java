package day6pt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Sliding Window
class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        int ans = 0;
        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            char[] ch = val.toCharArray();
            int n = val.length();
            boolean repeat = true;

            for(int i=0;i<n-13;i++) {
                Set<Character> set = new HashSet<>();
                for(int j=0;j<14;j++) {
                    set.add(ch[i+j]);
                }
                if(set.size() == 14) {
                    ans = i+14;
                    break;
                }
                set.clear();
            }

        }
        System.out.println(ans);
    }

}