package com.varivoda.igor.zagonetke.ui.levels

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.varivoda.igor.domain.model.PointsEntry
import com.varivoda.igor.domain.model.RiddleEntry
import com.varivoda.igor.zagonetke.R
import com.varivoda.igor.zagonetke.ui.riddle.MY_TYPEFACE

class LevelAdapter(): RecyclerView.Adapter<LevelAdapter.MyViewHolder>() {

    private var riddles: List<RiddleEntry> = listOf()
    private var point: Int = 0
    private var listener: OnItemClickListener? = null

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var numberOfLevel: TextView = itemView.findViewById(R.id.numberOfLevel)


        companion object{
            fun create(parent: ViewGroup): MyViewHolder{
                return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.level_item,parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun getItemCount(): Int = riddles.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.numberOfLevel.text = holder.itemView.context.getString(R.string.position_resource,(position+1).toString())
        holder.numberOfLevel.typeface = Typeface.createFromAsset(holder.itemView.context.assets, MY_TYPEFACE)
        val first = riddles[0].id
        if(point>(first+position)){
            holder.numberOfLevel.setTextColor(Color.WHITE)
            holder.numberOfLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_check,0)
            holder.itemView.setOnClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onClick(riddles[position])
                }
            }
        }else if(point==(first+position)){
            holder.numberOfLevel.setTextColor(Color.WHITE)
            holder.numberOfLevel.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
            holder.itemView.setOnClickListener {
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onClick(riddles[position])
                }
            }
        }

        holder.setIsRecyclable(false)
    }

    fun setItems(list: List<RiddleEntry>, point: Int){
        riddles = list
        this.point = point
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick(riddle: RiddleEntry)
    }

    fun setOnItemClickListener(lis: OnItemClickListener) {
        listener = lis
    }
}