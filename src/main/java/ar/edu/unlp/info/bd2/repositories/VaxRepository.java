package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.management.Query;
import javax.transaction.Transaction;

import ar.edu.unlp.info.bd2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class VaxRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public int save(Object object){
		try {
			Session sesion = sessionFactory.getCurrentSession();
			int id =(int)sesion.save(object);
			sesion.close();
			return id;
		}
		catch(Exception e){
			VaxException exception = new VaxException("No se pudo realizar el alta.");
			throw e;
		}
	}

	public Shot getShotById(int id){
		return (Shot)sessionFactory.getCurrentSession().createQuery("from Shot s where s.id = id").setParameter("id",id).uniqueResult();
	}

	public ShotCertificate getShotCertificateById(int id){
		return (ShotCertificate) sessionFactory.getCurrentSession().createQuery("from ShotCertificate sc where sc.id = id").setParameter("id",id).uniqueResult();
	}
	
	public Centre getCentreById(int id){
		return (Centre)sessionFactory.getCurrentSession().createQuery("from Centre c where c.id = id").setParameter("id",id).uniqueResult();
	}
	
	public Patient getPatientById(int id){
		return (Patient)sessionFactory.getCurrentSession().createQuery("from Patient p where p.id = id").setParameter("id",id).uniqueResult();
	}
	
	public Vaccine getVaccineById(int id){
		return (Vaccine)sessionFactory.getCurrentSession().createQuery("from Vaccine v where v.id = id").setParameter("id",id).uniqueResult();
	}
	
	public Nurse getNurseById(int id){
		return (Nurse)sessionFactory.getCurrentSession().createQuery("from Nurse n where n.id = id").setParameter("id",id).uniqueResult();
	}
	
	public SupportStaff getSupportStaffById(int id){
		return (SupportStaff)sessionFactory.getCurrentSession().createQuery("from SupportStaff s where s.id = id").setParameter("id",id).uniqueResult();
	}
	
	public VaccinationSchedule getVaccinationScheduleById(int id){
		return (VaccinationSchedule)sessionFactory.getCurrentSession().createQuery("from VaccinationSchedule v where v.id = id").setParameter("id",id).uniqueResult();
	}
	
	public Optional<Patient> getPatientByEmail(String email){
		return (Optional<Patient>)sessionFactory.getCurrentSession().createQuery("from Patient p where p.email = email").setParameter("email",email).uniqueResult();
	}
	
	public Optional<Vaccine> getVaccineByName(String name){
		return (Optional<Vaccine>)sessionFactory.getCurrentSession().createQuery("from Vaccine v where v.name = name").setParameter("name",name).uniqueResult();
	}
}
