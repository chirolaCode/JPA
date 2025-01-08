package com.JPA.pruebajpa.service;

import com.JPA.pruebajpa.model.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona(Persona perso);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);

    public void editPersona(Long idOriginal, Long idNueva, String nuevoApellido,
                             String nuevoNombre, int nuevaEdad);

    public void editPersona(Persona per);
}
