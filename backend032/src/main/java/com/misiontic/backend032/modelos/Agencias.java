package com.misiontic.backend032.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Los arroba son las anotaciones para SprintgBoot
@Entity
@Table(name = "agencias")

public class Agencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgencia;

    @Column(name = "nombreAgencia", nullable = false)
    private String nombreAgencia;

    @Column(name = "direccionAgencia", nullable = false)
    private String direccionAgencia;

    public Agencias() {
    }

    public Agencias(String nombreAgencia, String direccionAgencia) {
        this.nombreAgencia = nombreAgencia;
        this.direccionAgencia = direccionAgencia;
    }

    public long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(long idAgencia) {
        this.idAgencia = (int) idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getDireccionAgencia() {
        return direccionAgencia;
    }

    public void setDireccionAgencia(String direccionAgencia) {
        this.direccionAgencia = direccionAgencia;
    }

    @Override
    public String toString() {
        return "Agencias [idAgencia=" + idAgencia + ", nombreAgencia=" + nombreAgencia + ", direccionAgencia=" + direccionAgencia + "]";
    }
}
