package com.foxycorp.digifox.view.customer;

import com.foxycorp.digifox.entity.Customer;
import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route(value = "customers", layout = MainView.class)
@ViewController("Customer.list")
@ViewDescriptor("customer-list-view.xml")
@LookupComponent("customersDataGrid")
@DialogMode(width = "64em")
public class CustomerListView extends StandardListView<Customer> {
    @ViewComponent
    private DataGrid<Customer> customersDataGrid;
    @Autowired
    private UiComponents uiComponents;

    @Subscribe
    public void onInit(final InitEvent event) {
        customersDataGrid.addComponentColumn(customer -> {
            Paragraph paragraph = uiComponents.create(Paragraph.class);
            int paid = 0;
            List<Order> orders = customer.getOrders();
            for (Order order: orders)
                paid += order.getPaid();
            paragraph.setText(String.valueOf(paid));
            return paragraph;
        }).setHeader("Total paid");
        customersDataGrid.addComponentColumn(customer -> {
            Paragraph paragraph = uiComponents.create(Paragraph.class);
            int mins = 0;
            List<Order> orders = customer.getOrders();
            for (Order order: orders)
                mins += order.getDuration();
            paragraph.setText(String.valueOf(mins));
            return paragraph;
        }).setHeader("Total minutes");
        customersDataGrid.addComponentColumn(customer -> {
            Anchor anchor = uiComponents.create(Anchor.class);
            String link = customer.getProfileLink().toString();
            if (link == null) anchor.setVisible(false);
            else {
                if (link.startsWith("http")) {
                    anchor.setText("Profile link");
                    anchor.setHref(link);
                }
                else anchor.setText(link);
            }
            return anchor;
        }).setHeader("Link");
    }
}