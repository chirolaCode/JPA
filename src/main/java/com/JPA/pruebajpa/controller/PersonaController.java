package com.JPA.pruebajpa.controller;

import com.JPA.pruebajpa.model.Persona;
import com.JPA.pruebajpa.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController{

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
    }
    
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);

        return "Persona creada.";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "Persona borrada.";
    }

    @PutMapping("/personas/editar/{idOriginal}")
    public Persona editPersona(@PathVariable Long idOriginal,
     @RequestParam(required = false, name="id") Long nuevaId,
     @RequestParam(required=false, name="apellido") String apellido,
     @RequestParam(required=false, name="nombre") String nombre,
     @RequestParam(required=false, name="edad") int edad){
        persoServ.editPersona(idOriginal, nuevaId, nombre, apellido, edad);

        Persona perso= persoServ.findPersona(nuevaId);
        return perso;
    }
}