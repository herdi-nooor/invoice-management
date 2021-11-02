package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.InvoiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceTypeDAO extends PagingAndSortingRepository<InvoiceType, String> {
}
