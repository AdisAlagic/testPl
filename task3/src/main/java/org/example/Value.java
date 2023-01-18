
package org.example;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Value {

    @SerializedName("id")
    private Long mId;
    @SerializedName("value")
    private String mValue;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
