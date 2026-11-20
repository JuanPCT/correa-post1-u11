Repositorio GitHub: https://github.com/JuanPCT/correa-post1-u11

# Unidad 11 — Refactorización de inventario

La primera versión conserva deliberadamente un método largo y dos switches duplicados para poder fijar la conducta con tests antes de refactorizar. El historial local separa baseline, caracterización, refactor y regla de paquetes.

```bash
mvn clean verify
```

En la entrega final, `InventarioService.procesar` delega el cálculo de reposición; `TipoProducto` encapsula clasificación y etiqueta sin switches. Los 12 tests se agregaron antes y permanecen intactos durante el cambio. ArchUnit detectó el ciclo `inventario → reportes → inventario`; la dependencia se invirtió con `NotificadorBajoStock`, definido por inventario e implementado por reportes. La prueba de ciclos y la regla de dirección vuelven a pasar después del arreglo. El ciclo se reprodujo localmente en un commit didáctico antes de repararse; el commit final debe pasar `mvn verify`.

## Decisiones de diseño

1. Extraje `CalculadoraReorden` porque el faltante es una política de inventario que puede evolucionar independientemente del formato de salida.
2. Elegí métodos polimórficos en `TipoProducto` porque el catálogo de tipos es cerrado y los consumidores ya reciben el enum. Una clase por tipo tendría sentido si los tipos requirieran servicios externos.
3. El contrato de bajo stock pertenece a inventario. Si reportes definiera el contrato, inventario seguiría importando el paquete que originó el ciclo.
4. ArchUnit comprueba tanto los ciclos entre paquetes como la dirección entre inventario y reportes. Esto localiza una infracción sin iniciar Spring.

El commit `dd61484` reproduce el ciclo. El commit `5608182` corrige la dirección y conserva las 12 pruebas de caracterización. [Ejecución de CI con las 15 pruebas](https://github.com/JuanPCT/correa-post1-u11/actions/runs/44752031211).
