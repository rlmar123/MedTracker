package com.example.medapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DocInfoActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_info);

        ImageView three_bars = findViewById(R.id.three_bars);

        three_bars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(DocInfoActivity.this, "TITLE", Toast.LENGTH_LONG).show();
               /* Intent intent = new Intent(DocInfoActivity.this, TitleActivity.class);
                startActivity(intent);*/
                showPopup(v);

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
                Toast.makeText(this, "from doc info", Toast.LENGTH_SHORT).show();
             //   Intent intent = new Intent(TitleActivity.this, DocInfoActivity.class);
           //     startActivity(intent);

                return true;

            case R.id.Refill:
                Toast.makeText(this, "from the doctor", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        } // end switch
    }
}