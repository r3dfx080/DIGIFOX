package com.foxycorp.digifox.view.vcrmaintenance;

import com.foxycorp.digifox.app.StatsService;
import com.foxycorp.digifox.entity.VCRMaintenance;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Route(value = "vCRMaintenances/:id", layout = MainView.class)
@ViewController("VCRMaintenance.detail")
@ViewDescriptor("vcr-maintenance-detail-view.xml")
@EditedEntityContainer("vCRMaintenanceDc")
public class VCRMaintenanceDetailView extends StandardDetailView<VCRMaintenance> {
    @Autowired
    private StatsService statsService;

    @Subscribe
    public void onInitEntity(final InitEntityEvent<VCRMaintenance> event) {
        event.getEntity().setDate(LocalDate.now());
        event.getEntity().setCleaned_on_hrs(statsService.getStats().getTotal_mins()/60);
    }
}