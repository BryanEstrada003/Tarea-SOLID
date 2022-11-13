/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author HOME
 */
public class RegistroDato{
    private Concurso concurso;
    private String nomfile;
    public RegistroDato(Concurso c, String n){
        this.concurso=c;
        this.nomfile=n;
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(this.nomfile),true)))
        {
            //id, double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
            pw.println(this.concurso.id+"|"+this.concurso.costo+"|"+this.concurso.nombre+"|"+this.concurso.fechaevento+"|"+this.concurso.fechainscripcion+"|"+this.concurso.fechaCierreinscripcion+"|"+this.concurso.tematica);        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
