package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "VACCINATION_SCHEDULE")
public class VaccinationSchedule {
    private int id;
    private Collection<Vaccine> sequence;

    public VaccinationSchedule(){
        this.sequence = new ArrayList<Vaccine>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", unique = true, nullable = false)
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    @ManyToMany
    public Collection<Vaccine> getSequence() { return this.sequence; }
    public void setSequence(Collection<Vaccine> sequence) { this.sequence = sequence; }
}
