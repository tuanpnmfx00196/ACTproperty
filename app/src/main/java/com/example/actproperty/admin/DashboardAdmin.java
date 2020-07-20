package com.example.actproperty.admin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.actproperty.R;
import com.example.actproperty.department.accounting.AccountingDepartment;
import com.example.actproperty.passport.Passport;

import java.util.ArrayList;

public class DashboardAdmin extends AppCompatActivity {
    ArrayList<Passport>listUser;
    Button btnDirectors, btnAccounting, btnProperty, btnNOC, btnEngineering;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        listUser = new ArrayList<>();
        getUser();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hello " + listUser.get(0).getUser());
        Map();
        btnAccounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardAdmin.this, AccountingDepartment.class);
                intent.putExtra("Account",listUser);
                startActivity(intent);
            }
        });
        btnNOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actJSC:
                Toast.makeText(this, "ACT JSC", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgUser:
                Toast.makeText(this, "Image User", Toast.LENGTH_SHORT).show();
                break;
            case R.id.changePassword:

                break;
            case R.id.signout:
                Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void getUser() {
        Intent intent = getIntent();
        listUser = (ArrayList<Passport>) intent.getSerializableExtra("Account");
    }
    private void Map(){
        btnDirectors = (Button)findViewById(R.id.btnDirectors);
        btnAccounting = (Button)findViewById(R.id.btnAccounting);
        btnProperty = (Button)findViewById(R.id.btnProperty);
        btnNOC = (Button)findViewById(R.id.btnNOC);
        btnEngineering = (Button)findViewById(R.id.btnEngineering);
    }

}