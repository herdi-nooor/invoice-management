package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymnetDAO extends PagingAndSortingRepository<Payment, String> {
}
