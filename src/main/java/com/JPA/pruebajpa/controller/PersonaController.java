package com.JPA.pruebajpa.controller;

import com.JPA.pruebajpa.model.Persona;
import com.JPA.pruebajpa.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    // Método GET para traer todas las personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }

    // Método POST para crear una nueva persona
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso) {
        persoServ.savePersona(perso); // No se necesita pasar el ID, lo genera la BD automáticamente.
        return "Persona creada con ID: " + perso.getId();
    }

    // Método DELETE para borrar una persona
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoServ.deletePersona(id);
        return "Persona borrada.";
    }

    // Método PUT para editar una persona
    @PutMapping("/personas/editar/{idOriginal}")
    public ResponseEntity<?> editPersona(@PathVariable Long idOriginal, @RequestBody Persona personaEditada) {
        // Buscar la persona original por el ID
        Persona personaExistente = persoServ.findPersona(idOriginal);

        if (personaExistente != null) {
            // Actualizar los campos relevantes
            personaExistente.setNombre(personaEditada.getNombre());
            personaExistente.setApellido(personaEditada.getApellido());
            personaExistente.setEdad(personaEditada.getEdad());

            // Guardar los cambios
            persoServ.savePersona(personaExistente);
            
            // Devolver una respuesta 200 OK con la persona actualizada
            return ResponseEntity.ok(personaExistente);
        } else {
            // Devolver una respuesta 404 Not Found si la persona no existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada.");
        }
    }
}
