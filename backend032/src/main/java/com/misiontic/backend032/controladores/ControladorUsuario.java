package com.misiontic.backend032.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.backend032.daos.UsuariosDao;
import com.misiontic.backend032.modelos.Usuarios;

@RestController
@RequestMapping("/api")
public class ControladorUsuario {
    
    @Autowired
    UsuariosDao usuarioDao;

    @GetMapping("/usuarios/{nombre}")
    public ResponseEntity<Usuarios> buscarPorNombre(@PathVariable String nombre){

        Usuarios usuario = usuarioDao.findByNombreUsuario(nombre);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
     @PostMapping("/login")
     public ResponseEntity<Usuarios> login(@RequestParam String nombreusuario, @RequestParam String clave){

        try{
        Usuarios usuario = usuarioDao.findByNombreUsuario(nombreusuario);
        if (clave.equals(usuario.getClave())){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }catch (Exception e){
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

     }


}
