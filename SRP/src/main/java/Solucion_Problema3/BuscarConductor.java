/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema3;

import Solucion_Problema1.Lectura;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class BuscarConductor {
    
    protected String buscarConductor(Servicio s){
        ArrayList <String> conductores = Lectura.LeeFichero("conductores.txt");
        String cedConductorAsignado ="";
        for(String conductor : conductores){
            String estadoCond = conductor.split(",")[2];
            int codVehiculo = Integer.valueOf(conductor.split(",")[3]);
            if (estadoCond.equals("D") ){
                Vehiculo veh = new Vehiculo(codVehiculo);
                String tipo = veh.getTipoVehiculo();
                switch(s.getTipo()){
                    case TAXI:
                        if (tipo.equals("A")){
                            cedConductorAsignado = conductor.split(",")[0];
                        }
                        break;
                    case DELIVERY:
                        if (tipo.equals("M")){
                            cedConductorAsignado = conductor.split(",")[0];
                        }
                        break;
                    case ENCOMIENDA:
                        if (tipo.equals("M")){
                            cedConductorAsignado = conductor.split(",")[0];
                        }
                        break;
                } 
            }
        } 
        return cedConductorAsignado;
    }
}
