package de.diedavids.cuba.softentityreference.web.order

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.Metadata
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.Table
import de.diedavids.cuba.softentityreference.SoftReferenceService
import de.diedavids.cuba.softentityreference.example.Comment

import javax.inject.Inject

class OrderBrowse extends AbstractLookup {

    @Inject
    Table ordersTable

    @Inject
    Metadata metadata

   @Inject
   SoftReferenceService softReferenceService

    public void countComments() {

        def selected = ordersTable.singleSelected

        def comment = metadata.create(Comment)

        def exists = softReferenceService.doSoftReferencesExists(selected, comment.metaClass, "commentable")

        showNotification("exists: $exists")
    }
}