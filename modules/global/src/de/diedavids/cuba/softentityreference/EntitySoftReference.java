package de.diedavids.cuba.softentityreference;

import com.haulmont.chile.core.model.MetaClass;

public class EntitySoftReference {


    private Object id;

    private MetaClass metaClass;

    private String caption;


    public MetaClass getMetaClass() {
        return metaClass;
    }

    public void setMetaClass(MetaClass metaClass) {
        this.metaClass = metaClass;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
