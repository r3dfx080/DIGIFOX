package com.foxycorp.digifox.view.media;

import com.foxycorp.digifox.entity.Media;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "medias", layout = MainView.class)
@ViewController("Media.list")
@ViewDescriptor("media-list-view.xml")
@LookupComponent("mediasDataGrid")
@DialogMode(width = "64em")
public class MediaListView extends StandardListView<Media> {
}