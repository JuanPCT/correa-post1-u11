package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.TipoProducto;
public class EtiquetadoProducto {
    public String generarEtiqueta(TipoProducto tipo){
        return switch(tipo){case FRESCO->"Conservar refrigerado";case ELECTRONICO->"Manejar con cuidado";case ROPA->"Almacenar seco";};
    }
}
