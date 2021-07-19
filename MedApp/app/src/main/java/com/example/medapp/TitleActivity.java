package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private TextView title_text;
    private TextView logo_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        
        AlphaAnimation myAnim = new AlphaAnimation(0.0f, 1.0f);
        // loading Animation from
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.spin_anim);

        myAnim.setDuration(1000);
        myAnim.setRepeatCount(Animation.INFINITE);
        myAnim.setRepeatMode(Animation.REVERSE);


       /* animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);*/

        title_text = findViewById(R.id.title_text);
        logo_text = findViewById(R.id.logo_text);


        title_text.startAnimation(myAnim);
        logo_text.startAnimation(animation);

        ImageView title = findViewById(R.id.three_bars);
        ImageView settind = findViewById(R.id.the_setting);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Toast.makeText(TitleActivity.this, "TITLE", Toast.LENGTH_LONG).show();
                showPopup(v);

            }
        });

        settind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TitleActivity.this, "settigss", Toast.LENGTH_LONG).show();
                showPopup(v);
          //      textView.setText("YEAH!!!!!!!!!!!");
            }
        });

    }


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
                Toast.makeText(this, "Doctor Info selected", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(TitleActivity.this, DocInfoActivity.class);
                startActivity(intent);

                return true;

            case R.id.Refill:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        } // end switch
    } // end onMenuItemClick


    public void openDocInfoActivity() {
        Intent intent = new Intent(this, DocInfoActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
