package com.citi.bean;

import java.util.Date;

/**
 * @Auther: chenle
 * @Date: 2020/8/24 - 14:37
 * @Description: com.citi.bean
 * @version: 1.0
 */
public class DemoBondsSalesRecord {

    Integer id;
    String bondsName;
    String salesName;
    Integer amount;
    Date createdAt;
    Date updatedAt;

    @Override
    public String toString() {
        return "DemoBondsSalesRecord{" +
                "id=" + id +
                ", bondsName='" + bondsName + '\'' +
                ", salesName='" + salesName + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBondsName() {
        return bondsName;
    }

    public void setBondsName(String bondsName) {
        this.bondsName = bondsName;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
