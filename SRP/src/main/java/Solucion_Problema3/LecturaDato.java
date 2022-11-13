/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class LecturaDato {
    
    public static ArrayList<Concurso> readfromfile(String nomfile){
        ArrayList<Concurso> concursos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                //PREGUNTAR EL CAMBIO DE STRING A DATE
                //id, double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
                Concurso conc = new Concurso(Integer.parseInt(tokens[0]),Double.parseDouble(tokens[1]),tokens[2], LocalDate.parse(tokens[3]), LocalDate.parse(tokens[4]),LocalDate.parse(tokens[5]),tokens[6]);
                concursos.add(conc);
            }//se podia agregar a los concursos que habia     
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return concursos;
    } 
}
