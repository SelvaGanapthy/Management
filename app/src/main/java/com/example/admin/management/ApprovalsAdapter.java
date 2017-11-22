package com.example.admin.management;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Admin on 11/22/2017.
 */

public class ApprovalsAdapter extends RecyclerView.Adapter<ApprovalsAdapter.ViewHolder> {
    Context context;
    List<ApprovalsModel> data;
    View row;
    static AlertDialog alertDialog;

    public ApprovalsAdapter(List<ApprovalsModel> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ApprovalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvals_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final ApprovalsAdapter.ViewHolder holder, final int position) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        final ApprovalsModel approvalsmodel = data.get(position);
        holder.id_switch.setTag(position);
        holder.id_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    alert.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(context, "true", Toast.LENGTH_SHORT).show();
                            holder.id_switch.setChecked(true);
                        }
                    });
                    alert.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            holder.id_switch.setChecked(false);
                        }
                    });

                    alertDialog = alert.create();
                    alert.show();

                    holder.tab1_titletv.setVisibility(View.VISIBLE);
                    holder.tab1_titletv.setText(approvalsmodel.getApprovalName());
                } else
                    holder.tab1_titletv.setVisibility(View.GONE);

            }
        });
//        holder.id_switch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.tab1_titletv.setVisibility(View.VISIBLE);
//                holder.tab1_titletv.setText(data[position]);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab1_titletv;
        SwitchCompat id_switch;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            tab1_titletv = (TextView) itemView.findViewById(R.id.tab1_titletv);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            id_switch = (SwitchCompat) itemView.findViewById(R.id.id_switch);
        }
    }
}
