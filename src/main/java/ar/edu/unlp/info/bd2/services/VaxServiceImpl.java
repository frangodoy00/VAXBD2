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
     * @param name nombre del centro de vacunación
     * @return el centro de vacunación nuevo
     * @throws VaxException
     */
    Centre createCentre(String name) throws VaxException{
        Centre centro = new Centre(name);
        this.servicio.addCentre(centro);
        return centro;
    }

}
