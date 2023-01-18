
package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class ValuesPOJO {

    @SerializedName("values")
    private List<Value> mValues;

    public List<Value> getValues() {
        return mValues;
    }

    public void setValues(List<Value> values) {
        mValues = values;
    }

}
