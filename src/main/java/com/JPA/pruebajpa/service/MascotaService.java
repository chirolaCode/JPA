package com.JPA.pruebajpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.JPA.pruebajpa.model.Mascota;
import com.JPA.pruebajpa.repository.IMascotaRepository;


@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota>listaMascotas=repoMasco.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long idMascota) {
        repoMasco.deleteById(idMascota);        
    }

    @Override
    public Mascota findMascota(Long idMascota) {
        return repoMasco.findById(idMascota).orElse(null);
    
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascota_nueva, String nuevoNombre, String nuevaEspecie,
            String nuevaRaza, String nuevoColor) {

                Mascota masco = this.findMascota(idOriginal);
                if (masco != null){ 
                    masco.setId_mascota(id_mascota_nueva);
                    masco.setNombre(nuevoNombre);
                    masco.setEspecie(nuevaEspecie);
                    masco.setRaza(nuevaRaza);
                    masco.setRaza(nuevaRaza);
                    masco.setColor(nuevoColor);

                    this.saveMascota(masco);

                  
            }}
}
