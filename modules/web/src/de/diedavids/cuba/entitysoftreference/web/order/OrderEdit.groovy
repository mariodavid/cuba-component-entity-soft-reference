package de.diedavids.cuba.entitysoftreference.web.order

import com.haulmont.cuba.gui.components.AbstractEditor
import de.diedavids.cuba.entitysoftreference.example.Comment
import de.diedavids.cuba.entitysoftreference.example.Order
import de.diedavids.cuba.entitysoftreference.example.service.CommentsService

import javax.inject.Inject

class OrderEdit extends AbstractEditor<Order> {


    @Inject
    CommentsService commentsService

    void createComment() {
        Comment comment = commentsService.createComment("test", getItem())
        showNotification("Comment " + comment.id + " created...")
    }
}