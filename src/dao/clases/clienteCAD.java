
package dao.clases;

import Controllador.Cliente;
import Conexion.Conectar;
import dao.interfaces.interface_cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteCAD extends Conectar implements interface_cliente{
    @Override
    public boolean crear(Cliente u) {
        int tamaño = obtener().size();
        u.setCuenta(tamaño);
        u.setCodigo_cliente(u.generar());
        System.out.println(""+u.getCodigo_cliente());
        conectar();
        String sql = "insert into cliente (codigo_cliente , nombre, apellido, dni, edad, monto_compras_realizadas) values('" + u.getCodigo_cliente() + "','" + u.getNombre() + "','" + u.getApellido() + 
                "','" + u.getDni()+ "','" + u.getEdad()+ "','" + u.getMonto_compras_realizadas()+ "')";
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
                Logger.getLogger(clienteCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Cliente u) {
        conectar();
        String sql = "update cliente set nombre='" + u.getNombre() + "', apellido='" + u.getApellido() + "', dni='" + u.getDni() + "', edad='" + u.getEdad()+ "', monto_compras_realizadas='" + u.getMonto_compras_realizadas()+
                "' where codigo_cliente ='" + u.getCodigo_cliente()+ "'";
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
                Logger.getLogger(clienteCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from cliente where codigo_cliente='" + usuario + "'";
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
                Logger.getLogger(clienteCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Cliente> obtener() {
        conectar();
        List<Cliente> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `cliente`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //String codigo_cliente,String nombre, String apellido, String dni, int edad, double monto_compras_realizadas
                Cliente d = new Cliente(rs.getString("codigo_cliente"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("dni"), rs.getInt("edad"), rs.getDouble("monto_compras_realizadas"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(clienteCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Cliente buscar(String usuario){
        for(Cliente ad : obtener()){
            if(ad.getCodigo_cliente().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}
