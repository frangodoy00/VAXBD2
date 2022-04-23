package ar.edu.unlp.info.bd2.model;

public class Vaccine {
    private int id;
    private String name;
    private String lab;

    public Vaccine(String name, String lab){
        this.name = name;
        this.lab = lab;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
