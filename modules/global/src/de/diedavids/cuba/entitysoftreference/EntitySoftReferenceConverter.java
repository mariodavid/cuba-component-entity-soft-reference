package de.diedavids.cuba.entitysoftreference;

import com.google.common.base.Strings;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.*;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EntitySoftReferenceConverter implements AttributeConverter<Entity, String> {

    @Override
    public String convertToDatabaseColumn(Entity softReference) {

        if (softReference == null)
            return "";

        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();

        EntityLoadInfo entityLoadInfo = builder.create(softReference);


        return entityLoadInfo.toString();
    }

    @Override
    public Entity convertToEntityAttribute(String value) {


        if (Strings.isNullOrEmpty(value))
            return null;

        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.parse(value);

        Entity entity = null;

        if (entityLoadInfo != null) {
            entity = loadEntity(entityLoadInfo);
        }

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



    private EntityLoadInfoBuilder getEntityLoadInfoBuilder() {
        return AppBeans.get(EntityLoadInfoBuilder.NAME);
    }

}
