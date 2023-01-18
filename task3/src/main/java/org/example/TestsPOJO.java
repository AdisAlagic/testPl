
package org.example;

import java.util.List;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TestsPOJO {

    @SerializedName("tests")
    private List<Test> mTests;

    public List<Test> getTests() {
        return mTests;
    }

    public void setTests(List<Test> tests) {
        mTests = tests;
    }

    public void findAndSet(Value value){
        if (mTests != null){
            mTests.forEach(test -> {
                test.findAndSet(value);
            });
        }
    }
}
