package com.foxycorp.digifox.view.vcrmaintenance;

import com.foxycorp.digifox.entity.VCRMaintenance;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "vCRMaintenances/:id", layout = MainView.class)
@ViewController("VCRMaintenance.detail")
@ViewDescriptor("vcr-maintenance-detail-view.xml")
@EditedEntityContainer("vCRMaintenanceDc")
public class VCRMaintenanceDetailView extends StandardDetailView<VCRMaintenance> {
}