package com.vectorunit.purple.firstgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vectorunit.purple.R
import com.vectorunit.purple.databinding.FragmentReloooadingBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class ReloooadingFragment : Fragment() {
    private var fragmentReloooadingBinding: FragmentReloooadingBinding? = null
    private val binding
        get() = fragmentReloooadingBinding ?: throw RuntimeException("FragmentReloooadingBinding = null")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentReloooadingBinding = FragmentReloooadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            lifecycleScope.launchWhenCreated {
                Toast.makeText(requireContext(), "Collecting money", Toast.LENGTH_SHORT).show()
                delay(3000)
                findNavController().navigate(R.id.action_reloooadingFragment_to_pagerFragment)

            }



        } catch (e: Exception) {
            vfvvf()
        }


        super.onViewCreated(view, savedInstanceState)
    }


    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    override fun onDestroy() {
        fragmentReloooadingBinding = null
        super.onDestroy()
    }

    private fun vfvvf() {
        Toast.makeText(
            requireContext(),
            "Some error...",
            Toast.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}