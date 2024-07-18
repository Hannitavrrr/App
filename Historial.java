package university.jala.institutional.App;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Historial {
    private List<Comprar> compras;

    public Historial() {
        compras = new ArrayList<>();
    }

    public void agregarAdquisicion(Comprar adquisicion) {
        compras.add(adquisicion);
    }

    public void mostrarAdquisicionesDelDia() {
        Date hoy = new Date();
        System.out.println("Adquisiciones del día:");
        for (Comprar compras : compras) {
            if (esHoy(compras)) {
                compras.mostrarDetalle();
            }
        }
    }

    private boolean esHoy(Comprar compras) {
        Date fecha = compras.getFecha();
        if (fecha == null) {
            return false;
        }
        Date hoy = new Date();
        return fecha.getYear() == hoy.getYear() &&
                fecha.getMonth() == hoy.getMonth() &&
                fecha.getDate() == hoy.getDate();
    }
}
