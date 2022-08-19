package co.com.mantenimiento.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class WhatsApp implements ValueObject<String> {
    private final String value;


    public WhatsApp(String value) {
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
