package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// mengatur jenis tagihan yang ada dan digunakan

@Entity @Data
public class InvoiceType extends BaseEntity {

    @NotNull @NotEmpty @Size(min = 3, max = 100)
    private String code;

    @NotNull @NotEmpty @Size(min = 3, max = 100)
    private String name;
}
