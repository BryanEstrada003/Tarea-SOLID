/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sol_P1;

import ManejoArchivo.Escritura;

/**
 *
 * @author HOME
 */
public class CrearCuenta {
    private Cuenta cta;
    public CrearCuenta(Cuenta cta){// creacion de cuenta  para cliente
        String linea = cta.Cedula+","+cta.nombre+","+cta.Apellido+","+cta.User+","+cta.Contrasenia+","+cta.celular ;
        String linea2 = cta.Cedula+","+cta.edad+","+cta.numtarjeta ;
        Escritura.EscribirArchivo("usuarios.txt",linea);//se guarda los datos en un orden al archivo "  .txt"
        Escritura.EscribirArchivo("clientes.txt",linea2);
    }
}
