package university.jala.institutional.App;

abstract class Servicio {
    private String nombre;
    private double precio;

    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public abstract void mostrarDetalle();
}

class Mantenimiento extends Servicio {
    public Mantenimiento(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Servicio de Mantenimiento: " + getNombre() + " - Precio: " + getPrecio());
    }
}

class Reparacion extends Servicio {
    public Reparacion(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Servicio de Reparación: " + getNombre() + " - Precio: " + getPrecio());
    }
}
