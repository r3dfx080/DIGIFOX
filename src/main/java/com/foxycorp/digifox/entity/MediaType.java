package com.foxycorp.digifox.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum MediaType implements EnumClass<String> {

    VHS("A"),
    VHS_C("B"),
    VIDEO8("D"),
    HI8("C"),
    DIGITAL8("E"),
    DVD("G"),
    CD("F"),
    MINIDV("I"),
    COMPACT_CASSETTE("H");

    private final String id;

    MediaType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MediaType fromId(String id) {
        for (MediaType at : MediaType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}