package com.artivisi.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity @Data
public class InvoiceType extends BaseEntity {
    private String code;
    private String name;
}
