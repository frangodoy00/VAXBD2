package ar.edu.unlp.info.bd2.model;

public class Patient {
    private int id;
    private String name;
    private VaccinationSchedule schedule;

    public Patient(String name, VaccinationSchedule schedule){
        this.name = name;
        this.schedule = schedule;
    }
}
