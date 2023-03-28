package com.yyy.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Informer {
    public int informer_id;//举报人id
    public String informer_nickname;
    public int reported_id;//被举报人id
    public String reported_nickname;
    public Date inform_time;
    public String reason;
    @TableField(exist = false)
    public MultipartFile evidence;

    public int getInformer_id() {
        return informer_id;
    }

    public void setInformer_id(int informer_id) {
        this.informer_id = informer_id;
    }

    public String getInformer_nickname() {
        return informer_nickname;
    }

    public void setInformer_nickname(String informer_nickname) {
        this.informer_nickname = informer_nickname;
    }

    public int getReported_id() {
        return reported_id;
    }

    public void setReported_id(int reported_id) {
        this.reported_id = reported_id;
    }

    public String getReported_nickname() {
        return reported_nickname;
    }

    public void setReported_nickname(String reported_nickname) {
        this.reported_nickname = reported_nickname;
    }

    public Date getInform_time() {
        return inform_time;
    }

    public void setInform_time(Date inform_time) {
        this.inform_time = inform_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public MultipartFile getEvidence() {
        return evidence;
    }

    public void setEvidence(MultipartFile evidence) {
        this.evidence = evidence;
    }

    @Override
    public String toString() {
        return "Informer{" +
                "informer_id=" + informer_id +
                ", informer_nickname='" + informer_nickname + '\'' +
                ", reported_id=" + reported_id +
                ", reported_nickname='" + reported_nickname + '\'' +
                ", inform_time=" + inform_time +
                ", reason='" + reason + '\'' +
                ", evidence=" + evidence +
                '}';
    }
}
