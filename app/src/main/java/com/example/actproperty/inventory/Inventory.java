package com.example.actproperty.inventory;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.actproperty.Management;
import com.example.actproperty.R;
import com.example.actproperty.passport.Passport;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends AppCompatActivity {
    ArrayList<Passport> listUser;
    String storecode;
    ArrayList<MaterialsInventory> listInventory;
    ArrayList<TempDeliver>listTempDeliver;
    ArrayList<TempDeliver>listTempDeliverPermission;
    LinearLayout deliver;
    TextView makho,inventory6fo, inventory12fo, inventory24fo, inventoryodf6, inventoryodf12,
                inventoryodf24, inventorymx6, inventorymx12, inventorymx24, inventorybl300,
                inventorybl400, inventoryclamp, inventorysclc5, inventorysclc10;
    LinearLayout row6fo_inventory, row12fo_inventory, row24fo_inventory, rowodf6fo_inventory,
            rowodf12fo_inventory, rowodf24fo_inventory, rowmx6fo_inventory, rowmx12fo_inventory,
            rowmx24fo_inventory, rowbl300_inventory, rowbl400_inventory, rowclamp_inventory, rowsclc5_inventory,
    rowsclc10_inventory;
    ListView listDeliver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        listUser = new ArrayList<>();
        listInventory = new ArrayList<>();
        listTempDeliver = new ArrayList<>();
        listTempDeliverPermission = new ArrayList<>();
        getTempDeliver("https://sqlandroid2812.000webhostapp.com/gettempdeliver.php");
        storecode="";
        getAccount();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hello "+listUser.get(0).getUser());
        Map();
        getInventory("https://sqlandroid2812.000webhostapp.com/getinventory.php");
       }
    public void getAccount(){
        Intent intent = getIntent();
        storecode = intent.getStringExtra("Storecode");
        listUser = (ArrayList<Passport>) intent.getSerializableExtra("Account");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inventory,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actJSC:
                Toast.makeText(this, "ACT JSC", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgUser:
                Toast.makeText(this, "Image User", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1_inventory:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2_inventory:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void ShowInventory(){
        for(int i=0;i<listInventory.size();i++){
            if(listInventory.get(i).getStoreCode().toString().equals(storecode)){
                if(listInventory.get(i).getHanging6fo()!=0){
                    row6fo_inventory.setVisibility(View.VISIBLE);
                    inventory6fo.setText(listInventory.get(i).getHanging6fo()+"");
                }
                if(listInventory.get(i).getHanging12fo()!=0){
                    row12fo_inventory.setVisibility(View.VISIBLE);
                    inventory12fo.setText(listInventory.get(i).getHanging12fo()+"");
                }
                if(listInventory.get(i).getHanging24fo()!=0){
                    row24fo_inventory.setVisibility(View.VISIBLE);
                    inventory24fo.setText(listInventory.get(i).getHanging24fo()+"");
                }
                if(listInventory.get(i).getOdf6fo()!=0){
                    rowodf6fo_inventory.setVisibility(View.VISIBLE);
                    inventoryodf6.setText(listInventory.get(i).getOdf6fo()+"");
                }
                if(listInventory.get(i).getOdf12fo()!=0){
                    rowodf12fo_inventory.setVisibility(View.VISIBLE);
                    inventoryodf12.setText(listInventory.get(i).getOdf12fo()+"");
                }
                if(listInventory.get(i).getOdf24fo()!=0){
                    rowodf24fo_inventory.setVisibility(View.VISIBLE);
                    inventoryodf24.setText(listInventory.get(i).getOdf24fo()+"");
                }
                if(listInventory.get(i).getClosure6fo()!=0){
                    rowmx6fo_inventory.setVisibility(View.VISIBLE);
                    inventorymx6.setText(listInventory.get(i).getClosure6fo()+"");
                }
                if(listInventory.get(i).getClosure12fo()!=0){
                    rowmx12fo_inventory.setVisibility(View.VISIBLE);
                    inventorymx12.setText(listInventory.get(i).getClosure12fo()+"");
                }
                if(listInventory.get(i).getClosure24fo()!=0){
                    rowmx24fo_inventory.setVisibility(View.VISIBLE);
                    inventorymx24.setText(listInventory.get(i).getClosure24fo()+"");
                }
                if(listInventory.get(i).getBl300()!=0){
                    rowbl300_inventory.setVisibility(View.VISIBLE);
                    inventorybl300.setText(listInventory.get(i).getBl300()+"");
                }
                if(listInventory.get(i).getBl400()!=0){
                    rowbl400_inventory.setVisibility(View.VISIBLE);
                    inventorybl400.setText(listInventory.get(i).getBl400()+"");
                }
                if(listInventory.get(i).getClamp()!=0){
                    rowclamp_inventory.setVisibility(View.VISIBLE);
                    inventoryclamp.setText(listInventory.get(i).getClamp()+"");
                }
                if(listInventory.get(i).getSc_lc5()!=0){
                    rowsclc5_inventory.setVisibility(View.VISIBLE);
                    inventorysclc5.setText(listInventory.get(i).getSc_lc5()+"");
                }
                if(listInventory.get(i).getSc_lc10()!=0){
                    rowsclc10_inventory.setVisibility(View.VISIBLE);
                    inventorysclc10.setText(listInventory.get(i).getSc_lc10()+"");
                }
            }
        }

    }
    private void Map(){
        makho = (TextView)findViewById(R.id.makho);
        inventory6fo = (TextView)findViewById(R.id.inventory6fo);
        inventory12fo = (TextView)findViewById(R.id.inventory12fo);
        inventory24fo = (TextView)findViewById(R.id.inventory24fo);
        inventoryodf6 = (TextView)findViewById(R.id.inventoryodf6fo);
        inventoryodf12 = (TextView)findViewById(R.id.inventoryodf12fo);
        inventoryodf24 = (TextView)findViewById(R.id.inventoryodf24fo);
        inventorymx6 = (TextView)findViewById(R.id.inventorymx6fo);
        inventorymx12 = (TextView)findViewById(R.id.inventorymx12fo);
        inventorymx24 = (TextView)findViewById(R.id.inventorymx24fo);
        inventorybl300 = (TextView)findViewById(R.id.inventorybl300);
        inventorybl400 = (TextView)findViewById(R.id.inventorybl400);
        inventoryclamp = (TextView)findViewById(R.id.inventoryclamp);
        inventorysclc5 = (TextView)findViewById(R.id.inventorysclc5);
        inventorysclc10 = (TextView)findViewById(R.id.inventorysclc10);

        row6fo_inventory = (LinearLayout)findViewById(R.id.row6fo_inventory);
        row12fo_inventory = (LinearLayout)findViewById(R.id.row12fo_inventory);
        row24fo_inventory = (LinearLayout)findViewById(R.id.row24fo_inventory);
        rowodf6fo_inventory = (LinearLayout)findViewById(R.id.rowodf6fo_inventory);
        rowodf12fo_inventory = (LinearLayout)findViewById(R.id.rowodf12fo_inventory);
        rowodf24fo_inventory = (LinearLayout)findViewById(R.id.rowodf24fo_inventory);
        rowmx6fo_inventory = (LinearLayout)findViewById(R.id.rowmx6fo_inventory);
        rowmx12fo_inventory = (LinearLayout)findViewById(R.id.rowmx12fo_inventory);
        rowmx24fo_inventory = (LinearLayout)findViewById(R.id.rowmx24fo_inventory);
        rowbl300_inventory = (LinearLayout)findViewById(R.id.rowbl300_inventory);
        rowbl400_inventory = (LinearLayout)findViewById(R.id.rowbl400_inventory);
        rowclamp_inventory = (LinearLayout)findViewById(R.id.rowclamp_inventory);
        rowsclc5_inventory = (LinearLayout)findViewById(R.id.rowsclc5_inventory);
        rowsclc10_inventory = (LinearLayout)findViewById(R.id.rowsclc10_inventory);
    }
    public void getInventory(String url){
        listInventory = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length(); i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);
                        listInventory.add(new MaterialsInventory(
                                jsonObject.getInt("ID"),
                                jsonObject.getString("Storecode"),
                                jsonObject.getInt("Hanging6fo"),
                                jsonObject.getInt("Hanging12fo"),
                                jsonObject.getInt("Hanging24fo"),
                                jsonObject.getInt("Odf6fo"),
                                jsonObject.getInt("Odf12fo"),
                                jsonObject.getInt("Odf24fo"),
                                jsonObject.getInt("Closure6fo"),
                                jsonObject.getInt("Closure12fo"),
                                jsonObject.getInt("Closure24fo"),
                                jsonObject.getInt("Buloongti300"),
                                jsonObject.getInt("Buloongti400"),
                                jsonObject.getInt("Clamp"),
                                jsonObject.getInt("Sc_lc5"),
                                jsonObject.getInt("Sc_lc10")
                        ));

                    }catch (Exception e){
                        Toast.makeText(Inventory.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                ShowInventory();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Inventory.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    /*======================== GET TEMP DELIVER ================================*/
    public void getTempDeliver(String url){
        listTempDeliver = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length();i++){
                    try{
                        JSONObject jsonObject = response.getJSONObject(i);
                        listTempDeliver.add(new TempDeliver(
                                jsonObject.getInt("IDdeliver"),
                                jsonObject.getString("Storecodedeliver"),
                                jsonObject.getInt("Hanging6fodeliver"),
                                jsonObject.getInt("Hanging12fodeliver"),
                                jsonObject.getInt("Hanging24fodeliver"),
                                jsonObject.getInt("Odf6fodeliver"),
                                jsonObject.getInt("Odf12fodeliver"),
                                jsonObject.getInt("Odf24fodeliver"),
                                jsonObject.getInt("Closure6fodeliver"),
                                jsonObject.getInt("Closure12fodeliver"),
                                jsonObject.getInt("Closure24fodeliver"),
                                jsonObject.getInt("Buloongti300deliver"),
                                jsonObject.getInt("Buloongti400deliver"),
                                jsonObject.getInt("Clampdeliver"),
                                jsonObject.getInt("Sc_lc5deliver"),
                                jsonObject.getInt("Sc_lc10deliver"),
                                jsonObject.getString("Userdeliver"),
                                jsonObject.getString("Timedeliver"),
                                jsonObject.getString("Commentdeliver"),
                                jsonObject.getInt("Flag")
                        ));
                    }catch(Exception e){
                        Toast.makeText(Inventory.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(Inventory.this, listTempDeliver.size()+"", Toast.LENGTH_SHORT).show();
                showTemp();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Inventory.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
    private void showTemp(){
        if(listUser.get(0).getAdmin()==1){
            for(int i=0;i<listTempDeliver.size();i++){
                if(listTempDeliver.get(i).getFlag()==1){
                    listTempDeliverPermission.add(listTempDeliver.get(i));
                }
            }

        } else {
            if (listUser.get(0).getBdg() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("BDG")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            if (listUser.get(0).getKgg() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("KGG")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            if (listUser.get(0).getBte() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("BTE")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            if (listUser.get(0).getTvh() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("TVH")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            if (listUser.get(0).getLan() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("LAN")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            if (listUser.get(0).getDni() == 1) {
                for (int i = 0; i < listTempDeliver.size(); i++) {
                    if (listTempDeliver.get(i).getStoreCode().equals("DNI")&&listTempDeliver.get(i).getFlag()==1) {
                        listTempDeliverPermission.add(listTempDeliver.get(i));
                    }
                }
            }
            /*... Add more code store*/
        }
        listDeliver = (ListView) findViewById(R.id.listDeliver);
        deliver = (LinearLayout)findViewById(R.id.deliver);
        if(listTempDeliverPermission.size()==0){
            deliver.setVisibility(View.GONE);
        } else {
            listDeliver.setVisibility(View.VISIBLE);
            TempDeliverAdapter deliverAdapter = new TempDeliverAdapter(listTempDeliverPermission);
            listDeliver.setAdapter(deliverAdapter);
        }
    }
}