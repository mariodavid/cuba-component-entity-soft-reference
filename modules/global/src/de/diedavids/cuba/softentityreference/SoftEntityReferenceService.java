package de.diedavids.cuba.softentityreference;


import com.haulmont.cuba.core.entity.Entity;

public interface SoftEntityReferenceService {
    String NAME = "ddcsef_SoftEntityReferenceService";

    Entity getEntity(EntitySoftReference entitySoftReference);


}