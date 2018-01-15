package de.diedavids.cuba.softentityreference;


import com.haulmont.cuba.core.entity.Entity;

public interface EntitySoftReferenceService {
    String NAME = "ddcsef_SoftEntityReferenceService";

    Entity getEntity(SoftReference softReference);


}