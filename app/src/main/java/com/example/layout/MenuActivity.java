package com.example.layout;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Toolbar setup (IMPORTANT for options menu)
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize views
        textView = findViewById(R.id.textView);
        btnPopup = findViewById(R.id.btnPopup);

        // Register context menu
        registerForContextMenu(textView);

        // Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(MenuActivity.this, btnPopup);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(MenuActivity.this,
                        "Popup: " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();
        });
    }

    // ================= OPTIONS MENU (3 dots) =================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_add) {
            Toast.makeText(this, "Add selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menu_delete) {
            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menu_exit) {
            finish();
        }

        return true;
    }

    // ================= CONTEXT MENU (LONG PRESS) =================
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.context_edit) {
            Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.context_share) {
            Toast.makeText(this, "Share selected", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}