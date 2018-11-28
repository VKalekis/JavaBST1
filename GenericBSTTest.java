public class GenericBSTTest{

    public static void main(String[] args) {

        Employee Bill= new Employee("Bill",20000);
        Employee John = new Employee("John",10000);
        Employee Adam = new Employee("Adam", 15000);

        GenericBST newBST1= new GenericBST<>();
        newBST1.add(Bill);
        newBST1.add(John);
        newBST1.add(Adam);
        newBST1.printInOrder();
        newBST1.delete(John);

        GenericBST newBST2=new GenericBST();
        newBST2.add(1);
        newBST2.add(2);
        newBST2.printInOrder();
        newBST2.delete(2);
        newBST2.printInOrder();

        GenericBST newBST3=new GenericBST();
        newBST3.add(new String("ABC"));
        newBST3.add(new String("ABCD"));
        newBST3.printInOrder();
    }
}
