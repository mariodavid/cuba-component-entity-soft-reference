package de.diedavids.cuba.entitysoftreference;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Service(SoftReferenceService.NAME)

public class SoftReferenceServiceBean implements SoftReferenceService {

    @Inject
    private Persistence persistence;

    @Inject
    Metadata metadata;

    private Query createPolymorphicQuery(EntityManager em, Class<? extends Entity> polymorphicEntityClass,
                                         String attribute,
                                         Entity softReference,
                                         String view) {
        String tableName = getTableNameFromEntityClass(polymorphicEntityClass);
        Query query = em.createQuery("select e from " + tableName + " e where e." + attribute + " = :softReference");
        query.setParameter("softReference", softReference, false);

        if (view != null) {
            query.setView(polymorphicEntityClass, view);
        }

        return query;
    }

    @Override
    public boolean doSoftReferencesExist(Class<? extends Entity> polymorphicEntityClass, Entity softReference, String attribute) {
        return !loadEntitiesForSoftReference(polymorphicEntityClass, softReference, attribute).isEmpty();
    }

    @Override
    public <T extends Entity> Collection<T> loadEntitiesForSoftReference(Class<T> polymorphicEntityClass, Entity softReference, String attribute) {
        return loadEntitiesForSoftReference(polymorphicEntityClass, softReference, attribute, null);
    }

    @Override
    public int countEntitiesForSoftReference(Class<? extends Entity> polymorphicEntityClass, Entity softReference, String attribute) {
        return loadEntitiesForSoftReference(polymorphicEntityClass, softReference, attribute).size();
    }

    @Override
    public <T extends Entity> Collection<T> loadEntitiesForSoftReference(Class<T> polymorphicEntityClass,
                                                                  Entity softReference,
                                                                  String attribute,
                                                                  String view) {
        Transaction tx = persistence.createTransaction();
        EntityManager em = persistence.getEntityManager();
        Query query = createPolymorphicQuery(em, polymorphicEntityClass, attribute, softReference, view);
        List result = query.getResultList();

        tx.commit();

        return result;
    }

    private String getTableNameFromEntityClass(Class<? extends Entity> polymorphicEntityClass) {
        return metadata.getClass(polymorphicEntityClass).getName();
    }
}