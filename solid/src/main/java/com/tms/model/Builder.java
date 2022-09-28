package com.tms.model;

public final class Builder {

    private Long id;
    private String name;

    public Builder() {
    }

    public Builder withId(Long id) {
        this.id = id;
        return this;
    }

    public Builder withName(String name) {
        this.name = name;
        return this;
    }

    public User build(){
        return new User(id,name);
    }
}
