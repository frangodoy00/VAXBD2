package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {

    private int id;
    private String name;
    private VaccinationSchedule schedule;

    public Patient() {

    }

    public Patient(String name, VaccinationSchedule schedule){
        this.name = name;
        this.schedule = schedule;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", unique = true, nullable = false)
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    @Column(name="Name", nullable = false)
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    @ManyToOne(fetch = FetchType.EAGER)
    public VaccinationSchedule getSchedule() {
        return this.schedule;
    }
    public void setSchedule(VaccinationSchedule schedule) {
        this.schedule = schedule;
    }
}
