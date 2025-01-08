package com.JPA.pruebajpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JPA.pruebajpa.model.Persona;
import com.JPA.pruebajpa.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso); // El ID lo genera la base de datos automáticamente
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoApellido, String nuevoNombre,
                             int nuevaEdad) {
        Persona perso = this.findPersona(idOriginal);
        if (perso != null) {
            perso.setId(idOriginal); // No debes cambiar el ID
            perso.setNombre(nuevoNombre);
            perso.setApellido(nuevoApellido);
            perso.setEdad(nuevaEdad);
            this.savePersona(perso);
        }
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);    
    }
}
