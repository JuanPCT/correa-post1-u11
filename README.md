# Unidad 11 — Refactorización de inventario

La primera versión conserva deliberadamente un método largo y dos switches duplicados para poder fijar la conducta con tests antes de refactorizar. El historial local separa baseline, caracterización, refactor y regla de paquetes.

```bash
mvn clean verify
```

En la entrega final, `InventarioService.procesar` delega el cálculo de reposición; `TipoProducto` encapsula clasificación y etiqueta sin switches. Los 12 tests se agregaron antes y permanecen intactos durante el cambio. ArchUnit detectó el ciclo `inventario → reportes → inventario`; la dependencia se invirtió con `NotificadorBajoStock`, definido por inventario e implementado por reportes. La prueba de ciclos y la regla de dirección vuelven a pasar después del arreglo. El ciclo se reprodujo localmente en un commit didáctico antes de repararse; el commit final debe pasar `mvn verify`.
