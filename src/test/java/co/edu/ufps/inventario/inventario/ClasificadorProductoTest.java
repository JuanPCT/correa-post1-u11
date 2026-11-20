package co.edu.ufps.inventario.inventario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import co.edu.ufps.inventario.domain.TipoProducto;
import org.junit.jupiter.api.Test;
class ClasificadorProductoTest {
    private final ClasificadorProducto sut=new ClasificadorProducto();
    @Test void frescoEsPerecedero(){assertEquals("perecedero",sut.clasificar(TipoProducto.FRESCO));}
    @Test void electronicoEsTecnologia(){assertEquals("tecnologia",sut.clasificar(TipoProducto.ELECTRONICO));}
    @Test void ropaEsTextil(){assertEquals("textil",sut.clasificar(TipoProducto.ROPA));}
}
