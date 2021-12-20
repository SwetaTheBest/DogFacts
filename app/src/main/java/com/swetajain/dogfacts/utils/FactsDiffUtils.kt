package com.swetajain.dogfacts.utils

import androidx.recyclerview.widget.DiffUtil
import com.swetajain.dogfacts.models.Fact

/**
 * This diff callback informs the Adapter how to compute list differences when new
 * Lists arrive.
 *
 * When you add Facts with the 'Add' button, the PagedListAdapter uses diffCallback to
 * detect there's only a single item difference from before, so it only needs to animate and
 * rebind a single view.
 *
 * @see DiffUtil
 */
class FactsDiffUtils(
    private val oldFacts: List<Fact>,
    private val newFacts: List<Fact>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldFacts.size
    }

    override fun getNewListSize(): Int {
        return newFacts.size
    }

    /**
     * Note that in kotlin, == checking on data classes compares all contents, but in Java,
     * typically you'll implement Object#equals, and use it to compare object contents.
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldFacts[oldItemPosition].factId == newFacts[newItemPosition].factId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldFacts[oldItemPosition].factId != newFacts[newItemPosition].factId -> {
                false
            }
            oldFacts[oldItemPosition].fact != newFacts[newItemPosition].fact -> {
                false
            }

            else -> true
        }
    }
}