package day3part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        int ans = 0;
        Set<Character> s1 = new HashSet<>();
        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            int len  = val.length();
            for(char ch:val.substring(0,len/2).toCharArray()) s1.add(ch);
            for(char ch: val.substring(len/2, len).toCharArray()) {
                if(s1.contains(ch)) {
                    System.out.println(ch);
                    if(Character.isLowerCase(ch)) {
                        ans+= ch - 'a' +1;
                    }
                    else ans += ch- 'A' + 27;
                    s1.clear();
                    break;
                }
            }

        }
        System.out.println(ans);
    }

}