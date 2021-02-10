package com.mobile.azrinurvani.viewbindingbasicjava

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mobile.azrinurvani.viewbindingbasic.databinding.RecyclerRowBinding
import java.util.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var movieList: List<String> = ArrayList()
    fun updateMovie(movieList: List<String>) {
        this.movieList = movieList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding: RecyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(movieList[position])
    }

    override fun getItemCount(): Int {
        return if (movieList.isNotEmpty()) {
            movieList.size
        } else {
            0
        }
    }

    inner class ViewHolder(recyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root) {
        /*  public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }*/
        private var recyclerRowBinding: RecyclerRowBinding = recyclerRowBinding
        fun bindView(movieName: String) {
            recyclerRowBinding.txtMovieTitle.text = movieName
        }

        init {
            this.recyclerRowBinding.txtMovieTitle.setOnClickListener{ view ->
                Log.d("ViewHolder", "adapter position : $adapterPosition")
                Toast.makeText(
                    view.context,
                    "adapter position :$adapterPosition",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}