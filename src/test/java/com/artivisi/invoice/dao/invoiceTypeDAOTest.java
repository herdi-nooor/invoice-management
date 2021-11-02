package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/sql/delete-invoice-type.sql", "/sql/insert-inactive-invoice-type.sql"})
public class invoiceTypeDAOTest {

    @Autowired InvoiceTypeDAO invoiceTypeDAO;

    @Test
    public void testInsertInvoiceType() throws Exception {
        InvoiceType it = new InvoiceType();
        it.setCode("IT-001");
        it.setName("invoice type test");
        Assertions.assertNull(it.getId());
        invoiceTypeDAO.save(it);

        System.out.println("ID : "+it.getId());
        System.out.println("create time : "+it.getCreated());
        System.out.println("create by   : "+it.getCreatedBy());
        System.out.println("update time : "+it.getUpdated());
        System.out.println("update by   : "+it.getLastUpdatedBy());
        System.out.println("status record : "+it.getStatusRecord());

        Assertions.assertNotNull(it.getId());
        Assertions.assertNotNull(it.getCreated());
        Assertions.assertNotNull(it.getCreatedBy());
        Assertions.assertNotNull(it.getUpdated());
        Assertions.assertNotNull(it.getLastUpdatedBy());
        Assertions.assertNotNull(it.getStatusRecord());

        Assertions.assertEquals(it.getCreated(), it.getUpdated());

        Thread.sleep(2000);

        it.setName("user updatee");
        it = invoiceTypeDAO.save(it);
        System.out.println("create time : "+it.getCreated());
        System.out.println("update time : "+it.getUpdated());
        Assertions.assertNotEquals(it.getCreated(), it.getUpdated());

    }

    @Test
    public void testQuerySoftDelete() {
        Long jumlahRecord = invoiceTypeDAO.count();
        System.out.println("jumlah record : "+ jumlahRecord);
        Assertions.assertEquals(1, jumlahRecord);
    }

    @Test
    public void testSoftDelete() {
        InvoiceType it = invoiceTypeDAO.findById("test002").get();
        invoiceTypeDAO.delete(it);

        Long jumlahRecord = invoiceTypeDAO.count();
        System.out.println("jumlah record : "+ jumlahRecord);
        Assertions.assertEquals(0, jumlahRecord);

    }
}
