
package Controllador;

public class Cliente implements Codigo{

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int aCuenta) {
        cuenta = aCuenta;
    }

    private String codigo_cliente, nombre, apellido, dni;
    private int edad;
    private double monto_compras_realizadas;
    private static int cuenta = 0;
    
    public Cliente(String codigo_cliente,String nombre, String apellido, String dni, int edad, double monto_compras_realizadas) {
        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.monto_compras_realizadas = monto_compras_realizadas;
    }
    
    @Override
    public String generar(){
        return "CLI"+cuenta++;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getMonto_compras_realizadas() {
        return monto_compras_realizadas;
    }

    public void setMonto_compras_realizadas(double monto_compras_realizadas) {
        this.monto_compras_realizadas = monto_compras_realizadas;
    }
    
    
    
}
