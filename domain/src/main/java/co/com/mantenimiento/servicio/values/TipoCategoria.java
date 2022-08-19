package co.com.mantenimiento.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCategoria implements ValueObject<String>{
    private final String value;

    public TipoCategoria(String value){ this.value = Objects.requireNonNull(value);}

    public String getValue() {return value;}

    @Override
    public String value() {return value;}
}
