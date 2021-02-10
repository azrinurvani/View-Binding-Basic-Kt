package com.mobile.azrinurvani.viewbindingbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.mobile.azrinurvani.viewbindingbasic.databinding.ActivityMainBinding
import com.mobile.azrinurvani.viewbindingbasicjava.RecyclerViewAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        setupRecyclerView()

        initMovieList()
    }

    private fun setupRecyclerView() {
        recyclerViewAdapter = RecyclerViewAdapter()
        val dividerItemDecoration = DividerItemDecoration(activityMainBinding.rvMain.context, DividerItemDecoration.VERTICAL)
        activityMainBinding.rvMain.adapter = recyclerViewAdapter
        activityMainBinding.rvMain.addItemDecoration(dividerItemDecoration)
    }

    private fun initMovieList(){
        val movieList: MutableList<String> = ArrayList()

        movieList.add("Avengers")
        movieList.add("Captain America")
        movieList.add("Iron Man")
        movieList.add("Hulk")
        movieList.add("Doctor Strange")
        movieList.add("Spiderman")
        movieList.add("Ant Man")
        movieList.add("Black Widow")
        recyclerViewAdapter.updateMovie(movieList)

    }
}