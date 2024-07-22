package com.foxycorp.digifox.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "VCR_MAINTENANCE")
@Entity
public class VCRMaintenance {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VCR_MODEL", nullable = false)
    @NotNull
    private String vcr_model;

    @PositiveOrZero
    @Column(name = "CLEANED_ON_HRS", nullable = false)
    @NotNull
    private Integer cleaned_on_hrs;

    @Column(name = "DATE_")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public VCRModel getVcr_model() {
        return vcr_model == null ? null : VCRModel.fromId(vcr_model);
    }

    public void setVcr_model(VCRModel vcr_model) {
        this.vcr_model = vcr_model == null ? null : vcr_model.getId();
    }

    public Integer getCleaned_on_hrs() {
        return cleaned_on_hrs;
    }

    public void setCleaned_on_hrs(Integer cleaned_on_hrs) {
        this.cleaned_on_hrs = cleaned_on_hrs;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}