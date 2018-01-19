package de.diedavids.cuba.entitysoftreference;

import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;

import java.util.Collection;


public interface SoftReferenceService {
    String NAME = "ddcesf_SoftReferenceService";

    boolean doSoftReferencesExist(MetaClass baseEntity, Entity softReference, String attribute);

    Collection<Entity> getEntitiesForSoftReference(MetaClass baseEntity, Entity softReference, String attribute);
}