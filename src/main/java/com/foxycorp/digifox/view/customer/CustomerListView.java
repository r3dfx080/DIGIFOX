package com.foxycorp.digifox.view.customer;

import com.foxycorp.digifox.entity.Customer;
import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.model.CollectionLoader;
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

    }

    @Subscribe(id = "customersDl", target = Target.DATA_LOADER)
    public void onCustomersDlPostLoad(final CollectionLoader.PostLoadEvent<Customer> event) {
        customersDataGrid.addComponentColumn(customer -> {
                    Paragraph paragraph = uiComponents.create(Paragraph.class);
                    paragraph.setText(String.valueOf(customer.getOrders().stream().mapToInt(Order::getPaid).sum()));
                    return paragraph;
                })
                .setHeader("Total paid")
                .setKey("paid")
                .setResizable(true);

        customersDataGrid.addComponentColumn(customer -> {
                    Paragraph paragraph = uiComponents.create(Paragraph.class);
                    paragraph.setText(String.valueOf(customer.getOrders().stream().mapToInt(Order::getDuration).sum()));
                    return paragraph;
                })
                .setHeader("Total minutes")
                .setKey("minutes")
                .setResizable(true);
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
                })
                .setHeader("Link")
                .setKey("link")
                .setResizable(true);

        customersDataGrid.setColumnPosition(customersDataGrid.getColumnByKey("link"),2);
        customersDataGrid.setColumnPosition(customersDataGrid.getColumnByKey("paid"),3);
        customersDataGrid.setColumnPosition(customersDataGrid.getColumnByKey("minutes"),4);
    }
}