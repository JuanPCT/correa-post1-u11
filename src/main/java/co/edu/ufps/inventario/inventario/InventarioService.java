package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.Producto;
import java.util.ArrayList;
import java.util.List;
public class InventarioService {
    private final ClasificadorProducto clasificador=new ClasificadorProducto();
    private final EtiquetadoProducto etiquetado=new EtiquetadoProducto();
    public List<String> procesar(List<Producto> productos){
        if(productos==null)throw new IllegalArgumentException("La lista es obligatoria");
        List<String> resumen=new ArrayList<>();
        for(Producto producto:productos){
            if(producto==null)throw new IllegalArgumentException("El producto no puede ser null");
            int faltante=producto.stockMinimo()-producto.stock();
            if(faltante<0)faltante=0;
            String clasificacion=clasificador.clasificar(producto.tipo());
            String etiqueta=etiquetado.generarEtiqueta(producto.tipo());
            String linea=producto.nombre()+" ["+clasificacion+"] - "+etiqueta;
            if(faltante>0)linea+="; reponer "+faltante;
            else linea+="; stock suficiente";
            resumen.add(linea);
        }
        return resumen;
    }
}
