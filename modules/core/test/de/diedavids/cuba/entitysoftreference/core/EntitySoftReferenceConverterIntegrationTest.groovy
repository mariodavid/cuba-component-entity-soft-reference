package de.diedavids.cuba.entitysoftreference.core

import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.Metadata
import de.diedavids.cuba.entitysoftreference.DdcsefTestContainer
import de.diedavids.cuba.entitysoftreference.EntitySoftReferenceConverter
import de.diedavids.cuba.entitysoftreference.entity.example.Customer
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat;

class EntitySoftReferenceConverterIntegrationTest {

    @ClassRule
    public static DdcsefTestContainer cont = DdcsefTestContainer.Common.INSTANCE;

    private Metadata metadata;
    private Persistence persistence;
    private DataManager dataManager
    private EntitySoftReferenceConverter converter

    @Before
    void setUp() throws Exception {
        metadata = cont.metadata()
        persistence = cont.persistence()
        dataManager = AppBeans.get(DataManager)

        converter = new EntitySoftReferenceConverter()
    }


    @Test
    void givenAnExistingSoftReference_whenConvertToEntityAttribute_EntityIsReturned() {

        //given
        def customer = metadata.create(Customer)
        customer.name = "Mr. King"
        def storedCustomer = dataManager.commit(customer)
        def customerSoftReferenceString = converter.convertToDatabaseColumn(customer)

        //when
        def entity = converter.convertToEntityAttribute(customerSoftReferenceString)

        //then
        assertThat(entity).isEqualTo(storedCustomer)

    }

    @Test
    void givenANonPersistentSoftReference_whenConvertToEntityAttribute_nullIsReturned() {

        //given
        def customer = metadata.create(Customer)

        def customerSoftReferenceString = converter.convertToDatabaseColumn(customer)

        //when
        def entity = converter.convertToEntityAttribute(customerSoftReferenceString)

        //then
        assertThat(entity).isNull()

    }

    @Test
    void givenANonExistingSoftReference_whenConvertToEntityAttribute_nullIsReturned() {

        //when
        def entity = converter.convertToEntityAttribute('ddcesf$Customer-1d6ab948-e5e0-0959-ef47-d150c37d6535')

        //then
        assertThat(entity).isNull()

    }

    @Test
    void givenANonExistingMetaClass_whenConvertToEntityAttribute_nullIsReturned() {

        //when
        def entity = converter.convertToEntityAttribute('nonexisting$EntityClass-1d6ab948-e5e0-0959-ef47-d150c37d6535')

        //then
        assertThat(entity).isNull()

    }

}