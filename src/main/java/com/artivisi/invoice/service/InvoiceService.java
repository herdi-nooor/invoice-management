package com.artivisi.invoice.service;

import com.artivisi.invoice.entity.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceService {
    public Invoice createInvoice(){
        Invoice invoice =  new Invoice();

        return invoice;
    }
}
