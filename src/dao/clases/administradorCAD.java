
package dao.clases;

import Controllador.Administrador;
import Conexion.Conectar;
import dao.interfaces.interface_administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class administradorCAD extends Conectar implements interface_administrador{
    @Override
    public boolean crear(Administrador u) {
        conectar();
        String sql = "insert into administrador (usuario , contraseña, nombre, apellido, dni, habilitado, cuenta) values('" + u.getUsuario() + "','" + u.getContraseña() + "','" + u.getNombre() + 
                "','" + u.getApellidos()+ "','" + u.getDni()+ "','" + u.getHabilitado()+ "','" + u.getCuenta()+ "')";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Administrador u) {
        conectar();
        String sql = "update administrador set contraseña='" + u.getContraseña() + "', nombre='" + u.getNombre() + "', apellido='" + u.getApellidos() + "', dni='" + u.getDni()+ "', habilitado='" + u.getHabilitado()+ "', cuenta='" + u.getCuenta()+
                "' where usuario ='" + u.getUsuario()+ "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from administrador where usuario='" + usuario + "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Administrador> obtener() {
        conectar();
        List<Administrador> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `administrador`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //String nombre, String apellidos, String contraseña, String usuario, String dni, int cuenta, String habilitado
                Administrador d = new Administrador(rs.getString("nombre"), rs.getString("apellido"), rs.getString("contraseña"), rs.getString("usuario"), rs.getString("dni"), rs.getInt("cuenta"), rs.getString("habilitado"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Administrador buscar(String usuario){
        for(Administrador ad : obtener()){
            if(ad.getUsuario().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}
