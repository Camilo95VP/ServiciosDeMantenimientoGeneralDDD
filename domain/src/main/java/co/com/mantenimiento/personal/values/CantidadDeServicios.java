package co.com.mantenimiento.personal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CantidadDeServicios implements ValueObject<Integer> {
    private final Integer value;

    public CantidadDeServicios(Integer value) {
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
