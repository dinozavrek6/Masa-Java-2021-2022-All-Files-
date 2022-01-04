import javax.swing.Box;

public class Main {
    public static void main(String[] args){
        HeavyBox heavyBox = new HeavyBox();

        heavyBox.insertBox(new Box(25));
        heavyBox.insertBox(new Box(45));
        heavyBox.insertBox(new Box(20));
        heavyBox.insertBox(new Box(35));
        heavyBox.insertBox(new Box(10));


        System.out.println("How mach Box: ");
        heavyBox.printAll();


        heavyBox.removeBox(new Box(25));
        System.out.println("\n Box: ");

    }
    
}
