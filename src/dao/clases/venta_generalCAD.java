
package dao.clases;

import Controllador.Ventas_general;
import Conexion.Conectar;
import dao.interfaces.interface_venta_general;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class venta_generalCAD extends Conectar implements interface_venta_general{
    @Override
    public boolean crear(Ventas_general u) {
        int tamaño = obtener().size();
        u.setCuenta(tamaño);
        u.setCodigo_venta(u.generar());
        System.out.println(""+u.getCodigo_p());
        conectar();
        String sql = "insert into venta_general (codigo_venta , codigo_p, compra, descuento, total) values('" + u.getCodigo_venta() + "','" + u.getCodigo_p() + "','" + u.getCompra()+ 
                "','" + u.getDescuento()+ "','" + u.getTotal()+ "')";
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
                Logger.getLogger(venta_generalCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Ventas_general u) {
        conectar();
        String sql = "update venta_general set codigo_p='" + u.getCodigo_p() + "', compra='" + u.getCompra() + "', descuento='" + u.getDescuento() + "', total='" + u.getTotal()+
                "' where codigo_venta ='" + u.getCodigo_venta()+ "'";
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
                Logger.getLogger(venta_generalCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from venta_general where codigo_venta='" + usuario + "'";
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
                Logger.getLogger(venta_generalCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Ventas_general> obtener() {
        conectar();
        List<Ventas_general> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `venta_general`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //String codigo_venta, String codigo_p, double compra, double descuento, double total
                Ventas_general d = new Ventas_general(rs.getString("codigo_venta"), rs.getString("codigo_p"), rs.getDouble("compra"), rs.getDouble("descuento"), rs.getDouble("total"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(venta_generalCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Ventas_general buscar(String usuario){
        for(Ventas_general ad : obtener()){
            if(ad.getCodigo_venta().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}
