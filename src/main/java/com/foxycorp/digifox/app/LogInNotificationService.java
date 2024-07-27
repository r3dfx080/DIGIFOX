package com.foxycorp.digifox.app;

import com.foxycorp.digifox.entity.Order;
import io.jmix.core.DataManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogInNotificationService {
    private final DataManager dataManager;

    public LogInNotificationService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public int getActiveOrdersCount(){
        int orders_count = 0;

        List<Order> orders = dataManager.load(Order.class).all().list();
        for (Order order: orders) {
            if (order.getDateOut()== null) orders_count++;
        }
        return orders_count;
    }
}