package ar.edu.unlp.info.bd2.model;

public class Patient {
    private int id;
    private String name;
    private VaccinationSchedule schedule;

    public Patient(String name, VaccinationSchedule schedule){
        this.name = name;
        this.schedule = schedule;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
