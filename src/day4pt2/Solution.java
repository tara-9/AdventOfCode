package day4pt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;


class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        int ans = 0;
        int total = 0;
        while (scanner.hasNextLine()) {
            total++;
            String val = scanner.nextLine();
            String[] pairs = val.split(",");
            String[] s1 = pairs[0].split("-");
            String[] s2 = pairs[1].split("-");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s2[0]);
            int d = Integer.parseInt(s2[1]);
            if(b < c || d < a) ans++;
        }
        System.out.println(total-ans);
    }

}