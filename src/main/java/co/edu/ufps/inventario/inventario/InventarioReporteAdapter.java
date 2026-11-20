package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.reportes.ReporteService;
import java.util.List;
import co.edu.ufps.inventario.domain.Producto;
public class InventarioReporteAdapter {
    private final ReporteService reportes;
    public InventarioReporteAdapter(ReporteService reportes){this.reportes=reportes;}
    public void publicar(String titulo,List<Producto> productos){reportes.registrar(titulo,productos);}
}
