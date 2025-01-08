package com.JPA.pruebajpa.service;

import com.JPA.pruebajpa.model.Mascota;
import java.util.List;


public interface IMascotaService {
    public List<Mascota> getMascotas();

    public void saveMascota(Mascota masco);

    public void deleteMascota(Long idMascota);

    public Mascota findMascota(Long idMascota);

    public void editMascota(Long idOriginal, Long idMascotaNueva, String nuevoNombre,
                            String nuevaEspecie, String nuevaRaza, String nuevoColor);
 
}
