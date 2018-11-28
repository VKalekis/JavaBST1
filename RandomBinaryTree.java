import java.util.Random;
import java.util.Scanner;

public class RandomBinaryTree extends BinaryTree{

    public static void main(String[] args) {
        RandomBinaryTree randomBST = new RandomBinaryTree();
        randomBST.choices(randomBST);
    }


    public void addRandom(int n) {
        Random rand = new Random();
        int i = 0;
        while (i < n) {
            int num = rand.nextInt(200);
            if(this.add(num)){
                i++;
            }
        }
    }

    public void choices(RandomBinaryTree randomBST){
        Scanner in = new Scanner(System.in);
        int sel=0;
        while (sel!=4)  {
            System.out.println("1: Insert n integers, 2: Print in order, 3: Delete, 4: Exit");
            sel = in.nextInt();
            if (sel==1) {
                System.out.println("Give number n of integers:");
                int n = in.nextInt();
                randomBST.addRandom(n);
                System.out.println("Entered "+n+" unique integers");
            }
            if (sel==2)
                randomBST.printInOrder();
            if (sel==3) {
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


}
