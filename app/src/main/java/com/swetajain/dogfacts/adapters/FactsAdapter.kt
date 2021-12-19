package com.swetajain.dogfacts.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.dogfacts.R
import com.swetajain.dogfacts.models.Fact

class FactsAdapter : RecyclerView.Adapter<FactsAdapter.FactsViewHolder>() {
    private var factsList = emptyList<Fact>()

    class FactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFact: TextView = itemView.findViewById(R.id.tvFact)
        val tvFactId: TextView = itemView.findViewById(R.id.tvFactId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        return FactsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.facts_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        val current = factsList[position]
        holder.tvFact.text = current.fact
        holder.tvFactId.text = current.factId.toString()
    }

    override fun getItemCount(): Int {
        return factsList.size
    }

    fun setData(list: List<Fact>) {
        this.factsList = list
        notifyDataSetChanged()
    }
}