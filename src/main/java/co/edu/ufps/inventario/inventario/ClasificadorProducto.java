package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.TipoProducto;
public class ClasificadorProducto {
    public String clasificar(TipoProducto tipo){
        return switch(tipo){case FRESCO->"perecedero";case ELECTRONICO->"tecnologia";case ROPA->"textil";};
    }
}
