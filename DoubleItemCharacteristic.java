package com.epam.rd.autotask.io.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class DoubleItemCharacteristic extends ItemCharacteristic implements Serializable {

    private static final long serialVersionUID = 1L;

    protected double value;

    public DoubleItemCharacteristic(Long id, String name, String type, double value) {
        super(id, name, type);
        this.value = value;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

        out.writeLong(id);
        out.writeUTF(name);
        out.writeUTF(type);
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {

        in.defaultReadObject();

        this.id = in.readLong();
        this.name = in.readUTF();
        this.type = in.readUTF();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleItemCharacteristic)) return false;
        if (!super.equals(o)) return false;

        DoubleItemCharacteristic that = (DoubleItemCharacteristic) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}