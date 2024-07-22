package com.foxycorp.digifox.view.vcrmaintenance;

import com.foxycorp.digifox.entity.VCRMaintenance;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "vCRMaintenances", layout = MainView.class)
@ViewController("VCRMaintenance.list")
@ViewDescriptor("vcr-maintenance-list-view.xml")
@LookupComponent("vCRMaintenancesDataGrid")
@DialogMode(width = "64em")
public class VCRMaintenanceListView extends StandardListView<VCRMaintenance> {
}