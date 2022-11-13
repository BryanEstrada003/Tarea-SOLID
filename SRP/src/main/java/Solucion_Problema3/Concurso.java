/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solucion_Problema3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dell
 */

//concursos.txt
//id|valor|nombre|fevento|finscrip|fcierreinsc|tematica

public class Concurso {
    int id;
    double costo;
    String nombre;
    LocalDate fechaevento;
    LocalDate fechainscripcion;
    LocalDate fechaCierreinscripcion;
    String tematica;
    ArrayList<Inscripcion> inscripciones;
    ArrayList<Premio> premios;
    ArrayList<Criterio> criterios;

    public Concurso(int id, double costo, String nombre, LocalDate fechaevento, LocalDate fechainscripcion, LocalDate fechaCierreinscripcion, String tematica) {
        this.id = id;
        this.costo = costo;
        this.nombre = nombre;
        this.fechaevento = fechaevento;
        this.fechainscripcion = fechainscripcion;
        this.fechaCierreinscripcion = fechaCierreinscripcion;
        this.tematica = tematica;
    }

    public int getId() {
        return id;
    }

    public double getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaevento() {
        return fechaevento;
    }

    public LocalDate getFechainscripcion() {
        return fechainscripcion;
    }

    public LocalDate getFechaCierreinscripcion() {
        return fechaCierreinscripcion;
    }

    public String getTematica() {
        return tematica;
    }
    
    @Override
    public String toString() {
        //id double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
        return String.valueOf(this.id)+"-"+String.valueOf(this.costo)+"-"+this.nombre+"-"+String.valueOf(this.fechaevento)+"-"+String.valueOf(this.fechainscripcion)+"-"+String.valueOf(this.fechaCierreinscripcion)+"-"+this.tematica; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
