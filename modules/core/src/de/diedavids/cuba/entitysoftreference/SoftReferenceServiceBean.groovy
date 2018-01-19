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
        def result = null

        try {
            Transaction tx = persistence.createTransaction()
            EntityManager em = persistence.getEntityManager()
            Query query = createSoftReferencesExist(em, baseEntity, attribute, softReference)
            result = query.getResultList()

            tx.commit()
        }
        catch (Exception e) {
            e.printStackTrace()
        }

        return result as Collection<Entity>
    }

    private Query createSoftReferencesExist(EntityManager em, MetaClass metaClassUsingSoftReference, String attribute, Entity softReference) {
        Query query = em.createQuery(
                "select e from " + metaClassUsingSoftReference.getName() + " e where e." + attribute + " = :softReference")
        query.setParameter("softReference", softReference, false)
        query
    }


}