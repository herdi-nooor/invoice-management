package com.artivisi.invoice.exception;
/**
jangan pakai runtime exception,
runtime exeption dipakai untuk error yang
tidak bisa dihandle oleh yang  panggil ( controler API, controler WEB, ISO8583 handler)
contoh : query selecvt one , tapi returnnya > 1
public class VirtualAccountAlreadyPaidException extends RuntimeException{
 **/
public class VirtualAccountAlreadyPaidException extends Exception{
    public VirtualAccountAlreadyPaidException() {
    }

    public VirtualAccountAlreadyPaidException(String message) {
        super(message);
    }
}
