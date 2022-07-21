package com.tms.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PairDataBase {

    @Autowired
    private List<Pair> pairs;

    public void setPairs(List<Pair> pairs) {
        this.pairs=pairs;
    }

}
