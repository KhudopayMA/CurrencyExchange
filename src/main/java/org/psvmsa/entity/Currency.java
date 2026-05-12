package org.psvmsa.entity;

public class Currency {
    Long id;
    String code;
    String full_name;
    String sign;

    public Currency(Long id, String code, String full_name, String sign) {
        this.id = id;
        this.code = code;
        this.full_name = full_name;
        this.sign = sign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", full_name='" + full_name + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
