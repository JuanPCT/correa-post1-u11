package co.edu.ufps.inventario.domain;
public enum TipoProducto {
    FRESCO {
        public String clasificacion(){return "perecedero";}
        public String etiqueta(){return "Conservar refrigerado";}
    },
    ELECTRONICO {
        public String clasificacion(){return "tecnologia";}
        public String etiqueta(){return "Manejar con cuidado";}
    },
    ROPA {
        public String clasificacion(){return "textil";}
        public String etiqueta(){return "Almacenar seco";}
    };
    public abstract String clasificacion();
    public abstract String etiqueta();
}
