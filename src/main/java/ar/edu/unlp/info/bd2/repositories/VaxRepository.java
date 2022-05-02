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
	
}
