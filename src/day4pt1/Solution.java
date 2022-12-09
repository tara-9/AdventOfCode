package day4pt1;

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
        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            String[] pairs = val.split(",");
            String[] s1 = pairs[0].split("-");
            String[] s2 = pairs[1].split("-");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s2[0]);
            int d = Integer.parseInt(s2[1]);
            if(a <= c && b >= d) ans++;
            else if(c <= a  && d>=b ) ans++;
        }
        System.out.println(ans);
    }

}