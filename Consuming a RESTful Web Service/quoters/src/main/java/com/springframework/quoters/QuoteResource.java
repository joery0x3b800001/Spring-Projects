package com.springframework.quoters;

import java.util.Objects;

public class QuoteResource {

    private String type;
    private Quote value;
    
    public QuoteResource(Quote value, String type) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Quote getValue() {
        return value;
    }

    public void setValue(Quote value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (!(obj instanceof QuoteResource))
            return false;
        
        QuoteResource that = (QuoteResource) obj;
        return Objects.equals(type, that.type) && Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return "QuoteResource{" + "type='" + type + '\'' + ", value=" + value + '}';
    }
    
}
