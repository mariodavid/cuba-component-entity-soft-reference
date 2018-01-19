package de.diedavids.cuba.entitysoftreference.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "DDCESF_CUSTOMER")
@Entity(name = "ddcesf$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 7430983054035122573L;

    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}