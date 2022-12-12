package dat5pt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Solution.class.getResource("formatted-input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        Stack<Character>[] stacks = new Stack[10];
        for(int i=1;i<=9;i++) {
            stacks[i] = new Stack<>();
            String val = scanner.nextLine();
            for(char c:val.toCharArray()) stacks[i].push(c);
        }
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] splitted = command.split(" ");
            int count = Integer.parseInt(splitted[1]);
            Stack<Character> charFrom = stacks[Integer.parseInt(splitted[3])];
            Stack<Character> charTo = stacks[Integer.parseInt(splitted[5])];
            for(int i=0;i<count;i++) {
                 if(!charFrom.isEmpty()) {
                     charTo.push(charFrom.pop());
                 }

            }

        }
        String ans = "";
        for(int i=1;i<=9;i++) {
            ans+=stacks[i].peek();
        }
        System.out.println(ans);
    }

}