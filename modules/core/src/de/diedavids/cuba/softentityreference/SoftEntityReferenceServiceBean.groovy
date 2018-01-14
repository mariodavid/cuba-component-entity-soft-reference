package de.diedavids.cuba.softentityreference

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.LoadContext
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(SoftEntityReferenceService.NAME)
public class SoftEntityReferenceServiceBean implements SoftEntityReferenceService {

    @Inject
    DataManager dataManager

    @Override
    Entity getEntity(EntitySoftReference entitySoftReference) {
        null
    }


}