package com.example.actproperty.department.accounting;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actproperty.R;
import com.example.actproperty.passport.Passport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deliver extends AppCompatActivity {
    ArrayList<Passport>listUser;
    LinearLayout rowChosen, rowLock;
    EditText commentDeliver;
    Button btnLock;
    String codeStore, comment;
    TextView item1Chosen, item2Chosen,item3Chosen,item4Chosen,item5Chosen, item1Value,
            item2Value,item3Value,item4Value,item5Value;
    LinearLayout row1Chosen,row2Chosen,row3Chosen,row4Chosen,row5Chosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        codeStore = "";
        comment = "";
        getUser();
        getStoreDeliver();
        item1Chosen = (TextView)findViewById(R.id.item1Chosen);
        item2Chosen = (TextView)findViewById(R.id.item2Chosen);
        item3Chosen = (TextView)findViewById(R.id.item3Chosen);
        item4Chosen = (TextView)findViewById(R.id.item4Chosen);
        item5Chosen = (TextView)findViewById(R.id.item5Chosen);
        item1Value = (TextView)findViewById(R.id.valueItem1);
        item2Value = (TextView)findViewById(R.id.valueItem2);
        item3Value = (TextView)findViewById(R.id.valueItem3);
        item4Value = (TextView)findViewById(R.id.valueItem4);
        item5Value = (TextView)findViewById(R.id.valueItem5);
        row1Chosen = (LinearLayout)findViewById(R.id.row1Chosen);
        row2Chosen = (LinearLayout)findViewById(R.id.row2Chosen);
        row3Chosen = (LinearLayout)findViewById(R.id.row3Chosen);
        row4Chosen = (LinearLayout)findViewById(R.id.row4Chosen);
        row5Chosen = (LinearLayout)findViewById(R.id.row5Chosen);
        commentDeliver = (EditText)findViewById(R.id.commentDeliver);
        rowLock = (LinearLayout)findViewById(R.id.rowLock);
        rowChosen = (LinearLayout)findViewById(R.id.rowChosen);
        btnLock = (Button)findViewById(R.id.btnLock);
        btnLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Deliver();
                rowLock.setVisibility(View.GONE);
                rowChosen.setVisibility(View.VISIBLE);
                comment = commentDeliver.getText().toString();

            }
        });
    }
    private void getStoreDeliver(){
        final Spinner spinnerToStore = (Spinner)findViewById(R.id.spinnerToStore);
        List<String> listToStore = new ArrayList<>();
        listToStore.add("Mã kho nhận");
        listToStore.add("BTE");
        listToStore.add("LAN");
        listToStore.add("TVH");
        listToStore.add("KGG");
        listToStore.add("BDG");
        listToStore.add("DNI");
        listToStore.add("HCM_BTN");
        listToStore.add("HCM_BCH");
        listToStore.add("HCM_CCI");
        listToStore.add("HCM_TCH");
        listToStore.add("HCM_GDH");
        /*======================= CHOICE STORE==========================*/
        ArrayAdapter<String> adapterToStore = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,listToStore);
        adapterToStore.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerToStore.setAdapter(adapterToStore);
        spinnerToStore.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                codeStore = spinnerToStore.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void Deliver(){
        List<String> listItem = new ArrayList<>();
        listItem.add("Vật tư xuất kho");
        listItem.add("Cáp quang treo 6Fo");
        listItem.add("Cáp quang treo 12Fo");
        listItem.add("Cáp quang treo 24Fo");
        listItem.add("ODF 6fo");
        listItem.add("ODF 12fo");
        listItem.add("ODF 24fo");
        listItem.add("Măng xông 6fo");
        listItem.add("Măng xông 12fo");
        listItem.add("Măng xông 24fo");
        listItem.add("Buloong ti 300");
        listItem.add("Buloong ti 400");
        listItem.add("Kẹp cáp");
        listItem.add("Dây nhảy Sc/LC 5m");
        listItem.add("Dây nhảy Sc/LC 10m");
        /*======================= GET ITEM==========================*/
        final Spinner spinnerItem1 = (Spinner)findViewById(R.id.spinnerItem1);
        final EditText item1 = (EditText)findViewById(R.id.item1);
        final Button btnAddItem = (Button)findViewById(R.id.btnAddItem);
        ArrayAdapter<String> adapterItem1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,listItem);
        adapterItem1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinnerItem1.setAdapter(adapterItem1);
        spinnerItem1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextSize(10);
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLUE);
                btnAddItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(item1Value.getText().toString().trim().length()>0){
                            Toast.makeText(Deliver.this, "Vui lòng nhập số lượng "+
                                    spinnerItem1.getSelectedItem().toString()+" xuất.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Deliver.this, "AAA"+row1Chosen.getVisibility(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button btnDeliver = (Button)findViewById(R.id.btnDeliver);
        btnDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getUser(){
        Intent intent = getIntent();
        listUser = (ArrayList<Passport>) intent.getSerializableExtra("Account");
    }
}