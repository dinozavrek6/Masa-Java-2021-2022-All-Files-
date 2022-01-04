public final class Singleton {
    private static final Singleton instance = new Singleton(); 
        private Singleton(){}
        
        public static Singleton getInstance(){
            return instance;
        }

    public void Print(){
        System.out.println("Singleton");
    }
}
