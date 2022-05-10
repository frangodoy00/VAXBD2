package ar.edu.unlp.info.bd2.model;

//import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="fullname", nullable = false)
    private String fullname;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="dayOfBirth", nullable = false)
    private Date dayOfBirth;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Shot> shots;

    public Patient() {
        this.shots = new ArrayList<Shot>();
    }

    public Patient(String email, String fullname, String password, Date dayOfBirth){
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.shots = new ArrayList<Shot>();
    }
    
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return this.email; }
    public void setEmail(String name) { this.email = name; }

    public String getFullname() { return this.fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDayOfBirth() { return this.dayOfBirth; }
    public void setDayOfBirth(Date dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public Collection<Shot> getShots() { return this.shots; }

    public void addShot(Shot shot) { this.shots.add(shot); }
}
