package com.foxycorp.digifox.view.order;

import com.foxycorp.digifox.entity.Media;
import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.UiComponentsGenerator;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.component.grid.DataGridColumn;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.net.URI;
import java.util.List;


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
    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onInit(final InitEvent event) {

    }

    @Subscribe(id = "ordersDl", target = Target.DATA_LOADER)
    public void onOrdersDlPostLoad(final CollectionLoader.PostLoadEvent<Order> event) {
        ordersDataGrid.addComponentColumn(order ->{
            Paragraph paragraph = new Paragraph("");
            if (order.getMedia() != null){
                List<Media> medias = order.getMedia();
                for (Media media: medias)
                    paragraph.add(media.getQuantity() + " " + media.getMediaType().name() + "\n");
            }
            return paragraph;
        })
                .setKey("medias")
                .setHeader("Medias")
                .setResizable(true);
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
        })
                .setKey("links")
                .setHeader("Link")
                .setResizable(true);
        ordersDataGrid.addComponentColumn(order -> {
            Span badge;
            if (order.getDateOut() != null){
                Icon icon = VaadinIcon.CHECK.create();
                icon.getStyle()
                        .set("padding", "var(--lumo-space-xs")
                        .set("box-sizing", "border-box");
                badge = new Span(icon, new Span("Done"));
                badge.getElement().getThemeList().add("badge success");
            }
            else {
                Icon icon = VaadinIcon.CLOCK.create();
                icon.getStyle()
                        .set("padding", "var(--lumo-space-xs")
                        .set("box-sizing", "border-box");
                badge = new Span(icon, new Span("Pending"));
                badge.getElement().getThemeList().add("badge");
            }
            return badge;
        })
                .setKey("badge")
                .setResizable(true)
                .setWidth("6%");
        ordersDataGrid.setColumnPosition(ordersDataGrid.getColumnByKey("links"),1);
    }
}