package co.com.mantenimiento.servicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Integer> {
    private final Integer value;

    public Precio(Integer value) {
        this.value = Objects.requireNonNull(value);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
