package com.foxycorp.digifox.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.MetadataTools;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.datatype.DatatypeFormatter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@JmixEntity
@Table(name = "MEDIA", indexes = {
        @Index(name = "IDX_MEDIA_ORDER", columnList = "ORDER_ID")
})
@Entity
public class Media {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "MEDIA_TYPE", nullable = false)
    @NotNull
    private String mediaType;

    @Positive
    @Column(name = "QUANTITY", nullable = false)
    @NotNull
    private Integer quantity;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "ORDER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MediaType getMediaType() {
        return mediaType == null ? null : MediaType.fromId(mediaType);
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType == null ? null : mediaType.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @InstanceName
    @DependsOnProperties({"mediaType", "quantity"})
    public String getInstanceName(MetadataTools metadataTools, DatatypeFormatter datatypeFormatter) {
        return String.format("%s %s",
                metadataTools.format(getMediaType()),
                datatypeFormatter.formatInteger(quantity));
    }
}