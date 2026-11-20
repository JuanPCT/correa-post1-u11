package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.TipoProducto;
public class EtiquetadoProducto {
    public String generarEtiqueta(TipoProducto tipo){return tipo.etiqueta();}
}
