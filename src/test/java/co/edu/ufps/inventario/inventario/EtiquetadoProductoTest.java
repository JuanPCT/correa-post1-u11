package co.edu.ufps.inventario.inventario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import co.edu.ufps.inventario.domain.TipoProducto;
import org.junit.jupiter.api.Test;
class EtiquetadoProductoTest {
    private final EtiquetadoProducto sut=new EtiquetadoProducto();
    @Test void frescoRequiereFrio(){assertEquals("Conservar refrigerado",sut.generarEtiqueta(TipoProducto.FRESCO));}
    @Test void electronicoSeManejaConCuidado(){assertEquals("Manejar con cuidado",sut.generarEtiqueta(TipoProducto.ELECTRONICO));}
    @Test void ropaSeAlmacenaSeca(){assertEquals("Almacenar seco",sut.generarEtiqueta(TipoProducto.ROPA));}
}
