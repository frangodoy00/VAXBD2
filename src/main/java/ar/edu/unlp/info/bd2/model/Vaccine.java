package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="name", unique = true, nullable = false)
    private String name;

    @Column(name="lab")
    private String lab;

    public Vaccine() {

    }

    public Vaccine(String name, String lab){
        this.name = name;
        this.lab = lab;
    }
    
    public Vaccine(String name){
        this.name = name;
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
