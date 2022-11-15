/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Problema2;

import java.time.LocalDateTime;

/**
 *
 * @author HOME
 */
public class Encomienda implements IEncomienda{
    private int cantidadProductos;
    public Encomienda(tipoServicio tipoS, LocalDateTime fechaHora, int codigo, int cantProd){   
        this.cantidadProductos = cantProd;
    } 

    @Override
    public void solicitarEncomienda() {
//  operaciones
    }
}
