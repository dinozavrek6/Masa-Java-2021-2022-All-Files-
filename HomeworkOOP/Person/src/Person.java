public class Person {
    String fullName;
    int age;

    
    void move(){

        
        
        System.out.println("Такой-то " + fullName + " говорит");  
    }
    void talk(String fullName, int age){
        this.fullName = fullName;
        this.age = age;

        System.out.println("Такой-то " + fullName + " говорит");  
    }

}
