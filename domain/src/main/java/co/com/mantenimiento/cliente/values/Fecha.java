package co.com.mantenimiento.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Fecha implements ValueObject<LocalDateTime> {

    private final LocalDateTime value;

    public Fecha(LocalDateTime value) {
        this.value = Objects.requireNonNull(value);
    }

    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public LocalDateTime value() {
        return value;
    }
}
