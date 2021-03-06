package com.example.medapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.medapp.UI.RecyclerAdapt;
import com.example.medapp.model.DocInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class DocInfoActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

    BottomNavigationView test_bar;
    FrameLayout frameLayout;

    private RecyclerView recycler_view = null;
    private RecyclerAdapt recycler_adapter= null;


    //data storage
    private List<DocInfo> our_item_list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_info);

        //connect to activity_my_list.xml widget
        recycler_view = findViewById(R.id.test_recycler);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        our_item_list = new ArrayList<>();

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
        recycler_adapter = new RecyclerAdapt(this, our_item_list);
        recycler_view.setAdapter(recycler_adapter);


        //keeps data up to date
        recycler_adapter.notifyDataSetChanged();

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                Toast.makeText(DocInfoActivity.this, "TITLE" , Toast.LENGTH_LONG).show();

            }
        });

        test_bar = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.main_frame);
        ImageView three_bars = findViewById(R.id.three_bars);

        test_bar.setOnNavigationItemSelectedListener(navListener);
        /*test_bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {*/
           /* @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.doctor_info:
                        test_bar.setBackgroundResource(R.color.light_blue_600);
                        setFragment(new TestFragment());
                        return true;

                    case R.id.home_icon:
                        test_bar.setBackgroundResource(R.color.light_blue_900);
                        return true;

                    case R.id.refill_icon:
                        test_bar.setBackgroundResource(R.color.light_blue_A400);
                        return true;

                }
                return false;
            }
        });*/

        three_bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(DocInfoActivity.this, "TITLE", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(DocInfoActivity.this, TitleActivity.class);
                startActivity(intent);
                showPopup(v);

            }
        });
    }

    // fragments change here
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item)
                {
                    Fragment selectedFragment = null;

                    switch (item.getItemId())
                    {
                        case R.id.home_icon:
                            selectedFragment = new TestFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                                    selectedFragment).commit();
                            break;

                        case R.id.refill_icon:
                            test_bar.setBackgroundResource(R.color.light_blue_600);
                            selectedFragment = new NextFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                                    selectedFragment).commit();
                            break;

                        case R.id.doctor_info:
                            test_bar.setBackgroundResource(R.color.black);
                            break;
                    }

                    return true;
                }
            };

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

    // this method displays the pop up menu from the top
    public void showPopup(View v)
    {
        PopupMenu the_pop = new PopupMenu(this, v);
        the_pop.setOnMenuItemClickListener(this);
        the_pop.inflate(R.menu.nav_menu);
        the_pop.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
        switch (item.getItemId())
        {
          /*  case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;*/
            case R.id.Doc_Info:
                Toast.makeText(this, "from doc info", Toast.LENGTH_SHORT).show();
            /*    Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"This is from the med app");
                intent.putExtra(Intent.EXTRA_SUBJECT,"This is from the med app");
                startActivity(intent);*/
                return true;

            case R.id.Refill:
                Toast.makeText(this, "from the doctor", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        } // end switch
    }
}