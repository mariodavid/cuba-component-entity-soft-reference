package de.diedavids.cuba.softentityreference.example;

import javax.persistence.*;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.SystemLevel;
import de.diedavids.cuba.softentityreference.EntitySoftReferenceConverter;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|text")
@Table(name = "DDCSEF_COMMENT")
@Entity(name = "ddcsef$Comment")
public class Comment extends StandardEntity {
    private static final long serialVersionUID = 5719925818360110149L;

    @Column(name = "TEXT")
    protected String text;

    @SystemLevel
    @Convert(converter = EntitySoftReferenceConverter.class)
    @MetaProperty(datatype = "EntitySoftReference")
    @Column(name = "COMMENTABLE")
    protected com.haulmont.cuba.core.entity.Entity commentable;


    public void setCommentable(com.haulmont.cuba.core.entity.Entity commentable) {
        this.commentable = commentable;
    }

    public com.haulmont.cuba.core.entity.Entity getCommentable() {
        return commentable;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }



}