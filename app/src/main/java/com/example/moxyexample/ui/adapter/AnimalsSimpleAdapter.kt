package com.example.moxyexample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moxyexample.R
import com.example.moxyexample.model.Animal

class AnimalsSimpleAdapter(
    private val data: List<Animal>,
    private val onClick: (Animal) -> Unit
): RecyclerView.Adapter<AnimalsSimpleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, private val onClick: (Animal) -> Unit): RecyclerView.ViewHolder(itemView) {
        lateinit var currentAnimal: Animal
        val tvAnimalName: TextView = itemView.findViewById(R.id.tvAnimalName)

        init {
            itemView.setOnClickListener {
                onClick(currentAnimal)
            }
        }

        fun bind(item: Animal){
            currentAnimal = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false), onClick)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvAnimalName.text = data[position].toString()
        viewHolder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}