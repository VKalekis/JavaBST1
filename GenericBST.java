public class GenericBST<T extends Comparable<T>> {
    private Node<T> root;

    public GenericBST() {
        root=null;
    }


    public boolean add(T data){
        if (!check(data)){
            this.addNode(root,data);
            return true;
        }
        return false;
    }

    public void delete(T datadel){
        if (this.check(datadel))
            this.deleteNode(root, datadel);
    }


    private void addNode(Node<T> x, T data) {
        if (root==null) {
            Node<T> newNode = new Node<T>(data);
            root=newNode;
        }
        else {
            int comp1=data.compareTo(x.key);
            if (comp1>0) {
                if (x.right != null) {
                    addNode(x.right, data);
                } else {
                    Node<T> newNode = new Node<T>(data);
                    x.right = newNode;
                    newNode.parent = x;
                }
            }
            if (comp1<0) {
                if (x.left != null) {
                    addNode(x.left, data);
                } else {
                    Node<T> newNode = new Node<T>(data);
                    x.left = newNode;
                    newNode.parent = x;
                }
            }
        }
    }

    public boolean check(T data){
        return check(root,data);
    }

    private boolean check(Node<T> x, T data){

        if (x==null)
            return false;
        else {
            int comp2=(x.key).compareTo(data);
            if (x.left != null && comp2>0)
                return check(x.left,data);
            else if (x.right != null && comp2<0)
                return check(x.right,data);
            if (comp2==0)
                return true;
            return false;
        }
    }

    public void printInOrder(){
        System.out.println("Tree:");
        printInOrder(root);
    }

    private void printInOrder(Node<T> x) {
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

    private void deleteNode(Node<T> x, T data){

        int comp3=(x.key).compareTo(data);
        if (x.right!=null && comp3<0)
            deleteNode(x.right,data);
        if (x.left!=null && comp3>0)
            deleteNode(x.left,data);
        if (comp3==0){
            int comp4=(x.parent.key).compareTo(x.key);
            if (x.left==null && x.right==null){
                if (x==root)
                    root=null;
                else if (comp4<0)
                    x.parent.right=null;
                else
                    x.parent.left=null;
            }
            else if (x.left!=null && x.right==null){
                if (x==root) {
                    root=x.left;
                    x.left.parent=x.left;
                }
                else if (comp4<0)
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
                else if (comp4<0) {
                    x.parent.right=x.right;
                }
                else
                    x.parent.left=x.right;
                x.right.parent=x.parent;
            }
            else{
                Node<T> pred = findPredecessor(x.left);
                x.key=pred.key;
                deleteNode(pred, pred.key);
            }
        }
    }

    private Node<T> findPredecessor(Node<T> x){
        while (x.right!=null)
            x=x.right;
        return x;

    }

    class Node<T> {
        T key;
        Node<T> left, right, parent;

        private Node(T data){
            key=data;
            left=null;
            right=null;
            parent=null;
        }

    }
}

