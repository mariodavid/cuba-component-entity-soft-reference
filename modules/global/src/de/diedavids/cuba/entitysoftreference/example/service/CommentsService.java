package de.diedavids.cuba.entitysoftreference.example.service;

import com.haulmont.cuba.core.entity.Entity;
import de.diedavids.cuba.entitysoftreference.example.Comment;

public interface CommentsService {
    String NAME = "ddcesf_CommentService";

    Comment createComment(String text, Entity softReference);
}