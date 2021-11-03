package com.artivisi.invoice.service;

import com.artivisi.invoice.dao.VirtualAccountDAO;
import com.artivisi.invoice.entity.PaymentProvider;
import com.artivisi.invoice.entity.VirtualAccount;
import com.artivisi.invoice.exception.VirtualAccountAlreadyPaidException;
import com.artivisi.invoice.exception.VirtualAccountNotFoundException;
import com.artivisi.invoice.helper.VirtualAccountHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class PaymentService {
    @Autowired private VirtualAccountDAO virtualAccountDAO;
    @Autowired private VirtualAccountHelper virtualAccountHelper;

    public void pay(PaymentProvider provider, String companyId,
                    String accountNumber, BigDecimal amaount, String reference) throws VirtualAccountNotFoundException, VirtualAccountAlreadyPaidException {

        VirtualAccount va = virtualAccountHelper.cekVaAda(provider, companyId, accountNumber);
        cekVaLunas(provider, companyId, accountNumber, va);
        // refactoring code ^^^

        // 3. cek apakah total akumulasi pembayaeran < amaount
        // 4. update status va menjadi lunas
        // 5. update status invoice menjadi lunas
        // 6. insert ke tabel payment
        // 7. notifikasi (next fase)
    }

    private void cekVaLunas(PaymentProvider provider, String companyId, String accountNumber, VirtualAccount va) throws VirtualAccountAlreadyPaidException {
        if (va.getInvoice().getPaid()){
            throw new VirtualAccountAlreadyPaidException("va ["+ companyId +"/"+ accountNumber +"-"+ provider.getCode()+"] already paid");
        }
    }


}
