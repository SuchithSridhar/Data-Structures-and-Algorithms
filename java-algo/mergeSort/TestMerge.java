import java.util.Random;
import java.util.ArrayList;

public class TestMerge {
    public static void main(String[] args) {
        int SIZE = 20;
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<SIZE; i++) {
            list.add(rand.nextInt(100));
        }

        System.out.println("Original List:");
        System.out.println(list);
        System.out.println("Sorted List:");
        System.out.println(MergeSort.mergeSort(list));
    }
}
