# Unidad 11 — Refactorización de inventario

La primera versión conserva deliberadamente un método largo y dos switches duplicados para poder fijar la conducta con tests antes de refactorizar. El historial local separa baseline, caracterización, refactor y regla de paquetes.

```bash
mvn clean verify
```

En la entrega final, `InventarioService.procesar` delega el cálculo de reposición; `TipoProducto` encapsula clasificación y etiqueta sin switches. ArchUnit protege límites del paquete y `NotificadorBajoStock` rompe la dependencia circular entre inventario y reportes.
