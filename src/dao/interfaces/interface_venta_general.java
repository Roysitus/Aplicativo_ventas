
package dao.interfaces;

import Controllador.Ventas_general;
import java.util.List;

public interface interface_venta_general {
    public boolean crear(Ventas_general u);
    public boolean actualizar(Ventas_general u);
    public boolean borrar(String usuario);
    public List<Ventas_general> obtener();
}
