package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.*;

import javax.management.Query;
import javax.persistence.PersistenceException;
import javax.transaction.Transaction;

import ar.edu.unlp.info.bd2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.QueryHints;
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
/*
	public Centre getTopShotCentre(){
		return (Centre)sessionFactory.getCurrentSession()
				.createQuery(
						"select c " +
								"from Shot as s join s.centre as c " +
								"group by c.id having count(s) >= all (" +
									"select count(ss) from Shot as ss join ss.centre as cc group by c.id)"
							// Alternativa: No se si este ultimo max() funcionara pero por ahora lo dejare asi
								//"select c " +
								//"from Shot as s join s.centre as c " +
								//"group by c.id " +
								//"having count(s) = max(count(s))"
				)
				.uniqueResult();
	}
*/


	public Centre getTopShotCentre(){
		return (Centre) sessionFactory.getCurrentSession()
				.createQuery("select s.centre from Shot s group by s.centre order by count(s.centre) desc").setMaxResults(1).uniqueResult();

	}

	public List<Centre> getCentresTopNStaff(int n){
		return (List<Centre>)sessionFactory.getCurrentSession().createQuery(
						"select c " +
						"from Centre c join c.staffs as st " +
						"group by c.id " +
						"order by count(st) desc"
				, Centre.class).setMaxResults(n).getResultList();
		// Consultar: No se si esta es la mejor opcion, seria mejor si la propia
		// query separase los primeros n elementos
	//	List<Centre> list = new ArrayList<Centre>();
		// for (int i=0; i < n; i++) {
	//		list.add(listAux.get(i));
	//	}
	//	 return list;
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
				.createQuery("select v from Vaccine v where v.id not in (select distinct v.id from Vaccine v INNER JOIN Shot s ON(v.id=s.vaccine))", Vaccine.class)
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


	public List<Nurse> getNurseNotShot(){
		return (List<Nurse>)sessionFactory.getCurrentSession()
				.createQuery("select n from Nurse n where n.id not in (select distinct n.id from Nurse n INNER JOIN Shot s ON(n.id = s.nurse))", Nurse.class)
				.getResultList();
	}

	public SupportStaff getSupportStaffById(int id){
		return (SupportStaff)sessionFactory.getCurrentSession().createQuery("from SupportStaff s where s.id = :id").setParameter("id",id).uniqueResult();
	}

	public List<Personal> getStaffWithName(String name){
		return (List<Personal>)sessionFactory.getCurrentSession()
				.createQuery("from Personal p where p.fullName like :name", Personal.class)
				.setParameter("name","%"+name).getResultList();
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


	public String getLessEmployeesSupportStaffArea(){
		return (String)sessionFactory.getCurrentSession()
				.createQuery("select s.area from SupportStaff s where s.area is not null group by s.area order by count(*) asc").setMaxResults(1).uniqueResult();
	}




}
