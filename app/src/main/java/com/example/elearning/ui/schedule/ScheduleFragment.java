package com.example.elearning.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elearning.R;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {
    private ScheduleViewModel scheduleViewModel;
    private Course[] course = {new Course("操作系统","张迪"), new Course("数据库系统","冯凤娟" ), new Course("移动应用开发技术","曾立刚" )};
    private List<Course> courseList = new ArrayList<>();
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scheduleViewModel =
                ViewModelProviders.of(this).get(ScheduleViewModel.class);
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        recyclerView = view.findViewById(R.id.schedule_view);
        initView();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCourse();
    }

    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);//参数：context，列数
        recyclerView.setLayoutManager(layoutManager);
        CourseAdapter courseAdapter = new CourseAdapter(courseList);
        recyclerView.setAdapter(courseAdapter);
    }

    private void initCourse() {
        courseList.clear();
        for (int i = 0; i < course.length; i++) {
            courseList.add(course[i]);
        }
    }
}