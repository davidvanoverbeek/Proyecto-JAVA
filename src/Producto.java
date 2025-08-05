public class Producto {

    // Producto

    private String articulo;
    private String tamaño;
    private Double precio;

    // Constructor

    public Producto(String articulo, String tamaño, Double precio) {
        this.articulo = articulo;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    // Getters

    public String getArticulo() {
        return articulo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public Double getPrecio() {
        return precio;
    }

    // Sobrescritura

    @Override
    public String toString() {
        return "Producto {" +
                "articulo: " + articulo + '\'' +
                ", tamaño: " + tamaño + '\'' +
                ", precio: " + precio +
                '}';
    }
}
