package hr.ferit.famouspersons.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.ferit.famouspersons.databinding.ItemInspiringPersonBinding
import hr.ferit.famouspersons.model.InspiringPerson

class InspiringPersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(inspiringPerson: InspiringPerson) {
        val itemBinding = ItemInspiringPersonBinding.bind(itemView)
        Picasso.get().load(inspiringPerson.imageLink).into(itemBinding.ivPersonImage)
        itemBinding.tvPersonName.text = inspiringPerson.name
        val date = inspiringPerson.dateOfBirth + " / " + inspiringPerson.dateOfDeath
        itemBinding.tvPersonDate.text = date
        itemBinding.tvPersonDescription.text = inspiringPerson.shortDescription
    }
}