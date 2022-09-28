package com.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    List<Processor> list = new ArrayList<>();
    int position = 0;

    public FilterChain() {
    }

    public FilterChain(List<Processor> list) {
        this.list = list;
    }

    public void addProcessor(Processor processor) {
        list.add(processor);
    }

    void next(String obj) {
        while (position < list.size()) {
            Processor processor = list.get(position);
            processor.process(obj);
            position++;
        }
    }
}
