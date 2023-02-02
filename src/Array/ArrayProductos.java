
package Array;

import Controllador.Productos;
import java.util.ArrayList;

public class ArrayProductos implements Array{
    
    private static ArrayList<Productos> productos = new ArrayList();
    static int cuenta = 0;

    public ArrayProductos() {
//        if(cuenta == 0){
//            productos.add(new Productos("Planchas Tecnopor", 120, 10.0));
//            productos.add(new Productos("Ladrillos Tecnopor", 120, 20.0));
//            productos.add(new Productos("Perlas Tecnopor", 120, 15.5));
//            productos.add(new Productos("Envases Tecnopor", 120, 30.5));
//            productos.add(new Productos("Cielo Raso Tecnopor", 120, 22.5));
//            productos.add(new Productos("Bovedillas y Casetones de Tecnopor", 120, 28.5));
//            productos.add(new Productos("Molduras y Comisas de Tecnopor", 120, 35.5));
//            cuenta++;
//        }
    }
    
    public void agregar_producto(Productos p){
        productos.add(p);
    }
    
    public void eliminar_producto(int pos){
        productos.remove(pos);
    }
    
    public Productos obtener(int pos){
        return productos.get(pos);
    }
    
    @Override
    public int tamaño(){
        return productos.size();
    }
    
    public int buscar_producto(String codigo){
        int pos = -1;
        for (int i = 0; i < tamaño() ; i++) {
            if(productos.get(i).getCodigo_p().equals(codigo)){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public int buscar_producto_nombre(String producto){
        int pos = -1;
        for (int i = 0; i < tamaño() ; i++) {
            if(productos.get(i).getProducto().equals(producto)){
                pos = i;
                break;
            }
        }
        return pos;
    } 
    
    public static ArrayList<Productos> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Productos> aProductos) {
        productos = aProductos;
    }
    
    
    
}
