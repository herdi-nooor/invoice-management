package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

// mengatur tagihan

@Data @Entity
public class Invoice extends BaseEntity{

 //   @NotNull
    @ManyToOne @JoinColumn(name = "id_invoice_type")
    private InvoiceType invoiceType;

 //   @NotNull @NotEmpty @Size(min = 3, max = 100 )
    private String invoicenNumber;
    private String description;
    private Boolean paid;
    private LocalDate dueDate;
    private BigDecimal amount;
}
