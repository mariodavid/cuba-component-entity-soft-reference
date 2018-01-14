package de.diedavids.cuba.softentityreference.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.MetaProperty;
import de.diedavids.cuba.softentityreference.EntitySoftReference;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "DDCSEF_NOTABLE")
@Entity(name = "ddcsef$Notable")
public class Notable extends StandardEntity {
    private static final long serialVersionUID = -7023859693517561873L;

    @Column(name = "TEXT")
    protected String text;

    @MetaProperty(datatype = "entitySoftReference")
    @Column(name = "NOTABLE")
    protected EntitySoftReference notable;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setNotable(EntitySoftReference notable) {
        this.notable = notable;
    }

    public EntitySoftReference getNotable() {
        return notable;
    }


}