package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.PaymentProvider;
import com.artivisi.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface VirtualAccountDAO extends PagingAndSortingRepository<VirtualAccount, String> {

    Optional<VirtualAccount> findByPaymentProviderAndCompanyIdAndAccountNumber(PaymentProvider provider, String companyId, String accountNumber);
}
