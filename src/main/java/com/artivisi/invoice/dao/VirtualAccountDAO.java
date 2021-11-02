package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VirtualAccountDAO extends PagingAndSortingRepository<VirtualAccount, String> {


}
