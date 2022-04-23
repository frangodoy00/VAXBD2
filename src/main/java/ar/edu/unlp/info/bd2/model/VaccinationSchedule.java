package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.List;

public class VaccinationSchedule {
    private int id;
    private List<Vaccine> sequence;

    public VaccinationSchedule(){
        this.sequence = new ArrayList<Vaccine>();
    }
}
