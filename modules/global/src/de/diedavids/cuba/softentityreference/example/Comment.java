package de.diedavids.cuba.softentityreference.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import de.diedavids.cuba.softentityreference.SoftReference;
import de.diedavids.cuba.softentityreference.EntitySoftReferenceDatatype;

@Table(name = "DDCSEF_COMMENT")
@Entity(name = "ddcsef$Comment")
public class Comment extends StandardEntity {
    private static final long serialVersionUID = 5719925818360110149L;

    @Column(name = "TEXT")
    protected String text;

    @MetaProperty(datatype = "EntitySoftReference")
    @Column(name = "ENTITY_COMMENTABLE")
    protected com.haulmont.cuba.core.entity.Entity entityCommentable;

    @MetaProperty(datatype = "SoftReference")
    @Column(name = "COMMENTABLE")
    protected SoftReference commentable;

    public void setEntityCommentable(com.haulmont.cuba.core.entity.Entity entityCommentable) {
        this.entityCommentable = entityCommentable;
    }

    public com.haulmont.cuba.core.entity.Entity getEntityCommentable() {
        return entityCommentable;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setCommentable(SoftReference commentable) {
        this.commentable = commentable;
    }

    public SoftReference getCommentable() {
        return commentable;
    }


}