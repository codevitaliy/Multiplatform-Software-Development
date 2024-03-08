package com.example.vpopovych.vpopovych_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VPopovychService {
    @Autowired
    private VPopovychRepository vPopovychRepository;

    //metodo principal para crear nuevos objetos Vpopovych

    public void crearVPopovych(VPopovych vPopovych) {
        vPopovychRepository.save(vPopovych);
    }

    //editar los objetos

    public ResponseEntity<String> editarVPopovych(Integer id, VPopovych vPopovych) {

        Optional<VPopovych> vPopovychOptional = vPopovychRepository.findById(id);

        if (!vPopovychOptional.isPresent()) {
            return ResponseEntity.status(209).body(" no encontrado");
        }

        VPopovych vPopovychExistente = vPopovychOptional.get();
        boolean esActualizacionParcial = false;

        if (vPopovych.getNombre() != null) {
            vPopovychExistente.setNombre(vPopovych.getNombre());
        } else {
            esActualizacionParcial = true;
        }

        if (vPopovych.getApellidos() != null) {
            vPopovychExistente.setApellidos(vPopovych.getApellidos());
        } else {
            esActualizacionParcial = true;
        }

        if (vPopovych.getEmail() != null) {
            vPopovychExistente.setEmail(vPopovych.getEmail());
        } else {
            esActualizacionParcial = true;
        }

        vPopovychRepository.save(vPopovychExistente);

        if (esActualizacionParcial) {
            return ResponseEntity.status(201).body(" editado parcialmente");
        } else {
            return ResponseEntity.ok(" editado!");
        }
    }

    // borrar datos 

    public boolean borrarVPopovych(Integer id) {
        if (vPopovychRepository.findById(id).isPresent()) {
            vPopovychRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // obtener un objeto especifico con un id

    public Optional<VPopovych> obtenerVPopovych(Integer id) {
        return vPopovychRepository.findById(id);
    }

    //mostrar todos los objetos creados

    public List<VPopovych> obtenerTodas() {
        return vPopovychRepository.findAll();
    }

    // actualizar los datos en las tablas 

    public Optional<VPopovych> actualizarVPopovych(Integer id, VPopovych vPopovych) {
        Optional<VPopovych> p = vPopovychRepository.findById(id);
        if (p.isPresent()) {
            p.get().setNombre(vPopovych.getNombre());
            p.get().setApellidos(vPopovych.getApellidos());
            p.get().setEmail(vPopovych.getEmail());
            vPopovychRepository.saveAndFlush(p.get()); // con flush hace que los cambios sean de inmediato
        }
        return p;
    }

    //borrar todo lo que aparece en la tabla 

    public void borrarTodos() {
        vPopovychRepository.deleteAll();
    }

    // modifica el saldo

    public void modificarSaldos(VPopovych vPopovych) {
        vPopovychRepository.save(vPopovych);
    }

    //genera la media de los saldos que los objetos que encuentra

    public Double mediaSaldos() {

        List<VPopovych> todos = vPopovychRepository.findAll();
        double suma = 0;
        for (VPopovych vPopovych : todos) {
            suma += vPopovych.getSaldo();
        }

        double media = suma / todos.size(); // devuelve el numero de objetos en la lista
        return media;
    }

}
