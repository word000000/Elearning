package com.example.elearning.ui.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elearning.R;

import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    private Context context;
    private List<Course> myCourseList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView CourseTeacher;
        TextView CourseName;

        ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            CourseTeacher = itemView.findViewById(R.id.course_teacher);
            CourseName = itemView.findViewById(R.id.course_name);
        }
    }

    public CourseAdapter(List<Course> CourseList) {
        myCourseList = CourseList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Course course = myCourseList.get(position);
        holder.CourseName.setText(course.getName());
        holder.CourseTeacher.setText(course.getTeacher());
    }

    @Override
    public int getItemCount() {
        return myCourseList.size();
    }

}
