package de.diedavids.cuba.entitysoftreference.entity.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;

@Table(name = "DDCESF_CUSTOMER")
@Entity(name = "ddcesf$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 7540688862618845353L;

    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}