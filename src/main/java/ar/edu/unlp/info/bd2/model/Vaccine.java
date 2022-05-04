package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "Vaccine")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @Column(name="Name", nullable = false)
    private String name;

    public Vaccine() {

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
}
