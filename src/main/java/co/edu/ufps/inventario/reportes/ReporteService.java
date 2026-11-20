package co.edu.ufps.inventario.reportes;
import co.edu.ufps.inventario.domain.Producto;
import co.edu.ufps.inventario.inventario.InventarioService;
import java.util.List;
public class ReporteService {
    private final InventarioService inventario;
    public ReporteService(InventarioService inventario){this.inventario=inventario;}
    public void registrar(String titulo,List<Producto> productos){inventario.procesar(productos);}
}
