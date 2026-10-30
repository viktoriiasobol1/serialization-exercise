package com.epam.rd.autotask.io.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class OrderSerializer {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {

    }

    public static void serializeOrder(Order order, OutputStream sink)
            throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(sink);
        oos.writeObject(order);
        oos.flush();
    }

    public static Order deserializeOrder(InputStream sink)
            throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(sink);
        return (Order) ois.readObject();
    }
}