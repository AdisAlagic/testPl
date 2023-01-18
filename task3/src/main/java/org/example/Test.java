
package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;


@SuppressWarnings("unused")
public class Test {

    @SerializedName("id")
    private Long mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("value")
    private String mValue;

    @SerializedName("values")
    private List<Test> mValues;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

    public List<Test> getValues() {
        return mValues;
    }

    public void setValues(List<Test> mValues) {
        this.mValues = mValues;
    }

    public void findAndSet(Value value){
        if (Objects.equals(mId, value.getId())){
            mValue = value.getValue();
        }else if (mValues != null) {
            mValues.forEach(test -> test.findAndSet(value));
        }
    }
}
