import java.util.*;

public class App {   
    public static void main(String[] args) {
        Set<Integer> Set1 = new TreeSet<Integer>(Arrays.asList(new Integer[]{0, 2, 8, 10}));
        Set<Integer> Set2 = new TreeSet<Integer>(Arrays.asList(new Integer[]{5, 6, 2, 1}));
    
        // union
        Set<Integer> Set3 = new TreeSet<>(Set1);
        Set3.addAll(Set2);
        System.out.println(Set3);

        // interset
        Set<Integer> Set4 = new TreeSet<Integer>(Set1);
        Set4.retainAll(Set2);
        System.out.print(Set4);

    }
}
