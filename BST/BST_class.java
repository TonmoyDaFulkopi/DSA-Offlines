import java.util.Scanner;
import java.io.*;

public class BST_class {

    //node class that defines BST node
    public static class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    // BST root node
    Node root;

    // Constructor for BST =>initial empty tree
    BST_class(){
        root = null;
    }

    //delete a node from BST
    public boolean deleteKey(int key) {
        if(!search(key)){
            System.out.println("Invalid Operation");
            return false;
        }
        root = delete_Recursive(root, key);
        return true;
    }

    //recursive delete function
    private Node delete_Recursive(Node curr_node, int key)  {
        //tree is empty
        if (curr_node == null)  return curr_node;

        //traverse the tree
        if (key < curr_node.key)     //traverse left subtree
            curr_node.left = delete_Recursive(curr_node.left, key);
        else if (key > curr_node.key)  //traverse right subtree
            curr_node.right = delete_Recursive(curr_node.right, key);
        else  {
            // node contains only one child
            if (curr_node.left == null)
                return curr_node.right;
            else if (curr_node.right == null)
                return curr_node.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            curr_node.key = maxValue(curr_node.left);

            // Delete the inorder successor
            curr_node.left = delete_Recursive(curr_node.left, curr_node.key);
        }
        return curr_node;
    }

    private int maxValue(Node root)  {
        //initially maxval = root
        int maxval = root.key;
        //find maxval
        while (root.right != null)  {
            maxval = root.right.key;
            root = root.right;
        }
        return maxval;
    }

    // insert a node in BST
    public void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    private Node insert_Recursive(Node cur_node, int key) {
        //tree is empty
        if (cur_node == null) {
            cur_node = new Node(key);
            return cur_node;
        }
        //traverse the tree
        if (key < cur_node.key)     //insert in the left subtree
            cur_node.left = insert_Recursive(cur_node.left, key);
        else if (key > cur_node.key)    //insert in the right subtree
            cur_node.right = insert_Recursive(cur_node.right, key);
        // return pointer
        return cur_node;
    }

    // method for inorder traversal of BST
    public void inorder() {
        inorder_Recursive(root);
        System.out.println("");
    }

    // recursively traverse the BST
    private void inorder_Recursive(Node curr_node) {
        if (curr_node != null) {
            inorder_Recursive(curr_node.left);
            System.out.print(curr_node.key + " ");
            inorder_Recursive(curr_node.right);
        }
    }

    public void preorder() {
        preorder_Recursive(root);
        System.out.println("");
    }

    public void postorder() {
        postorder_Recursive(root);
        System.out.println("");
    }

    public boolean search(int key)  {
        Node curr_node = search_Recursive(root, key);
//        System.out.println(curr_node.key);
        if (curr_node!= null)
            return true;
        else
            return false;
    }

    //recursive insert function
    private Node search_Recursive(Node curr_node, int key)  {
        // Base Cases: root is null or key is present at root
        if (curr_node==null || curr_node.key==key)
            return curr_node;
        // val is greater than root's key
        if (key < curr_node.key)
            return search_Recursive(curr_node.left, key);
        // val is less than root's key
        return search_Recursive(curr_node.right, key);
    }

    // recursively traverse the BST
    private void postorder_Recursive(Node curr_node) {
        if (curr_node != null) {
            postorder_Recursive(curr_node.left);
            postorder_Recursive(curr_node.right);
            System.out.print(curr_node.key + " ");
        }
    }

    // recursively traverse the BST
    private void preorder_Recursive(Node curr_node) {
        if (curr_node != null) {
            System.out.print(curr_node.key + " ");
            preorder_Recursive(curr_node.left);
            preorder_Recursive(curr_node.right);
        }
    }

    public void print(){
        if(root==null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.key);
        if(root.left!=null || root.right!=null){
            print_recursive(root.left);
            print_recursive(root.right);
        }
        System.out.println("");
    }

    private void print_recursive(Node curr_node)  {
        System.out.print("(");
        if(curr_node!=null){
            System.out.print(curr_node.key);
            if(curr_node.left!=null || curr_node.right!=null){
                print_recursive(curr_node.left);
                print_recursive(curr_node.right);
            }
        }
        System.out.print(")");
    }

    public static void main(String[] args) throws Exception  {
//        Scanner scn = new Scanner(System.in);

        BST_class bst = new BST_class();

        File file=new File("input.txt");    //creates a new file instance
        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream

        String in_str;
        while((in_str=br.readLine())!=null)
        {
            /**
             * Input
             */

            String input1 = in_str.substring(0, 1);
            String int2 = in_str.substring(2);

            if(input1.equalsIgnoreCase("i")){
                int input2 = Integer.parseInt(int2);
                bst.insert(input2);
                bst.print();
            }
            else if(input1.equalsIgnoreCase("d")){
                int input2 = Integer.parseInt(int2);
                boolean ret = bst.deleteKey(input2);
                if(ret) bst.print();
            }
            else if(input1.equalsIgnoreCase("f")){
                int input2 = Integer.parseInt(int2);

                if(bst.search(input2)) System.out.println("True");
                else System.out.println("False");
            }
            else if(input1.equalsIgnoreCase("t")){
                if(int2.equalsIgnoreCase("in"))
                {
                    bst.inorder();
                }
                else if(int2.equalsIgnoreCase("pre"))
                {
                    bst.preorder();
                }
                else if(int2.equalsIgnoreCase("post"))
                {
                    bst.postorder();
                }
            }
        }

    }

}
