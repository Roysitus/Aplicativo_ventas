
package Array;

import Controllador.Administrador;
import java.util.ArrayList;

public class ArrayAdministrador implements Array{
    
    private static ArrayList<Administrador> administradores = new ArrayList();
    static int cuenta = 0;
    
    public ArrayAdministrador() {
//        if(cuenta == 0){
//            administradores.add(new Administrador("Anonimo", "Anonimo", "12345", "linux", "76511259"));
//            cuenta++;
//        }
    }
    
    public Administrador buscar_admin(String usuario){
        for (Administrador a: administradores) {
            if(a.getUsuario().equals(usuario)){
                return a;
            }
        }
        return null;
    }
    
    public int buscar_admin_pos(String usuario){
        int pos = -1;
        for (int i = 0; i < tamaño(); i++) {
            if(obtener(i).getUsuario().equals(usuario)){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public void agregar_administrador(Administrador a){
        administradores.add(a);
    }
    
    public void eliminar_administrador(int pos){
        administradores.remove(pos);
    }
    
    @Override
    public int tamaño(){
        return administradores.size();
    }
    
    public Administrador obtener(int pos){
        return administradores.get(pos);
    }
    
    public static ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public static void setAdministradores(ArrayList<Administrador> aAdministradores) {
        administradores = aAdministradores;
    }
    
    
  
}
