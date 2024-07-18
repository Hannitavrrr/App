package university.jala.institutional.App;

abstract class Producto {
    private String nombre;
    private double precio;
    private String modelo;

    public Producto(String nombre, double precio, String modelo) {
        this.nombre = nombre;
        this.precio = precio;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getModelo() {
        return modelo;
    }

    public abstract void mostrarDetalle();
}

class ProductoFinal extends Producto {
    public ProductoFinal(String nombre, double precio, String modelo) {
        super(nombre, precio, modelo);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Producto Final: " + getNombre() + " - Modelo: " + getModelo() + " - Precio: " + getPrecio());
    }
}

class Accesorio extends Producto {
    public Accesorio(String nombre, double precio, String modelo) {
        super(nombre, precio, modelo);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Accesorio: " + getNombre() + " - Modelo: " + getModelo() + " - Precio: " + getPrecio());
    }
}
