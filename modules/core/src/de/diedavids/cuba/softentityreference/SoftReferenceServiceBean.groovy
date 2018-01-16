package de.diedavids.cuba.softentityreference

import com.haulmont.chile.core.model.MetaClass
import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.EntityLoadInfo
import com.haulmont.cuba.core.global.EntityLoadInfoBuilder
import com.haulmont.cuba.core.global.LoadContext
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(SoftReferenceService.NAME)
public class SoftReferenceServiceBean implements SoftReferenceService {


    @Inject
    DataManager dataManager

    @Inject
    EntityLoadInfoBuilder entityLoadInfoBuilder

    @Override
    boolean doSoftReferencesExists(Entity softReference, MetaClass metaClassUsingSoftReference, String column) {

//        String toString = getToStringFromEntity(softReference)

        LoadContext loadContext = new LoadContext(metaClassUsingSoftReference)
                .setQuery(LoadContext.createQuery("select e from " + metaClassUsingSoftReference.getName() + " e where e." + column  + " = :softReference")
                .setParameter('softReference', softReference)
        )


        return dataManager.getCount(loadContext) as boolean;
    }

//    private String getToStringFromEntity(Entity softReference) {
//
//        EntityLoadInfo entityLoadInfo = entityLoadInfoBuilder.create(softReference);
//
//
//        return entityLoadInfo.toString();
//    }


}