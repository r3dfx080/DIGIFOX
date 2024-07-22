package com.foxycorp.digifox.view.expense;

import com.foxycorp.digifox.entity.Expense;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "expenses/:id", layout = MainView.class)
@ViewController("Expense.detail")
@ViewDescriptor("expense-detail-view.xml")
@EditedEntityContainer("expenseDc")
public class ExpenseDetailView extends StandardDetailView<Expense> {
}