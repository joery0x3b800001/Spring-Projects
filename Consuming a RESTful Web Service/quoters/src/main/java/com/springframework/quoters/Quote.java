package com.springframework.quoters;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Quote {

    @Id
    @GeneratedValue
    private Long id;
    private String quote;

    public Quote(String quote) {
        this.quote = quote;
    }

    protected Quote() {
    }

    public Long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote{" + "id=" + id + ", quote='" + quote + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quote);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Quote))
            return false;

        Quote quote1 = (Quote) obj;
        return Objects.equals(id, quote1.id) && Objects.equals(quote, quote1.quote);
    }

}
