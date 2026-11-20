package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.Producto;
import java.util.List;
public class InventarioService {
    private final ClasificadorProducto clasificador=new ClasificadorProducto();
    private final EtiquetadoProducto etiquetado=new EtiquetadoProducto();
    private final CalculadoraReorden calculadora;
    private final NotificadorBajoStock notificador;
    public InventarioService(){this(new CalculadoraReorden(),(producto,faltante)->{});}
    public InventarioService(CalculadoraReorden calculadora,NotificadorBajoStock notificador){
        this.calculadora=calculadora; this.notificador=notificador;
    }
    public List<String> procesar(List<Producto> productos){
        if(productos==null)throw new IllegalArgumentException("La lista es obligatoria");
        return productos.stream().map(this::procesarUno).toList();
    }
    private String procesarUno(Producto producto){
        if(producto==null)throw new IllegalArgumentException("El producto no puede ser null");
        int faltante=calculadora.calcular(producto);
        if(faltante>0)notificador.notificar(producto,faltante);
        return formatear(producto,faltante);
    }
    private String formatear(Producto producto,int faltante){
        String detalle=producto.nombre()+" ["+clasificador.clasificar(producto.tipo())+"] - "+etiquetado.generarEtiqueta(producto.tipo());
        return detalle+(faltante>0?"; reponer "+faltante:"; stock suficiente");
    }
}
