package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

import java.util.Date;
import java.util.Optional;

/*Aqui se debe realizar la implementacion de todos los metodos declarados en VaxService*/
public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;
    public VaxServiceImpl(VaxRepository repository) {this.repository = repository;}




	/**
	 *
	 * @param date fecha de aplicación
	 * @return el usuario creado
	 * @throws VaxException
	 */
	public ShotCertificate createShotCertificate(Date date)throws VaxException{
		ShotCertificate shotCertificate = new ShotCertificate(date);
		int id = this.repository.save(shotCertificate);
		ShotCertificate sc = this.repository.getShotCertificateById(id);
		return sc;
	}

	/**
	 *
	 * @param patient paciente vacunado
	 * @param vaccine vacuna aplicada
	 * @param date fecha de aplicación
	 * @param centre el centro de vacunación donde se aplicó
	 * @param nurse enfermero/a que aplico la vacuna
	 * @return el usuario creado
	 * @throws VaxException
	 */
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException{
		/** genero el certificado primero para asocialo al shot */
		ShotCertificate certificate=  this.createShotCertificate(date);

		Shot shot = new Shot(patient,vaccine,date,centre,nurse,certificate);
		int id = this.repository.save(shot);
		Shot s = this.repository.getShotById(id);
		return shot;

	}


	/**
     *
     * @param name nombre del centro de vacunación
     * @return el centro de vacunación nuevo
     * @throws VaxException
     */
    public Centre createCentre(String name) throws VaxException{
        Centre centro = new Centre(name);
        int id = this.repository.save(centro);
        Centre c = this.repository.getCentreById(id);
        return c;
    }
    
    /**
	 * @param dni el dni
	 * @param fullName nombre del/la enfermero/a
	 * @param experience experiencia en años
	 * @return el enfermero creado
	 * @throws VaxException
	 */
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException{
		Nurse nurse = new Nurse(fullName,dni,experience);
		return nurse;
	}
	
	/**
	* @param dni el dni
	* @param fullName nombre completo
	* @param area el area o areas de trabajo
	* @return el personal de apoyo creado
	* @throws VaxException
	* */
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException{
		SupportStaff supp = new SupportStaff(fullName,dni,area);
		return supp;
	}
	
		
}
