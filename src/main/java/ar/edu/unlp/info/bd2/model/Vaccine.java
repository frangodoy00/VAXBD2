package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "VACCINE")
public class Vaccine {
    private int id;
    private String name;
    private String lab;

    public Vaccine() {

    }

    public Vaccine(String name, String lab){
        this.name = name;
        this.lab = lab;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", unique = true, nullable = false)
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    @Column(name="Name", nullable = false)
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
