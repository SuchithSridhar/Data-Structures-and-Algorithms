import java.util.Arrays;
import java.util.List;

public class TestBinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int target = 5;
        int index = BinarySearch.indexOf(list, target);
        
        if(index != -1){
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in the list.");
        }
        
        target = 15;
        index = BinarySearch.indexOf(list, target);
        
        if(index != -1){
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in the list.");
        }
    }
}

