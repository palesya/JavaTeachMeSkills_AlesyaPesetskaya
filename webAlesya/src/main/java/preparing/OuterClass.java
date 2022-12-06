package preparing;

class OuterClass {
    final int k = 222;
    public void someMethod(final int k,int i){
        class LocalClass{
            public void printArg(){
                System.out.println("Hello"+OuterClass.this.k+" | "+k+" <--arg)");
            }
        }
        new LocalClass().printArg();
    }
}
