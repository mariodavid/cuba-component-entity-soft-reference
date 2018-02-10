package de.diedavids.cuba.entitysoftreference

import com.haulmont.cuba.core.EntityManager
import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.Query
import com.haulmont.cuba.core.Transaction
import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.Metadata
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(SoftReferenceService.NAME)
class SoftReferenceServiceBean implements SoftReferenceService {


    @Inject
    private Persistence persistence

    @Inject
    Metadata metadata


    private Query createPolymorphicQuery(EntityManager em, Class<Entity> polymorphicEntityClass, String attribute, Entity softReference, String view = null) {
        def tableName = getTableNameFromEntityClass(polymorphicEntityClass)
        Query query = em.createQuery("select e from $tableName e where e.$attribute = :softReference")
        query.setParameter('softReference', softReference, false)

        if (view) {
            query.setView(polymorphicEntityClass, view)
        }

        query
    }

    @Override
    boolean doSoftReferencesExist(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute) {
        loadEntitiesForSoftReference(polymorphicEntityClass, softReference, attribute) as boolean
    }

    @Override
    Collection<Entity> loadEntitiesForSoftReference(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute, String view = null) {
        Transaction tx = persistence.createTransaction()
        EntityManager em = persistence.entityManager
        Query query = createPolymorphicQuery(em, polymorphicEntityClass, attribute, softReference, view)
        def result = query.resultList

        tx.commit()

        result
    }

    @Override
    int countEntitiesForSoftReference(Class<Entity> polymorphicEntityClass, Entity softReference, String attribute) {
        loadEntitiesForSoftReference(polymorphicEntityClass, softReference, attribute).size()
    }


    private String getTableNameFromEntityClass(Class<Entity> polymorphicEntityClass) {
        metadata.getClass(polymorphicEntityClass).name
    }
}