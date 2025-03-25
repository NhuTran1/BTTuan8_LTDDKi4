package com.example.myapplication

import android.app.FragmentBreadCrumbs.OnBreadCrumbClickListener

class CourseAdapter(
    var courses: MutableList<Course>,
    private val editClickListener: (Course)->Unit,
    private val deleteClickListener: (Course)->Unit
) : RecycleView.Adapter{


}