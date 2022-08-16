// All About Binary Tree
// Before Using This File, Refactor Name Of The File As Main.java
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Tree Nodes
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Build Tree
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // Preorder Traversal
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data +" ");
    }

    // Level Order Traversal
    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Count The Number Of Nodes In A Binary Tree
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    // Sum Of The Nodes In A Binary Tree
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int sumLeft = sumOfNodes(root.left);
        int sumRight = sumOfNodes(root.right);
        return sumLeft + sumRight + root.data;
    }

    // Height Of The Tree
    public static int heightOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodesHeight = heightOfNodes(root.left);
        int rightNodesHeight = heightOfNodes(root.right);
        int maxHeight = Math.max(leftNodesHeight, rightNodesHeight) + 1;
        return maxHeight;
    }

    /*
    // Diameter Of The Tree O(n^2) Approach
    public static int diameterOfTreeOn2(Node root){
        if(root == null){
            return 0;
        }
        int diameter1 = diameterOfTreeOn2(root.left);
        int diameter2 = diameterOfTreeOn2(root.right);
        int diameter3 = heightOfNodes(root.left) + heightOfNodes(root.right) + 1;
        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }
    */


    //Diameter Of The Tree O(n) Approach
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameterOfTree(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameterOfTree(root.left);
        TreeInfo right = diameterOfTree(root.right);
        int myHeight = Math.max(left.ht, right.ht) + 1;
        int diameter1 = left.diam;
        int diameter2 = right.diam;
        int diameter3 = left.ht + right.ht + 1;
        int myDiameter = Math.max(Math.max(diameter1,diameter2), diameter3);
        TreeInfo myTreeInfo = new TreeInfo(myHeight, myDiameter);
        return myTreeInfo;
    }

    public static void main(String[] args){
        System.out.println("All About Binary Trees");
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root: " + root.data);
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
        System.out.println("Level Order Traversal: ");
        levelorder(root);
        System.out.println("Count The Number Of Nodes In A Binary Tree: " + countOfNodes(root));
        System.out.println("Sum Of The Nodes In A Binary Tree: " + sumOfNodes(root));
        System.out.println("Height Of The Binary Tree: " + heightOfNodes(root));
        System.out.println("Diameter Of The Binary Tree: " + diameterOfTree(root).diam);
    }
}
