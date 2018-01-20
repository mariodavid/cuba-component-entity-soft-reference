package de.diedavids.cuba.entitysoftreference

import com.haulmont.chile.core.model.MetaClass
import com.haulmont.cuba.core.EntityManager
import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.Query
import com.haulmont.cuba.core.Transaction
import com.haulmont.cuba.core.entity.Entity
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(SoftReferenceService.NAME)
class SoftReferenceServiceBean implements SoftReferenceService {


    @Inject
    private Persistence persistence


    @Override
    boolean doSoftReferencesExist(MetaClass baseEntity, Entity softReference, String attribute) {
        getEntitiesForSoftReference(baseEntity, softReference, attribute) as boolean
    }

    @Override
    Collection<Entity> getEntitiesForSoftReference(MetaClass baseEntity, Entity softReference, String attribute) {

        Transaction tx = persistence.createTransaction()
        EntityManager em = persistence.entityManager
        Query query = createSoftReferencesExist(em, baseEntity, attribute, softReference)
        def result = query.resultList
        tx.commit()

        result as Collection<Entity>
    }

    private Query createSoftReferencesExist(EntityManager em, MetaClass metaClassUsingSoftReference, String attribute, Entity softReference) {
        def tableName = metaClassUsingSoftReference.name
        Query query = em.createQuery("select e from $tableName e where e.$attribute = :softReference")
        query.setParameter('softReference', softReference, false)
        query
    }


}