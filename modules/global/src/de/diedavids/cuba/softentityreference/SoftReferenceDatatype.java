package de.diedavids.cuba.softentityreference;

import com.google.common.base.Strings;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.EntityLoadInfo;
import com.haulmont.cuba.core.global.EntityLoadInfoBuilder;
import de.diedavids.cuba.softentityreference.SoftReference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;

public class SoftReferenceDatatype implements Datatype<SoftReference> {

    @Override
    public Class getJavaClass() {
        return SoftReference.class;
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
    public SoftReference parse(@Nullable String value) throws ParseException {


        if (Strings.isNullOrEmpty(value))
            return null;


        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.parse(value);

        SoftReference softReference = new SoftReference();
        softReference.setMetaClass(entityLoadInfo.getMetaClass());
        softReference.setId(entityLoadInfo.getId());

        return softReference;
    }

    @Nullable
    @Override
    public SoftReference parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }

}
