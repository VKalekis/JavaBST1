public class test {

    public static void main(String[] args) {

        myLinkedList ll = new myLinkedList();
        ll.add(5);
        ll.add(15);
        ll.add(12);
        ll.add(2);
        ll.printList();

        BinaryTree newBST = new BinaryTree();
        newBST.add(5);
        newBST.add(2);
        newBST.add(1);
        newBST.printInOrder();
        newBST.delete(1);
        newBST.printInOrder();

        RandomBinaryTree randomBST = new RandomBinaryTree();
        randomBST.addRandom(10);
        randomBST.printInOrder();

    }
}
