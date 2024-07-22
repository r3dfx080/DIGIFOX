package com.foxycorp.digifox.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.JmixId;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

@JmixEntity
public class Stats {
    @JmixGeneratedValue
    @JmixId
    private UUID id;

    @PositiveOrZero
    private Integer total_mins;

    @PositiveOrZero
    private Integer vcr_mins_past_cleaning;

    @PositiveOrZero
    private Integer expenses;

    @PositiveOrZero
    private Integer net_profit;

    @PositiveOrZero
    private Integer vhs_count;

    @PositiveOrZero
    private Integer vhs_c_count;

    @PositiveOrZero
    private Integer video8_count;

    @PositiveOrZero
    private Integer hi8_count;

    @PositiveOrZero
    private Integer digital8_count;

    @PositiveOrZero
    private Integer minidv_count;

    @PositiveOrZero
    private Integer cd_dvd_count;

    public Integer getNet_profit() {
        return net_profit;
    }

    public void setNet_profit(Integer net_profit) {
        this.net_profit = net_profit;
    }

    public void setExpenses(Integer expenses) {
        this.expenses = expenses;
    }

    public Integer getExpenses() {
        return expenses;
    }

    public void setMinidv_count(Integer minidv_count) {
        this.minidv_count = minidv_count;
    }

    public Integer getMinidv_count() {
        return minidv_count;
    }

    public void setDigital8_count(Integer digital8_count) {
        this.digital8_count = digital8_count;
    }

    public Integer getDigital8_count() {
        return digital8_count;
    }

    public void setHi8_count(Integer hi8_count) {
        this.hi8_count = hi8_count;
    }

    public Integer getHi8_count() {
        return hi8_count;
    }

    public void setVideo8_count(Integer video8_count) {
        this.video8_count = video8_count;
    }

    public Integer getVideo8_count() {
        return video8_count;
    }

    public void setVhs_c_count(Integer vhs_c_count) {
        this.vhs_c_count = vhs_c_count;
    }

    public Integer getVhs_c_count() {
        return vhs_c_count;
    }

    public void setVhs_count(Integer vhs_count) {
        this.vhs_count = vhs_count;
    }

    public Integer getVhs_count() {
        return vhs_count;
    }

    public void setCd_dvd_count(Integer cd_dvd_count) {
        this.cd_dvd_count = cd_dvd_count;
    }

    public Integer getCd_dvd_count() {
        return cd_dvd_count;
    }

    public Integer getVcr_mins_past_cleaning() {
        return vcr_mins_past_cleaning;
    }

    public void setVcr_mins_past_cleaning(Integer vcr_mins_past_cleaning) {
        this.vcr_mins_past_cleaning = vcr_mins_past_cleaning;
    }

    public Integer getTotal_mins() {
        return total_mins;
    }

    public void setTotal_mins(Integer total_mins) {
        this.total_mins = total_mins;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void makeBlankStats(){
        setExpenses(0);
        setNet_profit(0);
        setTotal_mins(0);
        setId(UUID.randomUUID());
        setVhs_count(0);
        setVhs_c_count(0);
        setVideo8_count(0);
        setHi8_count(0);
        setDigital8_count(0);
        setMinidv_count(0);
        setCd_dvd_count(0);
    }
}