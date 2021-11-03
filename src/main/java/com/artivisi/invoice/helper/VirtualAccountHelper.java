package com.artivisi.invoice.helper;

//import com.artivisi.invoice.dao.VirtualAccountDAO;
//import com.artivisi.invoice.entity.PaymentProvider;
//import com.artivisi.invoice.entity.VirtualAccount;
//import com.artivisi.invoice.exception.VirtualAccountNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class VirtualAccountHelper {
//
//    @Autowired private VirtualAccountDAO virtualAccountDAO;
//    public VirtualAccount cekVaAda(PaymentProvider provider, String companyId, String accountNumber) throws VirtualAccountNotFoundException {
//        Optional<VirtualAccount> optVa = virtualAccountDAO.finByPaymentProviderAndCompanyIdAndAccountNumber(provider, companyId, accountNumber);
//        if (!optVa.isPresent()){
//            throw new VirtualAccountNotFoundException("va ["+ companyId +"/"+ accountNumber +"-"+ provider.getCode()+"] notfound");
//        }
//        VirtualAccount va = optVa.get();
//        return va;
//    }
//
//
//}
/** jika pakai staatic,
 * dan manggilnya langsung pakai nama classnya nanti
 * untuk import method sepeti virtualAccountDAO, cukup tambahkan kedalam parameternya
 **/

import com.artivisi.invoice.dao.VirtualAccountDAO;
import com.artivisi.invoice.entity.PaymentProvider;
import com.artivisi.invoice.entity.VirtualAccount;
import com.artivisi.invoice.exception.VirtualAccountNotFoundException;

import java.util.Optional;


public class VirtualAccountHelper {
    public static VirtualAccount cekVaAda(VirtualAccountDAO virtualAccountDAO, PaymentProvider provider, String companyId, String accountNumber) throws VirtualAccountNotFoundException {
        Optional<VirtualAccount> optVa =
                virtualAccountDAO.findByPaymentProviderAndCompanyIdAndAccountNumber(
                        provider, companyId, accountNumber
                );
        if (!optVa.isPresent()){
            throw new VirtualAccountNotFoundException("va ["+ companyId +
                    "/"+ accountNumber +"-"+ provider.getCode()+"] notfound");
        }
        VirtualAccount va = optVa.get();
        return va;
    }
 }
 /** tidak pakai @Autowired dan componen lagi
 **/
