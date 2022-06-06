package com.example.atelieclient.domain.model;

import java.sql.Timestamp;

public class Order extends Entity {
    private String article;
    private Timestamp acceptanceTime;
    private Long customerId;

    public Order(String article, Timestamp acceptanceTime, Long customerId) {
        this.article = article;
        this.acceptanceTime = acceptanceTime;
        this.customerId = customerId;
    }

    public String getArticle() {
        return article;
    }

    public Timestamp getAcceptanceTime() {
        return acceptanceTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
