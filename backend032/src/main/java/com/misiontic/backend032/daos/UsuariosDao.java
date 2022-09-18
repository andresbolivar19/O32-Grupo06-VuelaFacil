package com.misiontic.backend032.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic.backend032.modelos.Usuarios;

public interface UsuariosDao extends JpaRepository<Usuarios, Long>{
  
public Usuarios findByNombreUsuario(String nombreUsuario);

}
