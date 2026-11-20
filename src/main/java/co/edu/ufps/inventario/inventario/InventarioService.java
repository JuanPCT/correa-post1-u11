package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.Producto;
import java.util.List;
public class InventarioService {
    private final ClasificadorProducto clasificador=new ClasificadorProducto();
    private final EtiquetadoProducto etiquetado=new EtiquetadoProducto();
    private final CalculadoraReorden calculadora;
    public InventarioService(){this(new CalculadoraReorden());}
    public InventarioService(CalculadoraReorden calculadora){this.calculadora=calculadora;}
    public List<String> procesar(List<Producto> productos){
        if(productos==null)throw new IllegalArgumentException("La lista es obligatoria");
        return productos.stream().map(this::procesarUno).toList();
    }
    private String procesarUno(Producto producto){
        if(producto==null)throw new IllegalArgumentException("El producto no puede ser null");
        return formatear(producto,calculadora.calcular(producto));
    }
    private String formatear(Producto producto,int faltante){
        String detalle=producto.nombre()+" ["+clasificador.clasificar(producto.tipo())+"] - "+etiquetado.generarEtiqueta(producto.tipo());
        return detalle+(faltante>0?"; reponer "+faltante:"; stock suficiente");
    }
}
