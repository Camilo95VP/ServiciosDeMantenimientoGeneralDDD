package co.com.mantenimiento.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Motivo implements ValueObject<String> {
    private final String value;

    public Motivo(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String value() {
        return value;
    }
}
