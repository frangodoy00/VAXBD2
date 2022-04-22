package ar.edu.unlp.info.bd2.model;

public class Shot {

    private int id;

    private Date dateApplication;

    private ShotCertificate certificate;

    private Patient patient;

    private Vaccine vaccine;

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
