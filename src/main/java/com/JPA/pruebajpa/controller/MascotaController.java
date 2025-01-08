package com.JPA.pruebajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.JPA.pruebajpa.model.Mascota;
import com.JPA.pruebajpa.service.IMascotaService;


@RestController
public class MascotaController {

    @Autowired IMascotaService mascoServ;
    
    @PostMapping("/mascotas/crear")
    public String saveMascota (@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);

        return "La mascota fue creada correctamente";
    }


}
