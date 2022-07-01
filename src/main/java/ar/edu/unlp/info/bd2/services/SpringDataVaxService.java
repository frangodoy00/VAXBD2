package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public class SpringDataVaxService implements VaxService{

	@Autowired
	SupportStaffRepository supportStaffRepository;
	@Autowired
	CentreRepository centreRepository;
	@Autowired
	NurseRepository nurseRepository;
	@Autowired
	PersonalRepository personalRepository;
	@Autowired
	VaccineRepository vaccineRepository;
	@Autowired
	VaccionationScheduleRepository vaccionationScheduleRepository;
	@Autowired
	ShotCertificateRepository shotCertificateRepository;
	@Autowired
	ShotRepository shotRepository;
	@Autowired
	PatientRepository patientRepository;
	

	/**Cree este constructoor vacio por que sino me tira error en SpringDataConfiguration**/
	public SpringDataVaxService() {

	}

	/**
		 *
		 * @param email email del usuario con el cual ingresa al sitio
		 * @param fullname nombre y apellido del usuario
		 * @param password clave con la que el usuario ingresa al sitio
		 * @param dayOfBirth fecha de nacimiento del usuario
		 * @return el usuario creado
		 * @throws VaxException
		 */
		public Patient createPatient(String email,String fullname, String password, Date dayOfBirth) throws VaxException{
				Pageable pageable = PageRequest.of(1,1);
				if (! this.patientRepository.getPatientByEmail(email, pageable).isEmpty()){
					VaxException exception = new VaxException("Constraint Violation");
					throw exception;
				}
				return patientRepository.save(new Patient(email,fullname,password,dayOfBirth));
		}


		/**
		 *
		 * @param name nombre de la vacuna
		 * @return la vacuna creada
		 * @throws VaxException
		 */
		@Transactional
		public Vaccine createVaccine(String name) throws VaxException{
			if ( this.getVaccineByName(name).isPresent()){
				VaxException exception = new VaxException("Constraint Violation");
				throw exception;
			}
			return vaccineRepository.save(new Vaccine(name));
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
			ShotCertificate certificate = this.createShotCertificate(date);
			return shotRepository.save(new Shot(patient, vaccine, date,centre,nurse,certificate));
		}
		
		public ShotCertificate createShotCertificate(Date date) throws VaxException {
			return shotCertificateRepository.save(new ShotCertificate(date));
		}


		/**
		 * 
		 * @param email email del usuario
		 * @return
		 */
		public Optional<Patient> getPatientByEmail(String email){
			Pageable pageable = PageRequest.of(1,1);
			Optional<Patient> patient = this.patientRepository.getPatientByEmail(email, pageable).get(1);
			return patient;
		}


		/**
		 *
		 * @param name nombre de la vacuna
		 * @return
		 */
		public Optional<Vaccine> getVaccineByName(String name){
			Pageable pageable = PageRequest.of(1,1);
			Optional<Vaccine> vaccine = this.vaccineRepository.getVaccineByName(name, pageable).get(1);
			return vaccine;
		}

		/**
		 *
		 * @param name nombre del centro de vacunación
		 * @return el centro de vacunación nuevo
		 * @throws VaxException
		 */
		@Transactional
		public Centre createCentre(String name) throws VaxException{
			Pageable pageable = PageRequest.of(1,1);
			if (! centreRepository.findByName(name).isEmpty()){
				VaxException exception = new VaxException("Constraint Violation");
				throw exception;
			}
			return centreRepository.save(new Centre(name));
		}

		/**
		 * @param dni el dni
		 * @param fullName nombre del/la enfermero/a
		 * @param experience experiencia en años
		 * @return el enfermero creado
		 * @throws VaxException
		 */
		public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException{
			Pageable pageable = PageRequest.of(1,1);
			if (! nurseRepository.getNurseByDni(dni,pageable).isEmpty()){
				VaxException exception = new VaxException("Constraint Violation");
				throw exception;
			}
			return nurseRepository.save(new Nurse(fullName,dni,experience));
		}
		
		/**
		* @param dni el dni
		* @param fullName nombre completo
		* @param area el area o areas de trabajo
		* @return el personal de apoyo creado
		* @throws VaxException
		* */
		public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException{
			Pageable pageable = PageRequest.of(1,1);
			if (! supportStaffRepository.getSupportStaffByDni(dni,pageable).isEmpty()){
				VaxException exception = new VaxException("Constraint Violation");
				throw exception;
			}
			return supportStaffRepository.save(new SupportStaff(fullName,dni,area));
		}

		/**
		 * @param dni el dni del SupportStaff a buscar
		 * @return el SupportStaff
		 * */
		public Optional<SupportStaff> getSupportStaffByDni(String dni){
			Pageable pageable = PageRequest.of(1,1);
			Optional<SupportStaff> supp = supportStaffRepository.getSupportStaffByDni(dni, pageable).get(1);
			return supp;
		}

		/**
		 * @return el esquema nueva vacío
		 * @throws VaxException
		 * */
		@Transactional
		public VaccinationSchedule createVaccinationSchedule() throws VaxException{
			return this.vaccionationScheduleRepository.save(new VaccinationSchedule());
		}

		/**
		 * @param id el id del esquema
		 * @return el esquema de vacunación
		 * */
		public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException{
			Pageable pageable = PageRequest.of(1,1);
			VaccinationSchedule vacc = this.vaccionationScheduleRepository.getVaccinationScheduleById(id, pageable).get(1);
			return vacc;
		}

		/**
		 * @param name el nombre del centro a buscar
		 * @return el centro
		 * */
		@Query
		public Optional<Centre> getCentreByName(String name) throws VaxException{
			// Pageable pageable = PageRequest.of(1,1);
			Optional<Centre> centre = Optional.of(this.centreRepository.findByName(name).get(0));
			// Optional<Centre> centre = this.centreRepository.getCentreByName(name, pageable).get(1);
			return centre;
		}

		/**
		 * @param staff el staff a actualizar
		 * @return el staff
		 * @throws VaxException 
		 */
		public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException{
			return this.supportStaffRepository.save(staff);
		}

		/**
		 * @param centre el centre a actualizar
		 * @return el centre
		 * @throws VaxException 
		 */
		@Transactional
		public Centre updateCentre(Centre centre){
			return this.centreRepository.save(centre);
			// return this.centreRepository.updateCentre(centre);
		}
		
		/**
		 * 
		 * @param schedule
		 * @return el VaccinationSchedule actualizado.
		 */
		@Transactional
		public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule){
			return this.vaccionationScheduleRepository.save(schedule);
			//return this.vaccionationScheduleRepository.updateVaccinationSchedule(schedule);
		}
		
		public VaccinationSchedule getVaccinationScheduleById(int id){
			Pageable pageable = PageRequest.of(1,1);
			VaccinationSchedule vacc = this.vaccionationScheduleRepository.getVaccinationScheduleById(id, pageable).get(1);
			return vacc;
		}
		public List<Vaccine> getUnappliedVaccines(){
			return this.vaccineRepository.getUnappliedVaccines();
		}
		public List<Patient> getAllPatients() {
		return this.patientRepository.getAllPatients();
	}
	
		public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
			return this.nurseRepository.getNurseWithMoreThanNYearsExperience(years);
		}
		
		public List<Nurse> getNurseNotShot() {
			return this.nurseRepository.getNurseNotShot();
		}

		public List<Centre> getCentresTopNStaff(int n){
			return this.centreRepository.getCentresTopNStaff();
		}


		public Centre getTopShotCentre(){
			Pageable pageable = PageRequest.of(1,1);
			Centre centre = this.centreRepository.getTopShotCentre(pageable).get(1);
			return centre;
		}
		
		public String getLessEmployeesSupportStaffArea(){
			Pageable pageable = PageRequest.of(1,1);
			String area = this.supportStaffRepository.getLessEmployeesSupportStaffArea(pageable).get(1);
			return area;
		}

		public List<Personal> getStaffWithName(String name){
			return this.personalRepository.getStaffWithName(name);
		}

		public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate){
			return this.shotCertificateRepository.getShotCertificatesBetweenDates(startDate,endDate);
		}
}
