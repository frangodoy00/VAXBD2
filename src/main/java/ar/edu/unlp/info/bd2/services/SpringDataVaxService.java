package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Personal;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import ar.edu.unlp.info.bd2.repositories.CentreRepository;
import ar.edu.unlp.info.bd2.repositories.NurseRepository;
import ar.edu.unlp.info.bd2.repositories.PersonalRepository;
import ar.edu.unlp.info.bd2.repositories.SupportStaffRepository;
import ar.edu.unlp.info.bd2.repositories.VaccineRepository;

public class SpringDataVaxService implements VaxService{

	CentreRepository centreRepository;
	SupportStaffRepository supportStaffRepository;
	NurseRepository nurseRepository;
	PersonalRepository personalRepository;
	VaccineRepository vaccineRepository;
	
	
	public SpringDataVaxService(CentreRepository centreRepository, SupportStaffRepository supportStaffRepository, 
			NurseRepository nurseRepository, PersonalRepository personalRepository, VaccineRepository vaccineRepository){
		this.centreRepository = centreRepository;
		this.nurseRepository = nurseRepository;
		this.supportStaffRepository = supportStaffRepository;
		this.personalRepository = personalRepository;
		this.vaccineRepository = vaccineRepository;
	}

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
		public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException;

		/**
		 *
		 * @param name nombre de la vacuna
		 * @return la vacuna creada
		 * @throws VaxException
		 */
		Vaccine createVaccine(String name) throws VaxException;

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
		Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException;
		

		/**
		 * 
		 * @param email email del usuario
		 * @return
		 */
		Optional<Patient> getPatientByEmail(String email);


		/**
		 *
		 * @param name nombre de la vacuna
		 * @return
		 */
		public Optional<Vaccine> getVaccineByName(String name){
			return this.vaccineRepository.getVaccineByName(name);
		}

		/**
		 *
		 * @param name nombre del centro de vacunación
		 * @return el centro de vacunación nuevo
		 * @throws VaxException
		 */
		Centre createCentre(String name) throws VaxException;

		/**
		 * @param dni el dni
		 * @param fullName nombre del/la enfermero/a
		 * @param experience experiencia en años
		 * @return el enfermero creado
		 * @throws VaxException
		 */
		Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException;

		/**
		* @param dni el dni
		* @param fullName nombre completo
		* @param area el area o areas de trabajo
		* @return el personal de apoyo creado
		* @throws VaxException
		* */
		SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException;

		/**
		 * @return el esquema nueva vacío
		 * @throws VaxException
		 * */
		VaccinationSchedule createVaccinationSchedule() throws VaxException;

		/**
		 * @param id el id del esquema
		 * @return el esquema de vacunación
		 * */
		VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException;

		/**
		 * @param name el nombre del centro a buscar
		 * @return el centro
		 * */
		@Query
		public Optional<Centre> getCentreByName(String name) throws VaxException{
			return centreRepository.getCentreByName(name);
		}

		/**
		 * @param staff el staff a actualizar
		 * @return el staff
		 * @throws VaxException 
		 */
		SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException;

		/**
		 * @param centre el centre a actualizar
		 * @return el centre
		 * @throws VaxException 
		 */
		Centre updateCentre(Centre centre);

		/**
		 * @param dni el dni del SupportStaff a buscar
		 * @return el SupportStaff
		 * */
		public Optional<SupportStaff> getSupportStaffByDni(String dni){
			return supportStaffRepository.getSupportStaffByDni(dni);
		}
		
		/**
		 * 
		 * @param schedule
		 * @return el VaccinationSchedule actualizado.
		 */
		VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule);
		
		VaccinationSchedule getVaccinationScheduleById(int id);
	
		public List<Nurse> getNurseWithMoreThanNYearsExperience(int years){
			return this.nurseRepository.getNurseWithMoreThanNYearsExperience(years);
		}
		
		public List<Nurse> getNurseNotShot() { return this.nurseRepository.getNurseNotShot(); }
		
		public String getLessEmployeesSupportStaffArea(){ return this.supportStaffRepository.getLessEmployeesSupportStaffArea();}

		public List<Personal> getStaffWithName(String name){
			return this.personalRepository.getStaffWithName(name);
		}
}
