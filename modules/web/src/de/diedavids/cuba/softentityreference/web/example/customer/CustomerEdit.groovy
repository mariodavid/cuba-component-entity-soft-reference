package de.diedavids.cuba.softentityreference.web.example.customer

import com.haulmont.cuba.gui.components.AbstractEditor
import de.diedavids.cuba.softentityreference.example.Customer
import de.diedavids.cuba.softentityreference.example.service.CommentsService

import javax.inject.Inject

class CustomerEdit extends AbstractEditor<Customer> {


    @Inject
    CommentsService commentsService


    public void createCommentEntitySoftReference() {
        commentsService.createCommentWithEntitySoftReference("test with direct entity association", getItem())
    }

    public void createCommentSoftReference() {
        commentsService.createCommentWithSoftReference("test with entity association via soft reference", getItem())
    }
}