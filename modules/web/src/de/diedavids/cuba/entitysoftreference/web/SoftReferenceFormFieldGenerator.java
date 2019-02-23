package de.diedavids.cuba.entitysoftreference.web;

import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.ComponentGenerationContext;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.UiComponentsGenerator;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.InstanceContainer;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Helper class that generates a entity soft reference into a form component
 *
 * Usage:
 *
 * Inside a Editor the EntitySoftReferenceFormFieldGenerator bean can be injected. In the initialization
 * phase of the editor, the bean can be used to add the soft reference form field into the form
 *
 *   @Inject
 *   private EntitySoftReferenceFormFieldGenerator entitySoftReferenceFormFieldGenerator;
 *
 *   @Subscribe
 *   protected void onInit(InitEvent event) {
 *
 *     entitySoftReferenceFormFieldGenerator.initSoftReferenceFormField(form, "mySoftReferenceFieldName", instanceContainer);
 *
 *   }
 *
 */
@Component(SoftReferenceFormFieldGenerator.NAME)
public class SoftReferenceFormFieldGenerator {

    public static final String NAME = "ddcser_SoftReferenceFormFieldGenerator";

    @Inject
    protected UiComponentsGenerator uiComponentsGenerator;

    @Inject
    protected Messages messages;


    /**
     * initialized the soft reference as a form field
     * @param form the destination form component instance
     * @param container the instance container
     * @param property the soft reference property
     */
    public void initSoftReferenceFormField(Form form, InstanceContainer container, String property) {

        Field field = generateSoftReferenceField(property, container);

        setCaption(property, container, field);
        setValueSource(property, container, field);

        form.add(field);
    }

    private void setValueSource(String property, InstanceContainer container, Field field) {
        field.setValueSource(new ContainerValueSource<>(container, property));
    }

    private void setCaption(String property, InstanceContainer container, Field field) {
        String propertyCaption = messages.getTools().getPropertyCaption(container.getEntityMetaClass(), property);
        field.setCaption(propertyCaption);
    }

    private Field generateSoftReferenceField(String property, InstanceContainer container) {
        return (Field) uiComponentsGenerator.generate(new ComponentGenerationContext(container.getEntityMetaClass(), property));
    }
}