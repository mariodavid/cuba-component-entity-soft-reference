package de.diedavids.cuba.softentityreference.example;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;
import com.haulmont.chile.core.annotations.NamePattern;

//@NamePattern("%s|orderDate")
@Table(name = "DDCSEF_ORDER")
@Entity(name = "ddcsef$Order")
public class Order extends BaseIntegerIdEntity implements HasUuid {
    private static final long serialVersionUID = 8214893854338152738L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    protected Date orderDate;

    @Column(name = "UUID")
    private UUID uuid;

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }


}