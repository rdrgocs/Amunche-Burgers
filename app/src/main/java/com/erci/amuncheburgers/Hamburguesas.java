package com.erci.amuncheburgers;

import java.io.Serializable;

public class Hamburguesas implements Serializable {
    public String nombre, tipo, detalle, precio, promocion;
    public int imagen;
    //Precio se considera como String ya que no es una app que calcule precios

    public Hamburguesas(String nombre, String tipo, int imagen, String detalle, String precio, String promocion){
        this.nombre=nombre;
        this.tipo=tipo;
        this.imagen=imagen;
        this.detalle=detalle;
        this.precio=precio;
        this.promocion=promocion;
    }



}
