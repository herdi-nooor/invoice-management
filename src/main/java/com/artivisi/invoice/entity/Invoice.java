package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data @Entity
public class Invoice extends BaseEntity{

    @NotNull
    @ManyToOne @JoinColumn(name = "id_invoice_type")
    private InvoiceType invoiceType;

    @NotNull @NotEmpty @Size(min = 3, max = 100 )
    private String invoicenNumber;
    private String description;
    private Boolean paid;
    private LocalDate dueDate;
    private BigDecimal amount;
}
