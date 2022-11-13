/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class BuscaId {
    //Metodo estatico que recibe el nombreConc y devuelve id
    //id, double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
    public static int buscaId(String name){
        int id = 0;
        ArrayList<Concurso> concursos = LecturaDato.readfromfile("concursos.txt");
        for (Concurso conc: concursos){
            String nomb = conc.getNombre();
            if (nomb.equals(name)){
                id = conc.getId();
            }
        }
        return id;
    }
}
