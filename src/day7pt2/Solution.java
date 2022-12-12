package day7pt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
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
    int ans = 0;
    public  void main() throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        List<Node> nodes = new ArrayList<>(); // Important
        // Don't Use Map<String, Integer>
        Stack<Node> cwd = new Stack<>();
        while (scanner.hasNextLine()) {
            String val = scanner.nextLine();
            String[] splitted = val.split(" ");
            if(val.startsWith("$ ls")) continue;
            if(val.startsWith("$ cd")) {
                if(val.contains("/")) {
                    Node root = new Node("root", 0);
                    nodes.add(root);
                    cwd.clear();
                    cwd.push(root);
                }
                else if(val.contains("..")) {
                    cwd.pop();
                } else {
                    String name = splitted[2];
                    Node n =  new Node(name, 0);
                    nodes.add(n);
                    cwd.push(n);
                }
            }

            else{
                if(!val.startsWith("dir")) {
                    int size = Integer.parseInt(splitted[0]);
                    for(Node n:cwd) {
                        n.size+=size;
                    }
                }
            }
        }
        Node root = nodes.get(0);
        int required = 30000000- (70000000 - root.size);
        System.out.println(required);
        ans = 30000000;
        for(Node n:nodes) {
            if(n.size >= required) ans = Math.min(ans, n.size);
        }

    }

    static class Node{
        String name;
        int size;
        List<Node> childs;

        public Node(String name, int size) {
            this.name = name;
            this.size = size;
            this.childs = new ArrayList<>();
        }
        public void addChild(Node e) {
            this.childs.add(e);
        }
    }

}