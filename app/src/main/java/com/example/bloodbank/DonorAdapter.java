package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.MyViewHolder> {

    Context context;
    ArrayList<DonorUsers> usersArrayList;

    public DonorAdapter(Context context, ArrayList<DonorUsers> usersArrayList) {
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public DonorAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_donor_list,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  DonorAdapter.MyViewHolder holder, int position) {

        DonorUsers user = usersArrayList.get(position);

        holder.name.setText(user.name);
        holder.location.setText(user.location);
        holder.email.setText(user.email);
        holder.blood_grp.setText(user.blood_grp);
        holder.mobile.setText(String.valueOf(user.mobile));


    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,location,blood_grp,email,mobile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvdonor_Name);
            location = itemView.findViewById(R.id.tvdonor_Location);
            blood_grp = itemView.findViewById(R.id.tvdonor_BloodGrp);
            email = itemView.findViewById(R.id.tvdonor_Email);
            mobile = itemView.findViewById(R.id.tvdonor_Mobile);


        }
    }
}
