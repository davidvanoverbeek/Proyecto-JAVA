public class Producto {

    private String articulo;
    private String tamaño;
    private Double precio;

    public Producto(String articulo, String tamaño, Double precio) {
        this.articulo = articulo;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public String getArticulo() {
        return articulo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto {" +
                "articulo: " + articulo + '\'' +
                ", tamaño: " + tamaño + '\'' +
                ", precio: " + precio +
                '}';
    }
}
