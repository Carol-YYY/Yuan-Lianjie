package com.yyy.demo.entity;

import java.util.Date;

public class Deal_application {
    public int id;
    public String deal_type;
    public int buyer_id;
    public String buyer_nickname;
    public int saler_id;
    public String saler_nickname;
    public int property;
    public String property_name;
    public int deal_price;
    public Date deal_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeal_type() {
        return deal_type;
    }

    public void setDeal_type(String deal_type) {
        this.deal_type = deal_type;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_nickname() {
        return buyer_nickname;
    }

    public void setBuyer_nickname(String buyer_nickname) {
        this.buyer_nickname = buyer_nickname;
    }

    public int getSaler_id() {
        return saler_id;
    }

    public void setSaler_id(int saler_id) {
        this.saler_id = saler_id;
    }

    public String getSaler_nickname() {
        return saler_nickname;
    }

    public void setSaler_nickname(String saler_nickname) {
        this.saler_nickname = saler_nickname;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public int getDeal_price() {
        return deal_price;
    }

    public void setDeal_price(int deal_price) {
        this.deal_price = deal_price;
    }

    public Date getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(Date deal_time) {
        this.deal_time = deal_time;
    }

    @Override
    public String toString() {
        return "Deal_application{" +
                "id=" + id +
                ", deal_type='" + deal_type + '\'' +
                ", buyer_id=" + buyer_id +
                ", buyer_nickname='" + buyer_nickname + '\'' +
                ", saler_id=" + saler_id +
                ", saler_nickname='" + saler_nickname + '\'' +
                ", property=" + property +
                ", property_name='" + property_name + '\'' +
                ", deal_price=" + deal_price +
                ", deal_time=" + deal_time +
                '}';
    }
}
