package de.diedavids.cuba.entitysoftreference.web;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LinkButton;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.FrameOwner;
import com.haulmont.cuba.gui.screen.Screen;

/**
 * Helper class that generates an entity soft reference as a generated table column
 *
 * Usage:
 *
 * Within a controller a table can add a generated column with a new instance of a
 * EntitySoftReferenceTableColumnGenerator.
 *
 * @Subscribe
 * protected void onInit(InitEvent event) {
 *  myTable.addGeneratedColumn("myEntitySoftReferenceColumnName",
 *      new SoftReferenceInstanceNameTableColumnGenerator(
 *      "myEntitySoftReferenceColumnName",
 *      uiComponents,
 *      metadataTools,
 *      screenBuilders,
 *      this
 *  ));
 * }
 */
public class SoftReferenceInstanceNameTableColumnGenerator implements Table.ColumnGenerator {

    private final String property;

    private final UiComponents uiComponents;
    private final MetadataTools metadataTools;
    private final ScreenBuilders screenBuilders;
    private final FrameOwner frameOwner;

    /**
     * Creates a new SoftReferenceInstanceNameTableColumnGenerator
     * @param property the entity soft reference property name
     * @param uiComponents instance of CUBAs UiComponents bean
     * @param metadataTools instance of CUBAs metadataTools bean
     * @param screenBuilders instance of CUBAs screenBuilders bean
     * @param frameOwner the frame owner that renders the frame
     */
    public SoftReferenceInstanceNameTableColumnGenerator(String property, UiComponents uiComponents, MetadataTools metadataTools, ScreenBuilders screenBuilders, FrameOwner frameOwner) {
        this.property = property;
        this.uiComponents = uiComponents;
        this.metadataTools = metadataTools;
        this.screenBuilders = screenBuilders;
        this.frameOwner = frameOwner;
    }


    @Override
    public Component generateCell(Entity entity) {

        Entity softReference = getSoftReference(entity);
        return softReferenceLinkButton(softReference);
    }

    private LinkButton softReferenceLinkButton(Entity entitySoftReference) {

        if (entitySoftReference == null) {
            return null;
        }

        LinkButton linkButton = uiComponents.create(LinkButton.class);

        linkButton.setCaption(metadataTools.getInstanceName(entitySoftReference));

        linkButton.addClickListener(clickEvent -> {
            softReferenceEditor(entitySoftReference).show();
        });
        return linkButton;
    }

    private Entity getSoftReference(Entity entity) {
        return (Entity) entity.getValue(property);
    }

    private Screen softReferenceEditor(Entity softReference) {
        return screenBuilders.editor((Class<Entity>) softReference.getClass(), frameOwner)
                .editEntity(softReference)
                .build();
    }
}