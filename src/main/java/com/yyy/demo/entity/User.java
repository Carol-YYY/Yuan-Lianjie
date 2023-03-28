package com.yyy.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.web.multipart.MultipartFile;

public class User {
    public int id;
    public String nickname;
    public String phonenumber;
    @TableField(exist=false)
    public MultipartFile touxiang;
    public int fans;
    public int guanzhu;
    public int balance;
    public int ownership_property;
    public int use_property;
    public String dealinfo;
    public String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public MultipartFile getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(MultipartFile touxiang) {
        this.touxiang = touxiang;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getGuanzhu() {
        return guanzhu;
    }

    public void setGuanZhu(int guanZhu) {
        this.guanzhu = guanZhu;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getOwnership_property() {
        return ownership_property;
    }

    public void setOwnership_property(int ownership_property) {
        this.ownership_property = ownership_property;
    }

    public int getUse_property() {
        return use_property;
    }

    public void setUse_property(int use_property) {
        this.use_property = use_property;
    }

    public String getDealinfo() {
        return dealinfo;
    }

    public void setDealinfo(String dealinfo) {
        this.dealinfo = dealinfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGuanzhu(int guanzhu) {
        this.guanzhu = guanzhu;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", touxiang=" + touxiang +
                ", fans=" + fans +
                ", guanzhu=" + guanzhu +
                ", balance=" + balance +
                ", ownership_property=" + ownership_property +
                ", use_property=" + use_property +
                ", dealinfo='" + dealinfo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
