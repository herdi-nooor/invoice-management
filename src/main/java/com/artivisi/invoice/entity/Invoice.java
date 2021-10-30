package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

// mengatur tagihan

@Data @Entity
public class Invoice extends BaseEntity{

    @NotNull
    @ManyToOne @JoinColumn(name = "id_invoice_type")
    private InvoiceType invoiceType;

    @NotNull @NotEmpty @Size(min = 3, max = 100 )
    private String invoicenNumber;

    @NotNull @NotEmpty @Size(min = 3, max = 255)
    private String description;

    @NotNull
    private Boolean paid;

    @NotNull
    private LocalDate dueDate;

    @NotNull @Min(0)
    private BigDecimal amount;
}
