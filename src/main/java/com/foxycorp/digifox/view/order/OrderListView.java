package com.foxycorp.digifox.view.order;

import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.UiComponentsGenerator;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.net.URI;


@Route(value = "orders", layout = MainView.class)
@ViewController("Order_.list")
@ViewDescriptor("order-list-view.xml")
@LookupComponent("ordersDataGrid")
@DialogMode(width = "64em")
public class OrderListView extends StandardListView<Order> {
    @ViewComponent
    private DataGrid<Order> ordersDataGrid;
    @Autowired
    private UiComponents uiComponents;

    @Subscribe
    public void onInit(final InitEvent event) {
        ordersDataGrid.addComponentColumn(order -> {
            Anchor anchor = uiComponents.create(Anchor.class);
            if (order.getCustomer() != null){
                String link = order.getCustomer().getProfileLink().toString();
                if (link == null) anchor.setVisible(false);
                else {
                    if (link.startsWith("http")) {
                        anchor.setText("Profile link");
                        anchor.setHref(link);
                    }
                    else anchor.setText(link);
                }
            }
            else anchor.setVisible(false);
            return anchor;
        }).setKey("links").setHeader("Link");
    }
}