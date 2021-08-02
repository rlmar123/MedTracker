package com.example.medapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medapp.UI.RecyclerAdapt;
import com.example.medapp.model.DocInfo;

import java.util.ArrayList;
import java.util.Calendar;

public class NextFragment extends Fragment {

    public NextFragment()
    {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.activity_next_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.next_recycler);

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