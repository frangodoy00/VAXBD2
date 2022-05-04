package ar.edu.unlp.info.bd2.model;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id", unique = true, nullable = false)
    private int id;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Fullname", nullable = false)
    private String fullname;

    @Column(name="Password", nullable = false)
    private String password;

    @Column(name="DayOfBirth", nullable = false)
    private Date dayOfBirth;

    public Patient() {

    }

    public Patient(String email, String fullname, String password, Date dayOfBirth){
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return this.email; }
    public void setEmail(String name) { this.email = email; }

    public String getFullname() { return this.fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDayOfBirth() { return this.dayOfBirth; }
    public void setDayOfBirth(Date dayOfBirth) { this.dayOfBirth = dayOfBirth; }
}
