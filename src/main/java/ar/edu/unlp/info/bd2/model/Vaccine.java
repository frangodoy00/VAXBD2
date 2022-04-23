package ar.edu.unlp.info.bd2.model;

public class Vaccine {
    private int id;
    private String name;
    private String lab;

    public Vaccine(String name, String lab){
        this.name = name;
        this.lab = lab;
    }
}
