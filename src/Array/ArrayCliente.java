
package Array;

import Controllador.Cliente;
import java.util.ArrayList;

public class ArrayCliente implements Array{
    
    private static ArrayList<Cliente> clientes = new ArrayList();
    static int cuenta = 0;

    public ArrayCliente() {
//        if(cuenta==0){
//            clientes.add(new Cliente("Ayde", "Campos", "74184231", 32));
//            clientes.add(new Cliente("Hennry", "Pinto", "07412985", 28));
//            clientes.add(new Cliente("Mauricio", "Ayala", "74532159", 29));
//            clientes.add(new Cliente("Franco", "Porras", "79563111", 35));
//            clientes.add(new Cliente("Elvira", "Torres", "78100225", 24));
//            cuenta++;
//        }
        
    }
    
    public void agregar_cliente(Cliente c){
        clientes.add(c);
    }
    
    @Override
    public int tamaño(){
        return clientes.size();
    }
    
    public Cliente obtener(int posicion){
        return clientes.get(posicion);
    }
    
    public void eliminar_cliente(int posicion){
        clientes.remove(posicion);
    }
    
    public int buscar_cliente(String codigo){
        int pos = -1 ;
        for (int i = 0; i < tamaño(); i++) {
            if(obtener(i).getCodigo_cliente().equals(codigo)){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> aClientes) {
        clientes = aClientes;
    }
    
}
