public class RedBlackTree<T extends Comparable<T>> extends GenericBST<T>{
    private Node<T> RBroot;

    void LeftRotate(Node<T> x){

        Node<T> y=x.right, temp1=x.parent;

        x.right=y.left;
        if (y.left!=null)
            y.left.parent=x;

        if (RBroot==x){
            RBroot=y;
        }
        else if (x==x.parent.left){
            x.parent.left= y;
        }
        else{
            x.parent.right=y;
        }
        y.left=x;
        x.parent=y;

        if (x.parent!=null){
            x.parent.parent=temp1;
        }
	    else{
	        x.parent.parent=null;
        }
    }

    private void RightRotate(Node<T> x){
        
        Node<T> y=x.left, temp1=x.parent;

        x.left=y.right;
        if (y.right!= null)
            y.right.parent=x;

        if (x==RBroot){
            RBroot=y;
        }
        else if (x==x.parent.left){
            x.parent.left=y;
        }
        else{
            x.parent.right=y;
        }
        y.right=x;
        x.parent=y;

        if (x.parent!=null){
            x.parent.parent=temp1;
        }
	    else{
            x.parent.parent=null;
        }
    }

    private void InsertFixup(Node<T> x){

        while (x.parent!=null && x.parent.colour=='R'){
            System.out.println("here0");

            if (x.parent==x.parent.parent.left){
                System.out.println("here1");
                Node<T> uncle=x.parent.parent.right;
                if ( uncle!=null && uncle.colour=='R'){
                    System.out.println("here2");
                    uncle.colour='B';
                    x.parent.colour='B';
                    x.parent.parent.colour='R';
                    x=x.parent.parent;
                }
                else {
                    System.out.println("here3");
                    if (x==x.parent.right){
                        System.out.println("here4");
                        x=x.parent;
                        LeftRotate(x);
                    }
                    x.parent.colour='B';
                    x.parent.parent.colour='R';
                    RightRotate(x.parent.parent);
                }
            }
		    else if (x.parent==x.parent.parent.right) {
                Node<T> uncle=x.parent.parent.left;
                if (uncle!=null && uncle.colour=='R'){
                    System.out.println("here5");
                    uncle.colour='B';
                    x.parent.colour='B';
                    x.parent.parent.colour='R';
                    x=x.parent.parent;
                }
                else{
                    if (x==x.parent.left){
                        System.out.println("here6\n");
                        x=x.parent;
                        RightRotate(x);
                    }
                    System.out.println("here7");
                    x.parent.colour='B';
                    x.parent.parent.colour='R';
                    LeftRotate(x.parent.parent);
                }
            }
            System.out.println("here8");
        }
        RBroot.colour='B';
    }

    @Override
    public boolean add(T data){
        super.add(data);
        InsertFixup();
    }


}
