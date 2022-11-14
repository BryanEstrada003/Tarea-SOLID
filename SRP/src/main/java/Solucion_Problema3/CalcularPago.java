/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

/**
 *
 * @author HOME
 */
public class CalcularPago {
    protected void calcularValorPagar(tipoPago tp, Servicio s){
        double numAleatorio =Math.random()*10;
        double valorTotalPagar= 0;
        if (tp.equals(tipoPago.EFECTIVO)){
            valorTotalPagar=numAleatorio;
        }else if (tp.equals(tipoPago.TARJETA)){
            valorTotalPagar=numAleatorio*1.1;
        
        }
        
    }

    protected void calcularValorPagar(double valorTP,tipoPago tp, Servicio s){
        double precioEntrega =Math.random()*5;
        if (tp.equals(tipoPago.EFECTIVO)){
            valorTP+=precioEntrega;
        }else if (tp.equals(tipoPago.TARJETA)){
            valorTP=(valorTP+precioEntrega)*1.1;
        }
        s.setValorapagar(valorTP);
    }
}
