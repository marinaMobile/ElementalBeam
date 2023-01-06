package com.vectorunit.purple.firstgame.ooother

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vectorunit.purple.R
import com.vectorunit.purple.databinding.PagerBinding

class AdapterPager(val list: List<GameVariant>) :
    RecyclerView.Adapter<AdapterPager.VievPagerHolder>() {

    private var onItemClickListenerrr: ((gameVariant: GameVariant) -> Unit)? = null

    inner class VievPagerHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = PagerBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VievPagerHolder {
        val viev = LayoutInflater.from(parent.context).inflate(R.layout.pager, parent, false)
        return VievPagerHolder(viev)
    }

    override fun onBindViewHolder(holder: VievPagerHolder, position: Int) {
        holder.binding.imageViev.setImageResource(list[position].enemyLogo)
        holder.binding.tvLevel.text = list[position].enemyName
        val texty = "${list[position].priceForPlay.toString()}$"
        holder.binding.tvPrice.text = texty
        holder.binding.root.setOnClickListener {
            onItemClickListenerrr?.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: (gameVariant: GameVariant) -> Unit) {
        onItemClickListenerrr = listener
    }
}