package com.bluesky.classmate.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bluesky.classmate.bean.Sence;

/**
 * @author BlueSky
 * @date 2022/4/11
 * Description:
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<Sence> sence;

    public MainViewModel() {
        super();
        if (sence==null){
            sence=new MutableLiveData<Sence>();
        }
    }

    public MutableLiveData<Sence> getSence() {
        return sence;
    }
}
