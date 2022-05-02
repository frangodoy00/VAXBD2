package ar.edu.unlp.info.bd2.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table( name = "Shot")
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @Column(name = "DateAplication")
    private Date dateApplication;


    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Certificate")
    private ShotCertificate certificate;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Patient")
    private Patient patient;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Vaccine")
    private Vaccine vaccine;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Centre")
    private Centre centre;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "Nurse")
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

    public ShotCertificate getCertificate() {
        return certificate;
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
}
