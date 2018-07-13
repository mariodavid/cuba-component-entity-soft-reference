package de.diedavids.cuba.entitysoftreference;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;

import java.util.Collection;


public interface SoftReferenceService {
    String NAME = "ddcesf_SoftReferenceService";

    boolean doSoftReferencesExist(Class<? extends Entity> polymorphicEntityClass, Entity softReference, String attribute);

    <T extends Entity> Collection<T> loadEntitiesForSoftReference(Class<T> polymorphicEntityClass, Entity softReference, String attribute);

    <T extends Entity> Collection<T> loadEntitiesForSoftReference(Class<T> polymorphicEntityClass, Entity softReference, String attribute, String view);

    int countEntitiesForSoftReference(Class<? extends Entity> polymorphicEntityClass, Entity softReference, String attribute);
}