package com.foxycorp.digifox.view.customer;

import com.foxycorp.digifox.entity.Customer;
import com.foxycorp.digifox.entity.Order;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.CollectionPropertyContainer;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.*;

import java.time.LocalDate;
import java.util.List;

@Route(value = "customers/:id", layout = MainView.class)
@ViewController("Customer.detail")
@ViewDescriptor("customer-detail-view.xml")
@EditedEntityContainer("customerDc")
public class CustomerDetailView extends StandardDetailView<Customer> {
    @ViewComponent
    private CollectionPropertyContainer<Order> ordersDc;
    @ViewComponent
    private TypedTextField<Integer> totalPaidField;
    @ViewComponent
    private InstanceContainer<Customer> customerDc;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Customer> event) {
        event.getEntity().setFirstOrderDate(LocalDate.now());
        event.getEntity().setTotalPaid(0);
    }

    @Subscribe(id = "loader", target = Target.DATA_LOADER)
    public void onLoaderPostLoad(final InstanceLoader.PostLoadEvent<Customer> event) {
        List<Order> orders = ordersDc.getItems();
        event.getLoadedEntity().setTotalPaid(orders.stream().map(Order::getPaid).reduce(0, Integer::sum));

    }

}