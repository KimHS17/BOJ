import java.util.*;

class Node {
    public int id;
    public int x;
    public int y;
    public Node left;
    public Node right;
    
    public Node (int id, int x, int y, Node left, Node right) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static int idx = 0;
    static int[][] answer;
    
    public void tree(Node parent, Node child) {
        if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                tree(parent.right, child);
            }
        } else {
            if(parent.left == null) {
                parent.left = child;
            } else {
                tree(parent.left, child);
            }
        }
    }
    
    public void preorder(Node n) {
        if(n != null) {
            answer[0][idx++] = n.id;
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    public void postorder(Node n) {
        if(n != null) {
            postorder(n.left);
            postorder(n.right);
            answer[1][idx++] = n.id;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        answer = new int[2][nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        
        Arrays.sort(node, (a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        
        for(int i = 1; i < node.length; i++) {
            tree(node[0], node[i]);
        }
        
        preorder(node[0]);
        idx = 0;
        postorder(node[0]);
        
        return answer;
    }
}