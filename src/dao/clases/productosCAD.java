
package dao.clases;

import Controllador.Productos;
import Conexion.Conectar;
import dao.interfaces.interface_productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class productosCAD extends Conectar implements interface_productos{
    @Override
    public boolean crear(Productos u) {
        int tamaño = obtener().size();
        u.setCuenta(tamaño);
        u.setCodigo_p(u.generar());
        System.out.println(""+u.getCodigo_p());
        conectar();
        String sql = "insert into productos (codigo_p , producto, cantidad, precio, dimension) values('" + u.getCodigo_p() + "','" + u.getProducto() + "','" + u.getCantidad() + 
                "','" + u.getPrecio()+ "','" + u.getDimension()+ "')";
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
                Logger.getLogger(productosCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Productos u) {
        conectar();
        String sql = "update productos set producto='" + u.getProducto() + "', cantidad='" + u.getCantidad() + "', precio='" + u.getPrecio() + "', dimension='" + u.getDimension()+
                "' where codigo_cliente ='" + u.getCodigo_p()+ "'";
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
                Logger.getLogger(productosCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from productos where codigo_p='" + usuario + "'";
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
                Logger.getLogger(productosCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Productos> obtener() {
        conectar();
        List<Productos> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `productos`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //String codigo_p,String producto, int cantidad, double precio, String dimension
                Productos d = new Productos(rs.getString("codigo_p"), rs.getString("producto"), rs.getInt("cantidad"), rs.getDouble("precio"), rs.getString("dimension"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(productosCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Productos buscar(String usuario){
        for(Productos ad : obtener()){
            if(ad.getCodigo_p().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
    public Productos buscar_nombre(String usuario){
        for(Productos ad : obtener()){
            if(ad.getProducto().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}
