package com.misiontic.backend032.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.backend032.daos.AgenciaDao;
import com.misiontic.backend032.modelos.Agencias;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ControladorAgencia {

    @Autowired
    AgenciaDao agenciaDao;

    @PostMapping("/agencias")
    public ResponseEntity<Agencias> guardarAgencia(@RequestBody Agencias agencia) {
        Agencias nuevoAgencia = new Agencias(agencia.getNombreAgencia(), agencia.getDireccionAgencia());
        return new ResponseEntity<>(agenciaDao.save(nuevoAgencia), HttpStatus.CREATED)
    }

    @PutMapping("/agencias/{id}")
    public ResponseEntity<Agencias> actualizarAgencia(@PathVariable long id, @RequestBody Agencias agencia) {
        Optional<Agencias> _agencia = agenciaDao.findById(id);
        if (_agencia.isPresent()) {
            Agencias agenciaActualizar = _agencia.get();
            agenciaActualizar.setNombreAgencia(agencia.getNombreAgencia());
            agenciaActualizar.setDireccionAgencia(agencia.getDireccionAgencia());
            return new ResponseEntity<>(agenciaDao.save(agenciaActualizar), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/agencias")
    public ResponseEntity<List<Agencias>> listarAgencias() {

        List<Agencias> agencias = new ArrayList<Agencias>();

        agenciaDao.findAll().forEach(agencias::add);

        if (agencias.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(agencias, HttpStatus.OK);
        }

    }

    @GetMapping("/agencias/{id}")
    public ResponseEntity<Agencias> verAgencia(@PathVariable Long id) {

        Optional<Agencias> agencia = agenciaDao.findById(id);
        if (agencia.isPresent()) {
            return new ResponseEntity<>(agencia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Agencias(), HttpStatus.OK);
        }

    }

    @DeleteMapping("/agencias/{id}")
    public ResponseEntity<HttpStatus> borrarAgencia(@PathVariable Long id) {

        agenciaDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
