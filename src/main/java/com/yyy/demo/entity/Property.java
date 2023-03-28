package com.yyy.demo.entity;

import java.util.Date;

public class Property {
    public int id;
    public String pname;//资产名称
    public int owner_id;
    public String owner_nickname;
    public int creator_id;
    public Date create_time;
    public int shoucang;
    public int ownership_deal_price;
    public int use_deal_price;
    public String deal_log;
    public String sale_state;//在售状态
    public String check_state;//审核状态

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_nickname() {
        return owner_nickname;
    }

    public void setOwner_nickname(String owner_nickname) {
        this.owner_nickname = owner_nickname;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getShoucang() {
        return shoucang;
    }

    public void setShoucang(int shoucang) {
        this.shoucang = shoucang;
    }

    public int getOwnership_deal_price() {
        return ownership_deal_price;
    }

    public void setOwnership_deal_price(int ownership_deal_price) {
        this.ownership_deal_price = ownership_deal_price;
    }

    public int getUse_deal_price() {
        return use_deal_price;
    }

    public void setUse_deal_price(int use_deal_price) {
        this.use_deal_price = use_deal_price;
    }

    public String getDeal_log() {
        return deal_log;
    }

    public void setDeal_log(String deal_log) {
        this.deal_log = deal_log;
    }

    public String getSale_state() {
        return sale_state;
    }

    public void setSale_state(String sale_state) {
        this.sale_state = sale_state;
    }

    public String getCheck_state() {
        return check_state;
    }

    public void setCheck_state(String check_state) {
        this.check_state = check_state;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", owner_id=" + owner_id +
                ", owner_nickname='" + owner_nickname + '\'' +
                ", creator_id=" + creator_id +
                ", create_time=" + create_time +
                ", shoucang=" + shoucang +
                ", ownership_deal_price=" + ownership_deal_price +
                ", use_deal_price=" + use_deal_price +
                ", deal_log='" + deal_log + '\'' +
                ", sale_state='" + sale_state + '\'' +
                ", check_state='" + check_state + '\'' +
                '}';
    }
}
