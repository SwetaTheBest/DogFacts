package com.swetajain.dogfacts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.dogfacts.databinding.FactsItemBinding
import com.swetajain.dogfacts.models.Fact
import com.swetajain.dogfacts.utils.FactsDiffUtils

/**
 * A simple Adapter that binds Facts items into Views.
 *
 * FactsAdapter is a RecyclerView.Adapter base class which can present the content of Lists
 * in a RecyclerView. It requests new items as the user scrolls, and handles new Lists by
 * computing list differences on a background thread, and dispatching minimal, efficient updates to
 * the RecyclerView to ensure minimal UI thread work.

 */
class FactsAdapter : RecyclerView.Adapter<FactsAdapter.FactsViewHolder>() {
    private var factsList = emptyList<Fact>()

    class FactsViewHolder(val binding: FactsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        return FactsViewHolder(
            FactsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        val current = factsList[position]
        holder.binding.tvFact.text = current.fact
        holder.binding.tvFactId.text = current.factId.toString()
    }

    override fun getItemCount(): Int {
        return factsList.size
    }

    fun setData(newList: List<Fact>) {
        val diffUtil = FactsDiffUtils(oldFacts = factsList, newFacts = newList)
        val diffResultList = DiffUtil.calculateDiff(diffUtil)
        factsList = newList
        diffResultList.dispatchUpdatesTo(this)
    }
}