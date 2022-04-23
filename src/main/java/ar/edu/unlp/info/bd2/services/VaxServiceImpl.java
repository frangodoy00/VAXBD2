package ar.edu.unlp.info.bd2.services;

import ar.edu.unlp.info.bd2.repositories.VaxRepository;

/*Aqui se debe realizar la implementacion de todos los metodos declarados en VaxService*/
public class VaxServiceImpl implements VaxService{
    private VaxRepository repository;
    public VaxServiceImpl(VaxRepository repository) {this.repository = repository;}
}
