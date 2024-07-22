package com.foxycorp.digifox.app;

import com.foxycorp.digifox.entity.*;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StatsService {
    @Autowired
    private final DataManager dataManager;

    public StatsService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Stats getStats(){
        List<Expense> expenses = dataManager.load(Expense.class).all().list();

        List<Media> medias = dataManager.load(Media.class).all().list();

        List<Order> orders = dataManager.load(Order.class).all().list();

        List<VCRMaintenance> maintenances = dataManager.load(VCRMaintenance.class).all().list();

        Stats stats = dataManager.create(Stats.class);

        stats.makeBlankStats();

        stats.setExpenses(expenses.stream().map(Expense::getPaid).reduce(0, Integer::sum));

        stats.setNet_profit(orders.stream().map(Order::getPaid).reduce(0, Integer::sum) - stats.getExpenses());

        stats.setTotal_mins(orders.stream().map(Order::getDuration).reduce(0, Integer::sum));

        stats.setVcr_mins_past_cleaning(stats.getTotal_mins() - maintenances.getLast().getCleaned_on_hrs());

        medias.forEach(
                media -> { MediaType type = media.getMediaType();
                    int quantity = media.getQuantity();
                switch (type){
                    case VHS -> stats.setVhs_count(stats.getVhs_count() + quantity);
                    case VHS_C -> stats.setVhs_c_count(stats.getVhs_c_count() + quantity);
                    case MINIDV -> stats.setMinidv_count(stats.getMinidv_count() + quantity);
                    case VIDEO8 -> stats.setVideo8_count(stats.getVideo8_count() + quantity);
                    case HI8 -> stats.setHi8_count(stats.getHi8_count() + quantity);
                    case DIGITAL8 -> stats.setDigital8_count(stats.getDigital8_count() + quantity);
                    case CD, DVD -> stats.setCd_dvd_count(stats.getCd_dvd_count() + quantity);
                }}
        );
        return stats;
    }
}