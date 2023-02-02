
package Controllador;

public class Productos implements Codigo{

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int aCuenta) {
        cuenta = aCuenta;
    }
    
    private String codigo_p;
    private String producto;
    private int cantidad;
    private double precio;
    private String dimension;
    private static int cuenta = 0;

    public Productos(String codigo_p,String producto, int cantidad, double precio, String dimension) {
        this.codigo_p = codigo_p;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dimension = dimension;
    }

    @Override
    public String generar(){
        return "CODP00"+cuenta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(String codigo_p) {
        this.codigo_p = codigo_p;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
    
    
    
}
