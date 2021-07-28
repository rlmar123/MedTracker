package com.example.medapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class NextFragment extends Fragment {

    public NextFragment()
    {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_next_fragment, container, false);
    }
} // end Fragment