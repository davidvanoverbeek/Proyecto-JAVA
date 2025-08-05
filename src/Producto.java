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

    public Double getPrecio() {
        return precio;
    }
}
