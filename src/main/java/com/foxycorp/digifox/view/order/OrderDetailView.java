package com.foxycorp.digifox.view.order;

import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.view.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.time.LocalDate;

@Route(value = "orders/:id", layout = MainView.class)
@ViewController("Order_.detail")
@ViewDescriptor("order-detail-view.xml")
@EditedEntityContainer("orderDc")
public class OrderDetailView extends StandardDetailView<Order> {
    @ViewComponent
    private TypedTextField<Integer> paidField;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Order> event) {
        event.getEntity().setPaid(0);
        event.getEntity().setDuration(0);
        event.getEntity().setDateIn(LocalDate.now());
    }

}