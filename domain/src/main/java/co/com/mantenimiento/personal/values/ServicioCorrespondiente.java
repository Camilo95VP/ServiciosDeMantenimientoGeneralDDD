package co.com.mantenimiento.personal.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ServicioCorrespondiente implements ValueObject<String> {
    private final String value;

    public ServicioCorrespondiente(String value) {
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
