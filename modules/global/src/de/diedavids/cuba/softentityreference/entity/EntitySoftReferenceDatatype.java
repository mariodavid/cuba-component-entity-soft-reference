package de.diedavids.cuba.softentityreference.entity;

import com.google.common.base.Strings;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EntityLoadInfo;
import com.haulmont.cuba.core.global.EntityLoadInfoBuilder;
import de.diedavids.cuba.softentityreference.EntitySoftReference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;

public class EntitySoftReferenceDatatype implements Datatype<EntitySoftReference> {

    @Override
    public Class getJavaClass() {
        return EntitySoftReference.class;
    }

    @Nonnull
    @Override
    public String format(@Nullable Object value) {

        if (value == null)
            return "";

        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();

        EntityLoadInfo entityLoadInfo = builder.create((Entity) value);


        return entityLoadInfo.toString();

    }

    private EntityLoadInfoBuilder getEntityLoadInfoBuilder() {
        return AppBeans.get(EntityLoadInfoBuilder.NAME);
    }

    @Nonnull
    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public EntitySoftReference parse(@Nullable String value) throws ParseException {


        if (Strings.isNullOrEmpty(value))
            return null;


        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.parse(value);

        EntitySoftReference entitySoftReference = new EntitySoftReference();
        entitySoftReference.setMetaClass(entityLoadInfo.getMetaClass());
        entitySoftReference.setId(entityLoadInfo.getId());

        return entitySoftReference;
    }

    @Nullable
    @Override
    public EntitySoftReference parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }

}
