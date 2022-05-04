package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Vaccination_Schedule")
public class VaccinationSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @ManyToMany
    private Collection<Vaccine> sequence;

    public VaccinationSchedule(){
        this.sequence = new ArrayList<Vaccine>();
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public Collection<Vaccine> getSequence() { return this.sequence; }
    public void setSequence(Collection<Vaccine> sequence) { this.sequence = sequence; }
}
