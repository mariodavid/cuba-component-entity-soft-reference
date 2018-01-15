package de.diedavids.cuba.softentityreference.example.service

import com.haulmont.cuba.core.entity.Entity
import de.diedavids.cuba.softentityreference.example.Comment

public interface CommentsService {
    String NAME = "ddcsef_CommentService";

    Comment createComment(String text, Entity softReference)
}