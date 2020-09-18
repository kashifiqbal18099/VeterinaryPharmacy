package com.kashif.veterinarypharmacy.network;

/**
 * Created by Tahir-Laptop on 12/20/2017.
 */

public class Params {
    String key, value;

    public Params(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
