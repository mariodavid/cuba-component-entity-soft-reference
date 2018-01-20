package de.diedavids.cuba.entitysoftreference.web.order

import com.haulmont.cuba.core.global.Metadata
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.Table
import de.diedavids.cuba.entitysoftreference.SoftReferenceService
import de.diedavids.cuba.entitysoftreference.example.Comment

import javax.inject.Inject

class OrderBrowse extends AbstractLookup {

    @Inject
    Table ordersTable

    @Inject
    Metadata metadata

    @Inject
    SoftReferenceService softReferenceService
    private final String COMMENTABLE_COLUMN = 'commentable'

    void doCommentsExists() {

        def selected = ordersTable.singleSelected

        def comment = metadata.create(Comment)

        def exists = softReferenceService.doSoftReferencesExist(comment.metaClass, selected, COMMENTABLE_COLUMN)

        showNotification("exists: $exists")
    }

    void showComments() {

        def selected = ordersTable.singleSelected

        def comment = metadata.create(Comment)

        def result = softReferenceService.getEntitiesForSoftReference(comment.metaClass, selected, COMMENTABLE_COLUMN)

        showNotification("result: $result")
    }
}