import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root=null;
    }

    public static void main(String[] args) {

        BinaryTree newBST = new BinaryTree();
        //newBST.choices();
        newBST.add(5);
        newBST.add(2);
        newBST.add(1);
        newBST.printInOrder();
        newBST.delete(1);
        newBST.printInOrder();
    }


    public void choices(){
        Scanner in = new Scanner(System.in);
        int sel=0;
        while (sel!=4)  {
            System.out.println("1: Insert in BST, 2: Print in order, 3: Delete node, 4: Exit");
            sel = in.nextInt();
            if (sel==1) {
                System.out.println("Give integer to enter");
                int data = in.nextInt();
                if(!this.add(data))
                    System.out.println("Integer exists in tree, add another one");
            }
            if (sel==2){
                System.out.println("Tree:");
                this.printInOrder();
            }
            if (sel==3){
                System.out.println("Give integer to delete");
                int datadel = in.nextInt();
                this.delete(datadel);
            }
            if (sel==4)
                System.out.println("Exiting\n");
            if (sel!=4)
                System.out.println("\nGive next selection:");
        }

    }

    public boolean add(int data){
        if (!check(data)){
            this.addNode(root,data);
            return true;
        }
        return false;
    }

    public void delete(int datadel){
        if (this.check(datadel)) {
            this.deleteNode(root, datadel);
            System.out.println("Node with key " + datadel + " got deleted.");
        }
        else
            System.out.println("Didn't find node with key "+ datadel + " in tree, try another one.");
    }


    private void addNode(Node x, int data) {
        if (root==null) {
            Node newNode = new Node(data);
            root=newNode;
        }
        else {
            if (data > x.key) {
                if (x.right != null) {
                    addNode(x.right, data);
                } else {
                    Node newNode = new Node(data);
                    x.right = newNode;
                    newNode.parent = x;
                }
            }
            if (data < x.key) {
                if (x.left != null) {
                    addNode(x.left, data);
                } else {
                    Node newNode = new Node(data);
                    x.left = newNode;
                    newNode.parent = x;
                }
            }
        }
    }

    public boolean check(int data){
        return check(root,data);
    }

    private boolean check(Node x, int data){

        if (x==null)
            return false;
        else {
            if (x.left != null && x.key > data)
                return check(x.left,data);
            else if (x.right != null && x.key < data)
                return check(x.right,data);
            if (x.key==data)
                return true;
            return false;
        }
    }

    public void printInOrder(){
        System.out.println("Tree:");
        printInOrder(root);
    }

    private void printInOrder(Node x) {
        if (x==null)
            System.out.println("Empty BST");
        else{
            if (x.left!=null)
                printInOrder(x.left);
            System.out.print(x.key+"\n");
            if (x.right!=null)
                printInOrder(x.right);
        }
    }

    private void deleteNode(Node x, int data){

        if (x.right!=null && x.key<data)
            deleteNode(x.right,data);
        if (x.left!=null && x.key>data)
            deleteNode(x.left,data);
        if (x.key==data){
            if (x.left==null && x.right==null){
                if (x==root)
                    root=null;
                else if (x.parent.key < x.key)
                    x.parent.right=null;
                else
                    x.parent.left=null;
            }
            else if (x.left!=null && x.right==null){
                if (x==root) {
                    root=x.left;
                    x.left.parent=x.left;
                }
                else if (x.parent.key < x.key)
                    x.parent.right=x.left;
                else
                    x.parent.left=x.left;
                x.left.parent=x.parent;
            }
            else if (x.right!=null && x.left==null){
                if (x==root){
                    root=x.right;
                    x.right.parent=x.right;
                }
                else if (x.parent.key < x.key) {
                    x.parent.right=x.right;
                }
                else
                    x.parent.left=x.right;
                x.right.parent=x.parent;
            }
            else{
                Node pred = findPredecessor(x.left);
                x.key=pred.key;
                deleteNode(pred, pred.key);
            }
        }
    }

    private Node findPredecessor(Node x){
        while (x.right!=null)
            x=x.right;
        return x;

    }

    class Node {
        int key;
        Node left, right, parent;

        private Node(int data){
            key=data;
            left=null;
            right=null;
            parent=null;
        }

    }
}
