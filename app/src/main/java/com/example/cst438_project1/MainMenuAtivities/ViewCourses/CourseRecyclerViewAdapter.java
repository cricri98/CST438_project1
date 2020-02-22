package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.ViewAssignmentActivity;
import com.example.cst438_project1.R;

import java.util.ArrayList;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "CourseRecyclerViewAdapt";

    private ArrayList<String> mCourseNames;
    private ArrayList<String> mCourseDesc;
    private ArrayList<String> mCourseGrades;
    private int mUserId;
    private Context mContext;

    public CourseRecyclerViewAdapter(ArrayList<String> courseNames, ArrayList<String> courseDesc, ArrayList<String> courseGrades, int userId, Context context) {
        mCourseNames = courseNames;
        mCourseDesc = courseDesc;
        mCourseGrades = courseGrades;
        mUserId = userId;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_courseitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        holder.itemName.setText(mCourseNames.get(position));
        holder.itemDesc.setText(mCourseDesc.get(position));
        holder.itemGrade.setText(mCourseGrades.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCourse(view, position);
            }
        });
    }

    void viewCourse(View view, int position){
        //open the viewAssignmentActivity
        Intent intent = new Intent (view.getContext(), ViewAssignmentActivity.class);
        //pass on the course name
        intent.putExtra("courseName", mCourseNames.get(position));
        intent.putExtra("userId", mUserId);
        view.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return mCourseNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemDesc;
        TextView itemGrade;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            itemDesc = itemView.findViewById(R.id.itemDesc);
            itemGrade = itemView.findViewById(R.id.itemGrade);
            parentLayout = itemView.findViewById(R.id.itemCardLayout);
        }
    }
}
