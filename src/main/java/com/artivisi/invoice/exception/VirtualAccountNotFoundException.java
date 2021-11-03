package com.artivisi.invoice.exception;

// cheked exception
// jangan pakai runtime exception, supaya wajib di hendle oelh yang panggil
public class VirtualAccountNotFoundException extends Exception{
    public VirtualAccountNotFoundException() { }
    public VirtualAccountNotFoundException(String message) {
        super(message);
    }
}
