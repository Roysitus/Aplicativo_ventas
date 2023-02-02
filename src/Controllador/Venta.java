
package Controllador;

import Array.ArrayCliente;

public class Venta {
    
    public double compra(double precio, int cantidad){
        return precio * cantidad;
    }
    
    public double descuento(int cantidad, double compra){
        double des = 0;
        if(cantidad<=12){
            des = compra * 0.01;
        }else if(cantidad>12 && cantidad<=24){
            des = compra * 0.02;
        }else if(cantidad>24 && cantidad<=36){
            des = compra * 0.05;
        }else if(cantidad>36 && cantidad<=48){
            des = compra * 0.07;
        }else if(cantidad>48 && cantidad<=96){
            des = compra * 0.10;
        }else{
            des = compra * 0.15;
        } 
        return des;
    }
    
    
    public double descuento_cliente(double descuento, double compra){
        return (compra - descuento) * 0.03;
    }
    
    public double total_con_cliente(double descuento_normal , double descuento_cliente, double compra){
        return compra - descuento_cliente - descuento_normal;
    }
    
    public String boleta(double descuento_normal, double descuento_cliente, double compra, double total){
        return "Boleta de Compra:"+ "\n\n" +
                
               "Valor Compra      \t:"+compra+"\n"+
               "Descuento General \t:"+descuento_normal+"\n"+
               "Descuento Cliente \t:"+descuento_cliente+"\n"+
               "Total de la compra\t:"+total;
    }
    
}
