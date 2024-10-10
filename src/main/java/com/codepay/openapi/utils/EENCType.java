package com.codepay.openapi.utils;

public enum EENCType {
    AES("AES"),
    RSA("RSA");

    private String value;

    EENCType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
