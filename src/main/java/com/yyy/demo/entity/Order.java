package com.yyy.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("order1")
public class Order {

    public int id;
    public String time;
    public int total;
    public int uid;

    @TableField(exist=false)
    private User users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", total=" + total +
                ", uid=" + uid +
                ", users=" + users +
                '}';
    }
}
