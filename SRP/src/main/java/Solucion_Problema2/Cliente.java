/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema2;

import Solucion_Problema1.Lectura;
import java.util.ArrayList;

/**
 *
 * @author HOME
 */
public class Cliente extends Usuario{
    private String nombreApellido;
    private int numtarjetaCredito;
    private String cedula;
    private ArrayList <Servicio>ServiciosPedidos;
    
    public Cliente(String Usuario){
        ArrayList <String > clienteCL = Lectura.LeeFichero("usuarios.txt");
        for (int i = 0 ; i < clienteCL.size() ; i++){
            this.numtarjetaCredito = Integer.valueOf(clienteCL.get(i).split(",")[2]);
            this.cedula = clienteCL.get(i).split(",")[0];
            this.Usuario = Usuario;
            Contrasenia = clienteCL.get(i).split(",")[4];
            this.nombreApellido = clienteCL.get(i).split(",")[1]+" "+clienteCL.get(i).split(",")[2];
        }
        CrearServicio.solicitarDelivery();
        CrearServicio.solicitarTaxi();
        CrearServicio.consultarServicio();
        Cuenta cta = null; //solo es para el ejemplo
        CrearCuenta newCta= new CrearCuenta(cta);
     
    }

}
