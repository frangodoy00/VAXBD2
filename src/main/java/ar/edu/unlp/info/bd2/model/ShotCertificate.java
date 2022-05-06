package ar.edu.unlp.info.bd2.model;

import java.util.Date;
import java.util.Random;

import net.bytebuddy.matcher.NullMatcher;

import javax.persistence.*;

@Entity
@Table( name = "shotCertificate")
public class ShotCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column( name = "date")
    private Date date;

    @Column( name = "numserie")
    private int serialNumber;

    public ShotCertificate(){

    }
    public ShotCertificate(Date date) {
        this.date = date;
        this.serialNumber = (int)(Math.random()*999999 + 0);  /** chequear q no exista en bd ?  */
    }

    public int getId(){ return id; }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(){ return date; }

    public void setDate(Date date) {this.date = date; }

    public int getSerialNumber() { return serialNumber; }

}
