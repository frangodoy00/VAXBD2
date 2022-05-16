package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.Query;
import javax.persistence.PersistenceException;
import javax.transaction.Transaction;

import ar.edu.unlp.info.bd2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class VaxRepository {

	@Autowired
	private SessionFactory sessionFactory;


	public int save(Object object){
		Session sesion = sessionFactory.getCurrentSession();
		int id =(int)sesion.save(object);
		return id;

	}

	public Shot getShotById(int id){
		return (Shot)sessionFactory.getCurrentSession().createQuery("from Shot s where s.id = :id").setParameter("id",id).uniqueResult();
	}

	public ShotCertificate getShotCertificateById(int id){
		return (ShotCertificate) sessionFactory.getCurrentSession().createQuery("from ShotCertificate sc where sc.id = :id").setParameter("id",id).uniqueResult();
	}
	
	public List<ShotCertificate> getShotCertificatesBetweenDates(Date start, Date end){
		return (List<ShotCertificate>)sessionFactory.getCurrentSession()
				.createQuery("select s from ShotCertificate s where s.date BETWEEN :start AND :end", ShotCertificate.class)
				.setParameter("start",start).setParameter("end", end).getResultList();
	}

	public Centre getCentreById(int id){
		return (Centre)sessionFactory.getCurrentSession()
				.createQuery("select c from Centre c where c.id = :id")
				.setParameter("id",id).uniqueResult();
	}

	public Patient getPatientById(int id){
		return (Patient)sessionFactory.getCurrentSession()
				.createQuery("select p from Patient p where p.id = :id")
				.setParameter("id",id).uniqueResult();
	}

	public Optional<Patient> getPatientByEmail(String email){
		return (Optional<Patient>)sessionFactory.getCurrentSession()
				.createQuery("select p from Patient p where p.email = :email", Patient.class)
				.setParameter("email",email).uniqueResultOptional();
	}

	public List<Patient> getAllPatients() {
		return (List<Patient>)sessionFactory.getCurrentSession().createQuery(
				"select p from Patient p", Patient.class).getResultList();
	}

	public Vaccine getVaccineById(int id){
		return (Vaccine)sessionFactory.getCurrentSession().createQuery("from Vaccine v where v.id = :id").setParameter("id",id).uniqueResult();
	}
	
	public List<Vaccine> getUnappliedVaccines(){
		return (List<Vaccine>)sessionFactory.getCurrentSession()
				.createQuery("select v from Vaccine v EXCEPT select v from Vaccine v INNER JOIN Shot s ON(v.id=s.vaccine.id)", Vaccine.class)
				.getResultList();
	}

	public Nurse getNurseById(int id){
		return (Nurse)sessionFactory.getCurrentSession().createQuery("from Nurse n where n.id = :id").setParameter("id",id).uniqueResult();
	}

	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
		return (List<Nurse>)sessionFactory.getCurrentSession()
				.createQuery("select n from Nurse n where n.yearsExperience > :years", Nurse.class)
				.setParameter("years",years).getResultList();
	}

	public SupportStaff getSupportStaffById(int id){
		return (SupportStaff)sessionFactory.getCurrentSession().createQuery("from SupportStaff s where s.id = :id").setParameter("id",id).uniqueResult();
	}

	public List<Personal> getStaffWithName(String name){
		return (List<Personal>)sessionFactory.getCurrentSession()
				.createQuery("select p from Personal p where p.fullName > :name", Personal.class)
				.setParameter("name",name).getResultList();
	}
	
	public VaccinationSchedule getVaccinationScheduleById(Long id){
		return (VaccinationSchedule)sessionFactory.getCurrentSession().createQuery("from VaccinationSchedule v where v.id = :id").setParameter("id",id).uniqueResult();
	}

	public VaccinationSchedule getVaccinationScheduleById(int id){
		return (VaccinationSchedule)sessionFactory.getCurrentSession().createQuery("from VaccinationSchedule v where v.id = :id").setParameter("id",id).uniqueResult();
	}

	public Optional<Vaccine> getVaccineByName(String name){
		return (Optional<Vaccine>)sessionFactory.getCurrentSession()
				.createQuery("select v from Vaccine v where v.name = :name", Vaccine.class)
				.setParameter("name",name).uniqueResultOptional();

	}

	public Optional<Centre> getCentreByName(String name){
		return (Optional<Centre>)sessionFactory.getCurrentSession()
				.createQuery("select c from Centre c where c.name = :name", Centre.class)
				.setParameter("name",name).uniqueResultOptional();
	}

	public Optional<SupportStaff> getSupportStaffByDni(String dni){
		return (Optional<SupportStaff>)sessionFactory.getCurrentSession()
				.createQuery("select s from SupportStaff s where s.dni = :dni", SupportStaff.class)
				.setParameter("dni",dni).uniqueResultOptional();
	}


}
