package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;

// mengatur jenis tagihan yang ada dan digunakan

@Entity @Data
public class InvoiceType extends BaseEntity {
    private String code;
    private String name;
}
