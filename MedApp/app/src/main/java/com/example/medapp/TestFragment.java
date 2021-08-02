package com.example.medapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import 	java.util.Calendar;
import java.util.TimeZone;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medapp.UI.RecyclerAdapt;
import com.example.medapp.model.DocInfo;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class TestFragment extends Fragment
{



    public TestFragment()
    {

    }




 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.test_recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

       ArrayList<DocInfo> our_item_list = new ArrayList<>();

        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));

        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));
        our_item_list.add(new DocInfo("Jeff", "jim", "123 main st", "brpnx, ny", "9999999"));

        //setup recycler_adapter
        RecyclerAdapt recycler_adapter = new RecyclerAdapt(getActivity(), our_item_list);
        recyclerView.setAdapter(recycler_adapter);


        //keeps data up to date
        recycler_adapter.notifyDataSetChanged();

        return view;
    }

} // end Fragment