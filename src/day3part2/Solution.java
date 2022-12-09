package day3part2;

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
        Set<Character> s2 = new HashSet<>();
        int lineNo = 0;
        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            lineNo++;
            int len  = val.length();
            if(lineNo % 3 == 0 ) {
                for(char ch:val.toCharArray()) {
                    if(s1.contains(ch) && s2.contains(ch)) {
                        System.out.println(ch);
                        if(Character.isLowerCase(ch)) {
                            ans+= ch - 'a' +1;
                        }
                        else ans += ch- 'A' + 27;
                        s1.clear();
                        s2.clear();
                        break;
                    }
                }
            }
            else if(lineNo % 3 == 1){
                for(char ch: val.toCharArray()) s1.add(ch);
            }
            else if(lineNo % 3 == 2){
                for(char ch: val.toCharArray()) s2.add(ch);
            }

        }
        System.out.println(ans);
    }

}