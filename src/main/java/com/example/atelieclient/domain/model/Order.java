package com.example.atelieclient.domain.model;

import java.security.Timestamp;

public class Order extends Entity {
    private String article;
    private Timestamp acceptanceTime;

    public Order(String article, Timestamp acceptanceTime) {
        this.article = article;
        this.acceptanceTime = acceptanceTime;
    }

    public String getArticle() {
        return article;
    }

    public Timestamp getAcceptanceTime() {
        return acceptanceTime;
    }
}
