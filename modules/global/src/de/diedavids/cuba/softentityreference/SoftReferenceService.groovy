package de.diedavids.cuba.softentityreference

import com.haulmont.cuba.core.entity.Entity


public interface SoftReferenceService {
    String NAME = "ddcsef_SoftReferenceService";


    boolean doSoftReferencesExists(Entity softReference, com.haulmont.chile.core.model.MetaClass metaClassUsingSoftReference, String column)
}