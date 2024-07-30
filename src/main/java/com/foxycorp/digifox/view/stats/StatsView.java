package com.foxycorp.digifox.view.stats;


import com.foxycorp.digifox.app.StatsService;
import com.foxycorp.digifox.entity.Stats;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

@Route(value = "stats-view", layout = MainView.class)
@ViewController("StatsView")
@ViewDescriptor("stats-view.xml")
public class StatsView extends StandardView {
    @Autowired
    private StatsService statsService;
    @ViewComponent
    private TypedTextField<Object> totalHrs;
    @ViewComponent
    private TypedTextField<Object> hrs_past_cleaning;
    @ViewComponent
    private TypedTextField<Object> vhs_count;
    @ViewComponent
    private TypedTextField<Object> vhs_c_count;
    @ViewComponent
    private TypedTextField<Object> video8_count;
    @ViewComponent
    private TypedTextField<Object> hi8_count;
    @ViewComponent
    private TypedTextField<Object> digital8_count;
    @ViewComponent
    private TypedTextField<Object> minidv_count;
    @ViewComponent
    private TypedTextField<Object> cd_dvd_count;
    @ViewComponent
    private TypedTextField<Object> net_profit;
    @ViewComponent
    private TypedTextField<Object> expenses;
    @Subscribe
    public void onInit(final InitEvent event) {
        //statistics
        DecimalFormat df = new DecimalFormat("####");
        df.setRoundingMode(RoundingMode.UP);
        Stats stats = statsService.getStats();
        net_profit.setValue("NET PROFIT: " + stats.getNet_profit().toString());
        expenses.setValue("EXPENSES: " + stats.getExpenses().toString());
        totalHrs.setValue("TOTAL HOURS: " + df.format(stats.getTotal_mins()/60));
        hrs_past_cleaning.setValue("HOURS PAST HEADS CLEANING: " + df.format(stats.getVcr_mins_past_cleaning()/60));
        vhs_count.setValue("VHS: " + stats.getVhs_count().toString());
        vhs_c_count.setValue("VHS-C: " + stats.getVhs_c_count().toString());
        video8_count.setValue("VIDEO8: " + stats.getVideo8_count().toString());
        hi8_count.setValue("HI8: " + stats.getHi8_count().toString());
        digital8_count.setValue("DIGITAL8: " + stats.getDigital8_count().toString());
        minidv_count.setValue("MINIDV: " + stats.getMinidv_count().toString());
        cd_dvd_count.setValue("CD/DVD: " + stats.getCd_dvd_count().toString());

    }


}