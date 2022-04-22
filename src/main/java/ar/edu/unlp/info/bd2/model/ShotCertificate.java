package ar.edu.unlp.info.bd2.model;

import net.bytebuddy.matcher.NullMatcher;

public class ShotCertificate {

    private int id;

    private Date date;

    private int numSerie;

    Public ShotCertificate(Date date, int num) {
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
