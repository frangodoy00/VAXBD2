package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @Column(name="Name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private VaccinationSchedule schedule;

    public Patient() {

    }

    public Patient(String name, VaccinationSchedule schedule){
        this.name = name;
        this.schedule = schedule;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public VaccinationSchedule getSchedule() {
        return this.schedule;
    }
    public void setSchedule(VaccinationSchedule schedule) {
        this.schedule = schedule;
    }
}
