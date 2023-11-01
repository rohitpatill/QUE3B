package com.example.que3b;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private TextView selectedTextView; // To keep track of the selected TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register each TextView for a context menu
        registerForContextMenu(findViewById(R.id.mba));
        registerForContextMenu(findViewById(R.id.mca));
        registerForContextMenu(findViewById(R.id.engineering));
        registerForContextMenu(findViewById(R.id.bams));
        registerForContextMenu(findViewById(R.id.bhms));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
        selectedTextView = (TextView) v;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        int color = 0;

        if (id == R.id.menu_red) {
            color = Color.RED;
        } else if (id == R.id.menu_green) {
            color = Color.GREEN;
        } else if (id == R.id.menu_blue) {
            color = Color.BLUE;
        }

        setBackgroundColor(selectedTextView, color); // Set background color of the selected TextView
        return true;
    }

    private void setBackgroundColor(View view, int color) {
        view.setBackgroundColor(color);
    }
}
