package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name = "shot")
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name = "dateAplication")
    private Date dateApplication;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate_id")
    private ShotCertificate certificate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centre_id")
    private Centre centre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nurse_id")
    private Nurse nurse;

    public Shot(){

    }
    public Shot(Patient patient, Vaccine vaccine,Date dateApplication, Centre centre,Nurse nurse,ShotCertificate certificate){
        this.dateApplication = dateApplication;
        this.patient = patient;
        this.vaccine = vaccine;
        this.centre = centre;
        this.nurse = nurse;
        this.certificate = certificate;
        patient.addShot(this);
    }
    
    public Shot(Patient patient, Vaccine vaccine,Date dateApplication, Centre centre,Nurse nurse){
        this.dateApplication = dateApplication;
        this.patient = patient;
        this.vaccine = vaccine;
        this.centre = centre;
        this.nurse = nurse;
        patient.addShot(this);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public void setCertificate(ShotCertificate certificate) {
        this.certificate = certificate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Centre getCentre(){
        return this.centre;
    }

    public Nurse getNurse(){
        return this.nurse;
    }

    public ShotCertificate getShotCertificate(){
        return this.certificate;
    }
}
