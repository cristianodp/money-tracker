package com.cdp.moneytracker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cdp.moneytracker.R
import com.cdp.moneytracker.databinding.FragmentMovementBinding
import com.cdp.moneytracker.viewsmodel.MovementViewModel


class MovementFragment : Fragment() {


    lateinit var viewModel: MovementViewModel
    lateinit var binding: FragmentMovementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<FragmentMovementBinding>(
            inflater,
            R.layout.fragment_movement,
            container,
            false
        );

        viewModel = ViewModelProvider(this).get(MovementViewModel::class.java)
        binding.viewmodel = viewModel
        return binding.root


    }


}
