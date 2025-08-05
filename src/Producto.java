public class Producto {

    // Producto

    private String articulo;
    private String tamaño;
    private Double precio;
    private int stock;

    // Constructor

    public Producto(String articulo, String tamaño, double precio, int stock) {
        this.articulo = articulo;
        this.tamaño = tamaño;
        this.precio = precio;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    // Función

    public void setStock(int stock) {
        this.stock = stock;
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
