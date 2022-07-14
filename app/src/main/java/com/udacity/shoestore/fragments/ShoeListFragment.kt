package com.udacity.shoestore.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.*
import kotlinx.android.synthetic.main.shoeitem.*
import java.util.Observer


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel
    private var  parent: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        binding.ADD.setOnClickListener {
            it.findNavController().navigate(com.udacity.shoestore.fragments.ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        viewModel= ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel=viewModel
        binding.shoeListFragment=this
        binding.lifecycleOwner = this
        parent=binding.parent

        viewModel.ShoeList.observe(viewLifecycleOwner, androidx.lifecycle.Observer { it->
            for (i in it.indices){
                val shoe=it[i]
                addShoe(shoe)
            }
        })
        return binding.root
    }

    private fun addShoe(shoe: Shoe) {
        val inflater= context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val i = inflater.inflate(R.layout.shoeitem, null)
        val name:TextView = i.findViewById(R.id.nameShoe)
        val size:TextView = i.findViewById(R.id.sizeShoe)
        val description:TextView = i.findViewById(R.id.descriptionShoe)
        name.text = shoe.name
        size.text = shoe.size.toString()
        description.text = shoe.description
        parent!!.addView(i)



    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logoutmenu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}