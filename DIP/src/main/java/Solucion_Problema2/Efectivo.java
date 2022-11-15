/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema2;

/**
 *
 * @author HOME
 */
public class Efectivo implements IEfectivo{
    String monedaTipo;
    int cantidad;

    public Efectivo(String monedaTipo, int cantidad) {
        this.monedaTipo = monedaTipo;
        this.cantidad = cantidad;
    }
    
}
