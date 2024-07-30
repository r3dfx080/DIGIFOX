package com.foxycorp.digifox.view.order;

import com.foxycorp.digifox.entity.Customer;
import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Route(value = "orders/:id", layout = MainView.class)
@ViewController("Order_.detail")
@ViewDescriptor("order-detail-view.xml")
@EditedEntityContainer("orderDc")
public class OrderDetailView extends StandardDetailView<Order> {
    @ViewComponent
    private TypedTextField<Integer> paidField;
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private TypedTextField<Object> customerField;
    @ViewComponent
    private InstanceContainer<Order> orderDc;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Order> event) {
        event.getEntity().setPaid(0);
        event.getEntity().setDuration(0);
        event.getEntity().setDateIn(LocalDate.now());
    }

    @Subscribe(id = "orderDl", target = Target.DATA_LOADER)
    public void onOrderDlPostLoad(final InstanceLoader.PostLoadEvent<Order> event) {
        if (event.getLoadedEntity().getCustomer() != null) customerField.setValue(event.getLoadedEntity().getCustomer().getName());
        else customerField.setValue("");
    }


}