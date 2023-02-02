
package Controllador;

public class Ventas_general {
    
    private String codigo_venta, codigo_p;
    private double compra, descuento, total;
    private int cuenta;
    
    public Ventas_general(String codigo_venta, String codigo_p, double compra, double descuento, double total) {
        this.codigo_venta = codigo_venta;
        this.codigo_p = codigo_p;
        this.compra = compra;
        this.descuento = descuento;
        this.total = total;
    }

    public String generar(){
        return "VENT[G]-"+cuenta;
    }
    
    public String getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(String codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public String getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(String codigo_p) {
        this.codigo_p = codigo_p;
    }

    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    
}
