package co.com.mantenimiento.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class DatosPersonales implements ValueObject<String> {
    private final String nombre;
    private final String apellido;

    public DatosPersonales(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String value() {
        return null;
    }
}
