package com.misiontic.backend032.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.misiontic.backend032.modelos.Roles;

public interface RolesDao extends JpaRepository<Roles, Long> {
    
}
