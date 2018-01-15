package de.diedavids.cuba.softentityreference.example.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Metadata
import de.diedavids.cuba.softentityreference.EntitySoftReferenceService
import de.diedavids.cuba.softentityreference.SoftReference
import de.diedavids.cuba.softentityreference.example.Comment
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(CommentsService.NAME)
public class CommentsServiceBean implements CommentsService {


    @Inject
    DataManager dataManager

    @Inject
    Metadata metadata

    @Inject
    EntitySoftReferenceService entitySoftReferenceService



    @Override
    void createCommentWithSoftReference(String text, Entity entity) {
        SoftReference realSoftReference = entitySoftReferenceService.createSoftReference(entity)

        Comment comment = createComment(text)
        comment.commentable = realSoftReference

        saveComment(comment)
    }

    @Override
    void createCommentWithEntitySoftReference(String text, Entity entity) {

        Comment comment = createComment(text)
        comment.entityCommentable = entity

        saveComment(comment)
    }


    private Comment createComment(String text) {
        Comment comment = metadata.create(Comment)
        comment.text = text
        comment
    }

    private Comment saveComment(Comment comment) {
        dataManager.commit(comment)
    }
}