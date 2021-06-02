package kz.glatis.chocodevcon.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapter
import kz.glatis.chocodevcon.R
import kz.glatis.chocodevcon.databinding.ItemAuthBinding
import kz.glatis.chocodevcon.delegateadapter.DelegateAdapterItem
import kz.glatis.chocodevcon.model.AuthAdapterModel

class AuthAdapter(
    private val onAuthClicked: ((String) -> Unit)
) : DelegateAdapter<AuthAdapterModel, AuthAdapter.AuthViewHolder>(AuthAdapterModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        AuthViewHolder(
            DataBindingUtil.inflate(LayoutInflater
            .from(parent.context), R.layout.item_auth, parent, false))

    override fun bindViewHolder(
        model: AuthAdapterModel,
        viewHolder: AuthViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class AuthViewHolder(
        private val binding: ItemAuthBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AuthAdapterModel) {
            binding.phoneEditText.setText(item.phone)
            binding.otpButton.setOnClickListener {
                onAuthClicked(binding.phoneEditText.text.toString())
            }
        }
    }
}