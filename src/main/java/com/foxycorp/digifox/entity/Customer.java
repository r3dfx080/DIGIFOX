package com.foxycorp.digifox.entity;

import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.datatype.DatatypeFormatter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CUSTOMER")
@Entity
public class Customer {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @PastOrPresent
    @Column(name = "FIRST_ORDER_DATE")
    private LocalDate firstOrderDate;

    @Column(name = "PROFILE_LINK")
    private URI profileLink;

    @Column(name = "COMMENT_")
    private String comment;

    @PositiveOrZero
    @Column(name = "TOTAL_PAID")
    private Integer totalPaid;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public void setFirstOrderDate(LocalDate firstOrderDate) {
        this.firstOrderDate = firstOrderDate;
    }

    public LocalDate getFirstOrderDate() {
        return firstOrderDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Integer totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public URI getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(URI profileLink) {
        this.profileLink = profileLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"name", "firstOrderDate"})
    public String getInstanceName(MetadataTools metadataTools, DatatypeFormatter datatypeFormatter) {
        return String.format("%s %s",
                metadataTools.format(name),
                datatypeFormatter.formatLocalDate(firstOrderDate));
    }
}