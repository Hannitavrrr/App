package university.jala.institutional.App;

import java.util.Date;

class Comprar {
    private Date fecha;
    private String nombreCliente;
    private String telefono;
    private String modelo;
    private String observaciones;
    private Object item; // Puede ser Producto o Servicio

    public Comprar(Date fecha, String nombreCliente, String telefono, String modelo, String observaciones, Object item) {
        if (fecha == null) {
            this.fecha = new Date();
        } else {
            this.fecha = fecha;
        }
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.modelo = modelo;
        this.observaciones = observaciones;
        this.item = item;
    }

    public Date getFecha() {
        return fecha;
    }

    public void mostrarDetalle() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + nombreCliente + " - Teléfono: " + telefono);
        System.out.println("Modelo: " + modelo);
        System.out.println("Observaciones: " + observaciones);
        if (item instanceof Producto) {
            ((Producto) item).mostrarDetalle();
        } else if (item instanceof Servicio) {
            ((Servicio) item).mostrarDetalle();
        }
    }
}
