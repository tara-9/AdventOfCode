package day9pt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        s.main();
        System.out.println(s.ans);
    }
}
class Solution {
    long ans = 0;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Node prev;
    Set<Node> set = new HashSet<>();

    public  void main() throws FileNotFoundException {
        URL url = Solution.class.getResource("input.txt");
        File file = new File(url.getPath());
        Scanner scanner  = new Scanner(file);
        set.add(tail);
        while (scanner.hasNextLine()) {
            prev = head;
            String val = scanner.nextLine();
            String[] splitted = val.split(" ");
            int times = Integer.parseInt(splitted[1]);

            if(val.startsWith("U")) {
                for(int i=0;i<times;i++) {
                    update(head.x-1, head.y);
                }
            } else if(val.startsWith("D")) {
                for(int i=0;i<times;i++) {
                    update(head.x+1, head.y);
                }
            } else if(val.startsWith("L")) {
                for(int i=0;i<times;i++) {
                    update(head.x, head.y-1);
                }
            } else {
                for(int i=0;i<times;i++) {
                    update(head.x, head.y+1);
                }


            }
        }
        ans = set.size();

    }

    public void update(int x, int y) {
        prev = head;
        head = new Node(x,y);
        if(moveTail(head, tail)) {
            tail = new Node(prev.x, prev.y);
            set.add(tail);
        }
    }
    public boolean moveTail(Node head, Node tail) {
        int vd  = Math.abs(head.x - tail.x);
        int hd = Math.abs(head.y -tail.y);

        if(hd > 1 || vd > 1) return true;
        else return false;
    }

    static class Node {
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}