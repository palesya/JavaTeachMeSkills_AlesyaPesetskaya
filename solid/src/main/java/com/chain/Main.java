package com.chain;

public class Main {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        Processor processor1=new Processor(filterChain);
        Processor processor2=new Processor(filterChain);

        filterChain.addProcessor(processor1);
        filterChain.addProcessor(processor2);

        filterChain.next("text");
    }
}
