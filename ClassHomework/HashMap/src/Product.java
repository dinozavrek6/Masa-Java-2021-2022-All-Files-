public class Product {
    private String name;
    private String object;

    public Product(){
    }

    public Product(String name) {
        this.name = name;

    }
    
    public Product(String name, String object){
        this();
        this.object = object;
    }

}
