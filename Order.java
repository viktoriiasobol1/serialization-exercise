package com.epam.rd.autotask.io.serialization;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Order implements Serializable {

    private Long id;

    private transient BigDecimal total;

    private Map<Item, Integer> items;

    public Order(Long id, Map<Item, Integer> items) {
        this.id = id;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public BigDecimal getTotal() {

        if (total == null) {

            if (items == null) {
                total = BigDecimal.ZERO;
            } else {

                total = items.entrySet()
                        .stream()
                        .map(e -> e.getKey()
                                .getPrice()
                                .multiply(BigDecimal.valueOf(e.getValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }
        }

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id)
                && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }
}