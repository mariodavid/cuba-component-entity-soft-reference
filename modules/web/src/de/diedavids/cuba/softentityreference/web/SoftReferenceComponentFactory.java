package de.diedavids.cuba.softentityreference.web;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.chile.core.model.Range;
import com.haulmont.cuba.core.app.dynamicattributes.DynamicAttributesUtils;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.annotation.Order;

import javax.annotation.Nullable;
import javax.inject.Inject;


@org.springframework.stereotype.Component(SoftReferenceComponentFactory.NAME)
@Order(value = 60)
public class SoftReferenceComponentFactory extends AbstractComponentGenerationStrategy implements ComponentGenerationStrategy {

    public static final String NAME = "ddcser_SoftReferenceComponentFactory";

    @Inject
    public SoftReferenceComponentFactory(Messages messages) {
        super(messages);
    }

    @Inject
    public void setComponentsFactory(ComponentsFactory componentsFactory) {
        this.componentsFactory = componentsFactory;
    }


    @Nullable
    @Override
    public Component createComponent(ComponentGenerationContext context) {
        String property = context.getProperty();
        MetaPropertyPath mpp = resolveMetaPropertyPath(context.getMetaClass(), property);

        if (mpp != null) {
            Range mppRange = mpp.getRange();
            if (mppRange.isDatatype()) {
                Class type = mppRange.asDatatype().getJavaClass();
                if (type.equals(Entity.class)) {
                    return createDatatypeLinkField(context);
                }
            }
        }

        return null;
    }

    protected MetaPropertyPath resolveMetaPropertyPath(MetaClass metaClass, String property) {
        MetaPropertyPath mpp = metaClass.getPropertyPath(property);

        if (mpp == null && DynamicAttributesUtils.isDynamicAttribute(property)) {
            mpp = DynamicAttributesUtils.getMetaPropertyPath(metaClass, property);
        }

        return mpp;
    }

    protected void setDatasource(Field field, ComponentGenerationContext context) {
        if (context.getDatasource() != null && StringUtils.isNotEmpty(context.getProperty())) {
            field.setDatasource(context.getDatasource(), context.getProperty());
        }
    }
}
