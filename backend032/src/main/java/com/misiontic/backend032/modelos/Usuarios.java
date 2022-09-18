package com.misiontic.backend032.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long idUsuario;

     @Column(name="nombreusuario", unique = true, nullable = false)
     private String nombreUsuario;

     @Column(name="email", unique = true, nullable = false)
     private String email;

     @Column(name="clave", nullable = false)
     private String clave;

   
     @ManyToOne
     @JoinColumn(name="idRol")
     private Roles roles;

    public Usuarios() {
    }


    public Usuarios(String nombreUsuario, String email, String clave, Roles roles) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.clave = clave;
        this.roles = roles;
    }


    public long getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }


    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getClave() {
        return clave;
    }


    public void setClave(String clave) {
        this.clave = clave;
    }


    public Roles getRoles() {
        return roles;
    }


    public void setRoles(Roles roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Usuarios [clave=" + clave + ", email=" + email + ", idUsuario=" + idUsuario + ", nombreUsuario="
                + nombreUsuario + ", roles=" + roles + "]";
    }

     
    


}
