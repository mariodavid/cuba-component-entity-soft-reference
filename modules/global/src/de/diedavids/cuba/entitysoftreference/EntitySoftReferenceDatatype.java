package de.diedavids.cuba.entitysoftreference;

import com.google.common.base.Strings;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;

public class EntitySoftReferenceDatatype implements Datatype<Entity> {

    @Override
    public Class getJavaClass() {
        return Entity.class;
    }

    @Nonnull
    @Override
    public String format(@Nullable Object value) {

        if (value == null) {
            return "";
        }

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
    public Entity parse(@Nullable String value) throws ParseException {


        if (Strings.isNullOrEmpty(value))
            return null;


        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.parse(value);

        Entity entity = loadEntity(entityLoadInfo);

        return entity;
    }

    private Entity loadEntity(EntityLoadInfo entityLoadInfo) {
        DataManager dataManager = getDataManager();
        return dataManager.load(getLoadContextForForEntityLoadInfo(entityLoadInfo.getMetaClass(), entityLoadInfo.getId()));
    }

    private DataManager getDataManager() {
        return AppBeans.get(DataManager.NAME);
    }


    protected LoadContext getLoadContextForForEntityLoadInfo(MetaClass metaClass, Object entityId) {
        LoadContext loadContext = LoadContext.create(metaClass.getJavaClass());
        loadContext
                .setId(entityId);
        return loadContext;
    }

    @Nullable
    @Override
    public Entity parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }

}
