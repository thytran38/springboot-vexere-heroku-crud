package com.vexere.webservice.models.promos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="promos")
public class Promo {
    public int promoId;
    public String promoContent;
    public int busBrand;
    public int promoAmount;
    public long promoStart;
    public long promoEnd;

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public String getPromoContent() {
        return promoContent;
    }

    public void setPromoContent(String promoContent) {
        this.promoContent = promoContent;
    }

    public int getBusBrand() {
        return busBrand;
    }

    public void setBusBrand(int busBrand) {
        this.busBrand = busBrand;
    }

    public int getPromoAmount() {
        return promoAmount;
    }

    public void setPromoAmount(int promoAmount) {
        this.promoAmount = promoAmount;
    }

    public long getPromoStart() {
        return promoStart;
    }

    public void setPromoStart(long promoStart) {
        this.promoStart = promoStart;
    }

    public long getPromoEnd() {
        return promoEnd;
    }

    public void setPromoEnd(long promoEnd) {
        this.promoEnd = promoEnd;
    }
}
