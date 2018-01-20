package de.diedavids.cuba.entitysoftreference.web.example.customer

import com.haulmont.cuba.gui.components.AbstractEditor
import de.diedavids.cuba.entitysoftreference.example.Comment
import de.diedavids.cuba.entitysoftreference.example.Customer
import de.diedavids.cuba.entitysoftreference.example.service.CommentsService

import javax.inject.Inject

class CustomerEdit extends AbstractEditor<Customer> {


    @Inject
    CommentsService commentsService

    void addComment() {
        Comment comment = commentsService.createComment('test', item)
        showNotification("Comment ${comment.id} created...")
    }
}