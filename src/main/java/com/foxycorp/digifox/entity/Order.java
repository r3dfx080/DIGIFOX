package com.foxycorp.digifox.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_", indexes = {
        @Index(name = "IDX_ORDER__CUSTOMER", columnList = "CUSTOMER_ID")
})
@Entity(name = "Order_")
public class Order {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @PastOrPresent
    @NotNull
    @Column(name = "DATE_IN", nullable = false)
    private LocalDate dateIn;

    @PastOrPresent
    @Column(name = "DATE_OUT")
    private LocalDate dateOut;

    @PositiveOrZero
    @Column(name = "DURATION")
    private Integer duration;

    @PositiveOrZero
    @Column(name = "PAID")
    private Integer paid;

    @Column(name = "CATALOG_", length = 1024)
    private FileRef catalog;

    @NotNull
    @OneToMany(mappedBy = "order")
    private List<Media> media;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public FileRef getCatalog() {
        return catalog;
    }

    public void setCatalog(FileRef catalog) {
        this.catalog = catalog;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}