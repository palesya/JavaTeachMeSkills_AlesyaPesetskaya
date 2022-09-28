package com.memento;

public class Report {

    private String title;
    private String body;

    private Report saved;

    public Report(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void save(){
        saved = new Report(title,body);
    }

    public void restore(){
        this.title = saved.title;
        this.body = saved.body;
    }
}
