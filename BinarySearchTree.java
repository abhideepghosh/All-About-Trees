// All About Binary Search Tree
// Before Using This File, Refactor Name Of The File As Main.java
import java.util.ArrayList;

public class Main {

    // Tree Structure
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    // Insertion In A Binary Search Tree | Time Complexity: O(Height)
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
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

    // Search In A Binary Search Tree | Time Complexity: O(Height)
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left, key);
        }else if(root.data == key){
            return true;
        }else{
            return search(root.right, key);
        }
    }

    // Delete Node In A Binary Search Tree
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }else{ // root.data == val
            // Case 1
            if(root.left == null && root.right == null){
                return null;
            }
            // Case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            // Case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // Delete Node Helper
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    // Print In Range In A Binary Search Tree
    public static void printInRange(Node root, int X, int Y){
        if(root == null){
            return;
        }
        if(root.data >=X && root.data <=Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }else if(root.data >= Y){
            printInRange(root.left, X, Y);
        }else{
            printInRange(root.right, X, Y);
        }
    }

    // Print Root To Leaf Path In A BST
    public static void rootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    // Root To Leaf Path Helper Function
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+ "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int data : values){
            root = insert(root, data);
        }
        System.out.print("Inorder Traversal After Insertion In A BST: ");
        inorder(root);
        System.out.println();
        System.out.println("Search For Key In the Tree: ");
        int key = 10;
        if(search(root, key)){
            System.out.println(key + " Is Present In The BST.");
        }else{
            System.out.println(key + " Is Not Present In The BST.");
        }
        delete(root, 4);
        System.out.print("After Deleting A Node In BST: ");
        inorder(root);
        System.out.println();
        System.out.print("Print In Range: ");
        printInRange(root, 6, 11);
        System.out.println();
        System.out.println("Print All Root To Leaf Paths:");
        rootToLeaf(root, new ArrayList<>());
    }
}
