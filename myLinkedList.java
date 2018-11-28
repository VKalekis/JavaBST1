import java.util.*;

public class myLinkedList extends LinkedList<Integer>{


    public void add(int data){
        if (this.contains(data))
            System.out.println("Integer exists in list, add another one.");
        else {
            if (this.size() == 0)
                this.add(0, data);
            else {
                int i = 0;
                while (i < this.size() && this.get(i) < data)
                    i++;
                this.add(i, data);
            }
        }
    }

    public void delete(int datadel){
        if (this.contains(datadel)) {
            this.remove(this.indexOf(datadel));
            System.out.println("Node with key " + datadel + " got deleted.");
        }
        else
            System.out.println("Didn't find node with key " + datadel + " in list, try another one.");
    }

    public void choices(){
        Scanner in = new Scanner(System.in);
        int sel = 0;
        while (sel != 4) {
            System.out.println("1: Insert in (Sorted) Linked List, 2: Print, 3: Delete, 4: Exit");
            sel = in.nextInt();
            if (sel == 1) {
                System.out.println("Give integer to enter");
                int data = in.nextInt();
                this.add(data);
            }
            if (sel == 2)
                this.printList();
            if (sel == 3) {
                System.out.println("Give integer to delete");
                int datadel = in.nextInt();
                this.delete(datadel);
            }
            if (sel == 4)
                System.out.println("Exiting\n");
            if (sel != 4)
                System.out.println("\nGive next selection:");
        }

    }

    public void printList(){
        System.out.println("List"+this);

    }

    public static void main(String[] args) {

        myLinkedList ll = new myLinkedList();
        ll.choices();

    }
}