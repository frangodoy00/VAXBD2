package ar.edu.unlp.info.bd2.model;

import java.util.Date;

import net.bytebuddy.matcher.NullMatcher;

import javax.persistence.*;

@Entity
@Table( name = "ShotCertificate")
public class ShotCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @Column( name = "Date")
    private Date date;

    @Column( name = "Numserie")
    private int numSerie;

    public ShotCertificate(){

    }
    public ShotCertificate(Date date, int num) {
        this.date = date;
        this.numSerie = num;
    }

    public int getId(){ return id; }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(){ return date; }

    public void setDate(Date date) {this.date = date; }

    public int getNumSerie() { return numSerie; }

    public void setNumSerie(int num){
        this.numSerie = num;
    }

}
