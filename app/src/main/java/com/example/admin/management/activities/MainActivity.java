package com.example.admin.management.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.admin.management.ApprovalsAdapter;
import com.example.admin.management.ApprovalsModel;
import com.example.admin.management.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout id_layoutMainfunction, id_layoutApprovals;
    Button bt_approvals, bt_transactions, bt_execution, bt_financeInfo;
    private RecyclerView recyclerView;
    ApprovalsAdapter adapter;
    ArrayList<ApprovalsModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        id_layoutMainfunction = (RelativeLayout) findViewById(R.id.id_layoutMainfunction);
        id_layoutApprovals = (RelativeLayout) findViewById(R.id.id_layoutApprovals);
        bt_approvals = (Button) findViewById(R.id.bt_approvals);
        bt_transactions = (Button) findViewById(R.id.bt_transactions);
        bt_execution = (Button) findViewById(R.id.bt_execution);
        bt_financeInfo = (Button) findViewById(R.id.bt_financeInfo);
        bt_approvals.setOnClickListener(this);
        bt_transactions.setOnClickListener(this);
        bt_execution.setOnClickListener(this);
        bt_financeInfo.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new ApprovalsAdapter(dataLoad(), MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public List<ApprovalsModel> dataLoad() {
        String[] approvalName = {"Gokul", "Balajisir", "MKsir", "karthick", "Sai", "Senthil", "selva", "Bala", "Raju", "Sathish"};
        String callCentername = "callcentre", vendorName = "vendor", po_id = "Po_";
        double amt = 0;
        for (int i = 0; i < approvalName.length; i++) {
            ApprovalsModel approvalsModel = new ApprovalsModel();
            approvalsModel.setAmount(amt + (i + 25));
            approvalsModel.setApprovalName(approvalName[i]);
            approvalsModel.setCallCentername(callCentername + i);
            approvalsModel.setVendorName(vendorName + i);
            approvalsModel.setPoId(po_id + i);

            dataList.add(approvalsModel);

        }
        return dataList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_approvals:
                id_layoutMainfunction.setVisibility(View.GONE);
                id_layoutApprovals.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_transactions:
                Intent i = new Intent(MainActivity.this, Transaction.class);
                startActivity(i);
                break;

        }
    }


}
