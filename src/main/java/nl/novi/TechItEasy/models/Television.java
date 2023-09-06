package nl.novi.TechItEasy.models;

public class Television {

private String tv;
private String beeldverhouding;


public Television(String tv, String beeldverhouding) {
    this.tv = tv;
    this.beeldverhouding = beeldverhouding;
}
    public String getBeeldverhouding() {
        return beeldverhouding;
    }

    public void setBeeldverhouding(String beeldverhouding) {
        this.beeldverhouding = beeldverhouding;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
}