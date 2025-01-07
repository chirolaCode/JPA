package com.JPA.pruebajpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JPA.pruebajpa.model.Persona;
import com.JPA.pruebajpa.repository.IPersonaRepository;



@Service
public class PersonaService implements IPersonaService   {

    @Autowired 
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona>listaPersonas=persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);

    }

    @Override
    public Persona findPersona(Long id) {
        Persona  perso=persoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoApellido, String nuevoNombre,
     int nuevaEdad) {
        Persona perso=this.findPersona(idOriginal);

        perso.setId(idNueva);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
     
        this.savePersona(perso);

        
    }

} 