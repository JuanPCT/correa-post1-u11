package co.edu.ufps.inventario.reportes;
import co.edu.ufps.inventario.domain.Producto;
import co.edu.ufps.inventario.inventario.NotificadorBajoStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReporteService implements NotificadorBajoStock {
    private static final Logger LOG=LoggerFactory.getLogger(ReporteService.class);
    @Override public void notificar(Producto producto,int faltante){
        LOG.info("Reporte de bajo stock: {} requiere reponer {}",producto.nombre(),faltante);
    }
}
