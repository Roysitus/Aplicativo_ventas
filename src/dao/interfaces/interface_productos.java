
package dao.interfaces;

import Controllador.Productos;
import java.util.List;

public interface interface_productos {
    public boolean crear(Productos u);
    public boolean actualizar(Productos u);
    public boolean borrar(String usuario);
    public List<Productos> obtener();
}
