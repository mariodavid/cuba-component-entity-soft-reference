package de.diedavids.cuba.entitysoftreference;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;

import java.util.Collection;


public interface SoftReferenceService {
    String NAME = "ddcesf_SoftReferenceService";

    boolean doSoftReferencesExist(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute);

    Collection<Entity> loadEntitiesForSoftReference(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute);
    Collection<Entity> loadEntitiesForSoftReference(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute, String view);

    int countEntitiesForSoftReference(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute);
}