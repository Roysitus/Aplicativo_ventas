
package dao.interfaces;

import Controllador.Cliente;
import java.util.List;

public interface interface_cliente {
    public boolean crear(Cliente u);
    public boolean actualizar(Cliente u);
    public boolean borrar(String usuario);
    public List<Cliente> obtener();
}
