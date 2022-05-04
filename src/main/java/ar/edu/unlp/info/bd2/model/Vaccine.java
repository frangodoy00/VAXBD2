package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "VACCINE")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", unique = true, nullable = false)
    private int id;

    @Column(name="Name", nullable = false)
    private String name;

    @Column(name="Lab", nullable = false)
    private String lab;

    public Vaccine() {

    }

    public Vaccine(String name, String lab){
        this.name = name;
        this.lab = lab;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLab() {
        return this.lab;
    }
    public void setLab(String lab) {
        this.lab = lab;
    }
}
