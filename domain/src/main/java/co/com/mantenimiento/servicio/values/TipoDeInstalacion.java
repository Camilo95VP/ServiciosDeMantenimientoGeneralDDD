package co.com.mantenimiento.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeInstalacion implements ValueObject<String> {
    private final String value;

    public TipoDeInstalacion(String value){ this.value = Objects.requireNonNull(value);}

    public String getValue() {return value;}

    @Override
    public String value() {return value;}
}
