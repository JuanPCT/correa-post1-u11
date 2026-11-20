package co.edu.ufps.inventario.inventario;
import co.edu.ufps.inventario.domain.Producto;
public interface NotificadorBajoStock { void notificar(Producto producto,int faltante); }
