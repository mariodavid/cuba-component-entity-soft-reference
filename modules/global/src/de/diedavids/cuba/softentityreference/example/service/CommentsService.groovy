package de.diedavids.cuba.softentityreference.example.service

import com.haulmont.cuba.core.entity.Entity

public interface CommentsService {
    String NAME = "DDCSEF_COMMENTService";

    void createCommentWithSoftReference(String text, Entity softReference)
    void createCommentWithEntitySoftReference(String text, Entity softReference)
}