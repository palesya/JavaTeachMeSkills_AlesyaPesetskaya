package com.chain;

public class Processor {

    FilterChain filterChain;

    public Processor(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public void process(String text){
        System.out.println("text = " + text);
    }

}
