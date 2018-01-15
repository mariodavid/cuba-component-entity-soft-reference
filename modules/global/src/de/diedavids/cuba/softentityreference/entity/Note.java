package de.diedavids.cuba.softentityreference.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.MetaProperty;
import de.diedavids.cuba.softentityreference.SoftReference;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "DDCSEF_NOTABLE")
@Entity(name = "ddcsef$Notable")
public class Note extends StandardEntity {
    private static final long serialVersionUID = -7023859693517561873L;

    @Column(name = "TEXT")
    protected String text;

    @MetaProperty(datatype = "SoftReference")
    @Column(name = "NOTABLE")
    protected SoftReference notable;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setNotable(SoftReference notable) {
        this.notable = notable;
    }

    public SoftReference getNotable() {
        return notable;
    }


}