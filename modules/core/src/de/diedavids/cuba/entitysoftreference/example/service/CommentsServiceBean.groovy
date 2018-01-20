package de.diedavids.cuba.entitysoftreference.example.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Metadata

import de.diedavids.cuba.entitysoftreference.example.Comment
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(CommentsService.NAME)
class CommentsServiceBean implements CommentsService {


    @Inject
    DataManager dataManager

    @Inject
    Metadata metadata


    @Override
    Comment createComment(String text, Entity entity) {

        Comment comment = metadata.create(Comment)
        comment.text = text
        comment.commentable = entity

        saveComment(comment)
    }


    private Comment saveComment(Comment comment) {
        dataManager.commit(comment)
    }
}