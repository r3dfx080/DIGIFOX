package com.foxycorp.digifox.view.media;

import com.foxycorp.digifox.entity.Media;
import com.foxycorp.digifox.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "medias/:id", layout = MainView.class)
@ViewController("Media.detail")
@ViewDescriptor("media-detail-view.xml")
@EditedEntityContainer("mediaDc")
public class MediaDetailView extends StandardDetailView<Media> {
}