package com.foxycorp.digifox.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ExpensesType implements EnumClass<String> {

    LISTING("A"),
    ADVERTISING("B"),
    OTHER("C");

    private final String id;

    ExpensesType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ExpensesType fromId(String id) {
        for (ExpensesType at : ExpensesType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}