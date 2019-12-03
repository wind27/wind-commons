package com.wind.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * BaseObject
 *
 * @author qianchun
 * @date 2019/7/29
 **/
public class BaseObject implements Serializable{
    private static final long serialVersionUID = 2744190391613295958L;

    public BaseObject() {
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object, new String[0]);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[0]);
    }
}
