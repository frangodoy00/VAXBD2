package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "vaccinationschedule")
public class VaccinationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "vaccinationschedule_vaccine",
            joinColumns = {@JoinColumn(name = "vaccinationschedule_id")},
            inverseJoinColumns = {@JoinColumn(name = "vaccine_id")}
    )
    private List<Vaccine> vaccines;

    public VaccinationSchedule(){
        this.vaccines = new ArrayList<Vaccine>();
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public List<Vaccine> getVaccines() { return this.vaccines; }

    public void addVaccine(Vaccine vaccine) { this.vaccines.add(vaccine); }

}
