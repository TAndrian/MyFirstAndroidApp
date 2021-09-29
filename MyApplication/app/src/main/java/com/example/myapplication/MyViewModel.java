package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    private MutableLiveData<List<String>> inputs = new MutableLiveData<List<String>>();
    public List<String> getInputs() {


        return inputs.getValue();
    }

    public void loadInputs(List<String> inputs) {
        // Do an asynchronous operation to fetch users.
        this.inputs.setValue(inputs);
    }
}
