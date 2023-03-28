package com.yyy.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.web.multipart.MultipartFile;

public class Administrator {
    public int id;
    public String nickname;
    @TableField(exist = false)
    public MultipartFile touxiang;
    public String info;
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

    public MultipartFile getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(MultipartFile touxiang) {
        this.touxiang = touxiang;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", touxiang=" + touxiang +
                ", info='" + info + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
