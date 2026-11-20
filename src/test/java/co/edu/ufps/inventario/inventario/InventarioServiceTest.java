package co.edu.ufps.inventario.inventario;
import static org.junit.jupiter.api.Assertions.*;
import co.edu.ufps.inventario.domain.*;
import java.util.List;
import org.junit.jupiter.api.Test;
class InventarioServiceTest {
    private final InventarioService sut=new InventarioService();
    @Test void calculaFaltanteYConservaClasificacion(){
        assertEquals("Manzana [perecedero] - Conservar refrigerado; reponer 4",sut.procesar(List.of(new Producto("Manzana",TipoProducto.FRESCO,2,6))).get(0));
    }
    @Test void stockIgualAlMinimoNoRequiereReposicion(){
        assertEquals("Monitor [tecnologia] - Manejar con cuidado; stock suficiente",sut.procesar(List.of(new Producto("Monitor",TipoProducto.ELECTRONICO,5,5))).get(0));
    }
    @Test void stockMayorAlMinimoNoProduceFaltanteNegativo(){
        assertEquals("Camisa [textil] - Almacenar seco; stock suficiente",sut.procesar(List.of(new Producto("Camisa",TipoProducto.ROPA,8,3))).get(0));
    }
    @Test void procesaVariasCategoriasSinCambiarOrden(){
        var salida=sut.procesar(List.of(new Producto("Leche",TipoProducto.FRESCO,1,2),new Producto("Laptop",TipoProducto.ELECTRONICO,2,2)));
        assertEquals(2,salida.size()); assertTrue(salida.get(0).startsWith("Leche")); assertTrue(salida.get(1).startsWith("Laptop"));
    }
    @Test void rechazaListaNula(){assertThrows(IllegalArgumentException.class,()->sut.procesar(null));}
    @Test void rechazaElementoNulo(){assertThrows(IllegalArgumentException.class,()->sut.procesar(java.util.Arrays.asList((Producto)null)));}
}
