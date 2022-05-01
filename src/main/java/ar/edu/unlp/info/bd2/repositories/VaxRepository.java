package ar.edu.unlp.info.bd2.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.management.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;

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
	
	public Centre getCentreById(int id){
		return (Centre)sessionFactory.getCurrentSession().createQuery("from Centre c where c.id = id").setParameter("id",id).uniqueResult();
	}
	
}
