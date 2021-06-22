package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.MyViewHolder> {

    Context context;
    ArrayList<PatientUsers> usersArrayList;

    public PatientAdapter(Context context, ArrayList<PatientUsers> usersArrayList) {
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public PatientAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_patient_list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  PatientAdapter.MyViewHolder holder, int position) {
        PatientUsers user = usersArrayList.get(position);

        holder.name.setText(user.name);
        holder.location.setText(user.location);
        holder.hospital.setText(user.hospital);
        holder.blood_grp.setText(user.blood_grp);
        holder.mobile.setText(String.valueOf(user.mobile));
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,location,blood_grp,hospital,mobile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvpatient_Name);
            location = itemView.findViewById(R.id.tvpatient_Location);
            blood_grp = itemView.findViewById(R.id.tvpatient_BloodGrp);
            hospital = itemView.findViewById(R.id.tvpatient_hospital);
            mobile = itemView.findViewById(R.id.tvpatient_Mobile);
        }
    }
}
