package de.diedavids.cuba.softentityreference

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(EntitySoftReferenceService.NAME)
public class EntitySoftReferenceServiceBean implements EntitySoftReferenceService {

    @Inject
    DataManager dataManager

    @Override
    Entity getEntity(SoftReference entitySoftReference) {
        null
    }


}