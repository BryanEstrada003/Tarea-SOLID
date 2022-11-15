/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema2;

import ManejoArchivo.Lectura;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Servicio {
    private tipoServicio tipoS;
    private LocalDateTime fechaHora;
    private int codigoServicio;
    private Ruta ruta;
    private Double valorapagar;
    private tipoPago tipoP;
    
    Scanner sc = new Scanner(System.in);
    
    /**
    * Método que devuelve la ruta del servicio.
    * @return Devuelve una Ruta que indica el origen y destino del servicio.
    * @author Dante Astudillo 
    * @author Alex Bermudez
    * @author Melanie Peñaherrera
    */
    public Ruta getRuta(){
        return ruta;
    }
    
    /**
    * Método constructor parametrizado de la clase Servicio.
    * @param fechaHora Fecha y hora actual en la que se pidió el servicio.
    * @param codigo Codigo del servicio.
    */
    protected Servicio(LocalDateTime fechaHora, int codigo){
        this.fechaHora = fechaHora;
        this.codigoServicio = codigo;
        Ruta ruta = new Ruta();   
        this.ruta = ruta;
    }
    
    /**
    * Método que devuelve el tipo del servicio.
    * @return Devuelve un tipoServicio que indica el tipo de servicio.
    */
    protected tipoServicio getTipo(){
        return tipoS;
    }
    
    /**
    * Método que devuelve la fecha y hora en la que se pidió el servicio.
    * @return Devuelve un LocalDateTime que indica la fecha y hora en la que se pidio el servico.
    */
    protected LocalDateTime getFechaHora(){
        return fechaHora;
    }
    
    /**
    * Método que devuelve el código del servicio.
    * @return Devuelve un int que representa el código del servicio.
    */
    protected int getCodigo(){
        return codigoServicio;
    }
    
    /**
    *Metodo que devuelve el valor a pagar.
    *@return {int} Devuelve un Double que representa el valor total a apgar
    */
    protected double getValorapagar(){
        return valorapagar;
        }   
    
    /**
    * Método que devuelve el tipo de pago del servicio.
    * @return Devuelve un tipoPago que indica el tipo de pago del servicio.
    */
    protected tipoPago getTipoPago(){
        return tipoP;
    }
   
    /**
    * Método que cambia el tipo de pado del servicio
    * @param tipoP Tipo de pago del servicio.
    */
    protected void setTipoPago(tipoPago tipoP){
        this.tipoP = tipoP;
    }
    
    public void setTipoS(tipoServicio tipoS){
        this.tipoS = tipoS;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public void setValorapagar(Double valorapagar) {
        this.valorapagar = valorapagar;
    }

    public void setTipoP(tipoPago tipoP) {
        this.tipoP = tipoP;
    }

    /**
    * Método que genera un String - Método vacio hecho para que sus clases hijas lo hereden
    * @param c Un objeto cliente.
    * @param co Un objeto conductor.
    * @return Devuelve null.
    */
    public String toString(Cliente c, Conductor co){
        return null;
    }
}
