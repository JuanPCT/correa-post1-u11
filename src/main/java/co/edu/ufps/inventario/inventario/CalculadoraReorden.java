package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.Producto;
public class CalculadoraReorden {
    public int calcular(Producto producto){return Math.max(0,producto.stockMinimo()-producto.stock());}
}
