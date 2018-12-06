package com.hanki.hanki.Main;

public class ShopLogo {
    private String shopCode;
    private String result;
    private String description;
    private String UUID;
    private String textImgId;

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getTextImgId() {
        return textImgId;
    }

    public void setTextImgId(String textImgId) {
        this.textImgId = textImgId;
    }

    @Override
    public String toString() {
        return "ShopLogo{" +
                "shopCode='" + shopCode + '\'' +
                ", result='" + result + '\'' +
                ", description='" + description + '\'' +
                ", UUID='" + UUID + '\'' +
                ", textImgId='" + textImgId + '\'' +
                '}';
    }
}
