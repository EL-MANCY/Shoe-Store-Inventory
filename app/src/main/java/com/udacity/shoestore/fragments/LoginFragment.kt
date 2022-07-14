package com.udacity.shoestore.fragments

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

//       binding.SignIn.setOnClickListener {
//           it.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
//
//           val imm = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//           imm.hideSoftInputFromWindow(view!!.windowToken, 0)
//       }
//       binding.SignUp.setOnClickListener {
//           it.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
//
//           val imm = context!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//           imm.hideSoftInputFromWindow(view!!.windowToken, 0)
//
//       }
       setHasOptionsMenu(true)

        binding.loginfragment=this

       binding.lifecycleOwner = this

       return binding.root
    }


    fun SignIn(){
        if(binding.EMAIL.text.toString().isEmpty()||binding.PASSWORD.text.toString().isEmpty()){
            Toast.makeText(context,"ENTER YOUR PASS AND EMAIL",Toast.LENGTH_LONG).show()
        }else{
        binding.SignIn.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }}

    fun SignUp(){
        if(binding.EMAIL.text.toString().isEmpty()||binding.PASSWORD.text.toString().isEmpty()){
            Toast.makeText(context,"ENTER YOUR PASS AND EMAIL",Toast.LENGTH_LONG).show()
        }else{
            binding.SignUp.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }}


}