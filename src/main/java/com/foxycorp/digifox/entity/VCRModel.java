package com.foxycorp.digifox.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum VCRModel implements EnumClass<String> {

    NV_HD750("A"),
    NV_SD400("B"),
    SR_55("C");

    private final String id;

    VCRModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static VCRModel fromId(String id) {
        for (VCRModel at : VCRModel.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}