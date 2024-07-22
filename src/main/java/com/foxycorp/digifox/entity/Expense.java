package com.foxycorp.digifox.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "EXPENSES")
@Entity
public class Expense {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "EXPENSE", nullable = false)
    @NotNull
    private String expense_type;

    @Positive
    @Column(name = "PAID", nullable = false)
    @NotNull
    private Integer paid;

    @Column(name = "DATE_")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public ExpensesType getExpense_type() {
        return expense_type == null ? null : ExpensesType.fromId(expense_type);
    }

    public void setExpense_type(ExpensesType expense_type) {
        this.expense_type = expense_type == null ? null : expense_type.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}