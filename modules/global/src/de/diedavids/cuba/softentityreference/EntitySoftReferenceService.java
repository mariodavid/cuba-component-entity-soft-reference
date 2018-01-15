package de.diedavids.cuba.softentityreference;


import com.haulmont.cuba.core.entity.Entity;

public interface EntitySoftReferenceService {
    String NAME = "ddcsef_SoftEntityReferenceService";



    /**
     * Some API to get a Soft Reference from an Entity
     *
     * Not 100% sure if needed, but might be.
     * @param entity
     * @return
     */
    SoftReference createSoftReference(Entity entity);


    /**
     * And the other way around...
     * 
     * @param softReference
     * @return
     */
    Entity getEntity(SoftReference softReference);
}