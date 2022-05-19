package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/*Aqui se debe realizar la implementacion de todos los metodos declarados en VaxService*/
public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;
    public VaxServiceImpl(VaxRepository repository) {this.repository = repository;}


    /**
	 *
	 * @param email email del usuario con el cual ingresa al sitio
	 * @param fullname nombre y apellido del usuario
	 * @param password clave con la que el usuario ingresa al sitio
	 * @param dayOfBirth fecha de nacimiento del usuario
	 * @return el usuario creado
	 * @throws VaxException
	 */
    public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException{
		if ( this.repository.getPatientByEmail(email).isPresent()){
			VaxException exception = new VaxException("Constraint Violation");
			throw exception;
		}
    	Patient patient = new Patient(email,fullname,password,dayOfBirth);
		int id = this.repository.save(patient);
		Patient p = this.repository.getPatientById(id);
		return p;
    }
    
    /**
	 *
	 * @param name nombre de la vacuna
	 * @return la vacuna creada
	 * @throws VaxException
	 */
	public Vaccine createVaccine(String name) throws VaxException{
		if ( this.repository.getVaccineByName(name).isPresent()){
			VaxException exception = new VaxException("Constraint Violation");
			throw exception;
		}
		Vaccine vaccine = new Vaccine(name);
		int id = this.repository.save(vaccine);
		Vaccine v = this.repository.getVaccineById(id);
		return v;
	}
    
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
		return s;

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
		int id = this.repository.save(nurse);
        Nurse n = this.repository.getNurseById(id);
		return n;
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
		int id = this.repository.save(supp);
        SupportStaff s = this.repository.getSupportStaffById(id);
		return s;
	}
	
	/**
	 * @return el esquema nueva vacío
	 * @throws VaxException
	 * */
	public VaccinationSchedule createVaccinationSchedule() throws VaxException{
		VaccinationSchedule vacc = new VaccinationSchedule();
		int id = this.repository.save(vacc);
        VaccinationSchedule v = this.repository.getVaccinationScheduleById(id);
		return v;
	}
	
	/**
	 * 
	 * @param email email del usuario
	 * @return
	 */
	public Optional<Patient> getPatientByEmail(String email){
		return this.repository.getPatientByEmail(email);
	}
	
	/**
	 *
	 * @param name nombre de la vacuna
	 * @return
	 */
	public Optional<Vaccine> getVaccineByName(String name){
		return this.repository.getVaccineByName(name);
	}
	
	/**
	 * @param id el id del esquema
	 * @return el esquema de vacunación
	 * */
	public VaccinationSchedule getVaccinationScheduleById(Long id){
		return this.repository.getVaccinationScheduleById(id);
	}
	
	public VaccinationSchedule getVaccinationScheduleById(int id){
		return this.repository.getVaccinationScheduleById(id);
	}
	
	/**
	 * @param name el nombre del centro a buscar
	 * @return el centro
	 * */
	public Optional<Centre> getCentreByName(String name) throws VaxException{
		return this.repository.getCentreByName(name);
	}
	
	/**
	 * @param dni el dni del SupportStaff a buscar
	 * @return el SupportStaff
	 * */
	public Optional<SupportStaff> getSupportStaffByDni(String dni){
		return this.repository.getSupportStaffByDni(dni);
	}
	
	/**
	 * @param staff el staff a actualizar
	 * @return el staff
	 * @throws VaxException 
	 */
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException{
		int id = this.repository.save(staff);
        SupportStaff s = this.repository.getSupportStaffById(id);
		return s;
	}

	/**
	 * @param centre el centre a actualizar
	 * @return el centre
	 * @throws VaxException 
	 */
	public Centre updateCentre(Centre centre) throws VaxException{
		int id = this.repository.save(centre);
        Centre c = this.repository.getCentreById(id);
        return c;
	}

	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) throws VaxException{
		int id = this.repository.save(schedule);
		VaccinationSchedule s = this.repository.getVaccinationScheduleById(id);
		return s;
	}

	/**
	 * @return Una lista con todos los pacientes
	 */
	public List<Patient> getAllPatients() {
		return this.repository.getAllPatients();
	}

	/**
	 * @return Una lista con todos los enfermeros que tengan más de <code>years</code> años de experiencia
	 */
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
		return this.repository.getNurseWithMoreThanNYearsExperience(years);
	}

	/**
	 * @return Una lista con los <code>n</code> centros que más staff tiene
	 */
	public List<Centre> getCentresTopNStaff(int n){
		return this.repository.getCentresTopNStaff(n);
	}


	/**
	 * @return El centro que más vacunas aplico
	 */
	public Centre getTopShotCentre(){
		return this.repository.getTopShotCentre();
	}

	/**
	 * @return Una lista de los enfermeros que no aplicaron vacunas
	 */
	public List<Nurse> getNurseNotShot() { return this.repository.getNurseNotShot(); }

	/**
	 * @return El area de Support Staff con menor cantidad de empleados
	 */
	public String getLessEmployeesSupportStaffArea(){ return this.repository.getLessEmployeesSupportStaffArea() ;}

	/**
	 * @return Los empleados cuyo fullName contenga <code>name</code>
	 */
	public List<Personal> getStaffWithName(String name){
		return this.repository.getStaffWithName(name);
	}

	/**
	 * @return Una lista de las vacunas de las que no se aplicaron dosis
	 */
	public List<Vaccine> getUnappliedVaccines(){
		return this.repository.getUnappliedVaccines();
	}

	/**
	 * @return Una lista de los certificados emitidos en un rango de fechas
	 */
	public List <ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate){
		return this.repository.getShotCertificatesBetweenDates(startDate, endDate);
	}
}
