/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class NextConcurso {
    public static Concurso nextConcurso(Scanner sc){
        //id double costo, String nombre, Date fecha, Date fechainscripcion, Date fechaCierreinscripcion, String tematica
        sc.useDelimiter("\n");
        System.out.println("Su id es:");
        int id = LecturaDato.readfromfile("concursos.txt").size() + 1;     
        System.out.println(id);
        System.out.println("Ingrese costo:");
        double cost = sc.nextDouble();
        System.out.println("Ingrese nombre:");
        String nom = sc.next();
        System.out.println("Ingrese fecha del evento(yyyy-mm-dd):");
        LocalDate fech = LocalDate.parse(sc.next());
        System.out.println("Ingrese fecha inscripcion(yyyy-mm-dd):");
        LocalDate finsp = LocalDate.parse(sc.next());
        System.out.println("Ingrese fecha Cierro inscripcion(yyyy-mm-dd):");
        LocalDate fcinsp = LocalDate.parse(sc.next());
        System.out.println("Ingrese su tematica:");
        String tem = sc.next();
                
        Concurso conc = new Concurso(id,cost,nom,fech,finsp,fcinsp,tem);   
        return conc;
        
    }
}
