package com.vectorunit.purple.firstgame

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.vectorunit.purple.R
import com.vectorunit.purple.databinding.FragmentGaaameBinding
import com.vectorunit.purple.firstgame.connsta.Costyya
import com.vectorunit.purple.firstgame.ooother.GameVariant
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class GaaameFragment : Fragment() {
    private var fragmentGaaameBinding: FragmentGaaameBinding? = null
    private val binding
        get() = fragmentGaaameBinding ?: throw RuntimeException("FragmentGaaameBinding = null")

    val MAIN_KEY_SHARED_PREF_BALANCE = Costyya.MAIN_KEY_SHARED_PREF_BALANVE
    val KEY_BALANCE = Costyya.KEY_BALAMCE

    private val totalBalanceSP by lazy {
        requireActivity().getSharedPreferences(
            MAIN_KEY_SHARED_PREF_BALANCE,
            Context.MODE_PRIVATE
        )
    }

    private val totalBalance by lazy {
        totalBalanceSP.getInt(KEY_BALANCE, Costyya.START_BALANCE_DEF)
    }

    private fun saveBalance(balance: Int) {
        totalBalanceSP.edit().apply {
            putInt(KEY_BALANCE, balance)
            apply()
        }
    }


    private val args: GaaameFragmentArgs by navArgs()

    private val currentGame by lazy {
        args.gameVar
    }

    private val lissstElements by lazy {
        listOf(
            binding.imgGameElem1,
            binding.imgGameElem2,
            binding.imgGameElem3,
            binding.imgGameElem4,
            binding.imgGameElem5,
            binding.imgGameElem6,
            binding.imgGameElem7,
            binding.imgGameElem8,
        )
    }

    private fun loadElements() {
        lissstElements.forEach {
            it.setImageResource(currentGame.iiimages)
        }
    }

    private fun initOnPressListener() {

        binding.imgGameElem1.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()

            } else {
                looose()
            }
        }

        binding.imgGameElem2.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }

        binding.imgGameElem3.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
        binding.imgGameElem4.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
        binding.imgGameElem5.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
        binding.imgGameElem6.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
        binding.imgGameElem7.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
        binding.imgGameElem8.setOnClickListener {
            it.isEnabled = false
            binding.imgGameMainLogo.isEnabled = false
            if (Random.nextBoolean() && Random.nextBoolean()) {
                viiin()
            } else {
                looose()
            }
        }
    }

    private fun viiin() {
        val ball = totalBalance + currentGame.priceForPlay + currentGame.priceForPlay
        saveBalance(ball)
        binding.tvUserBalancePoint.text = ball.toString()

        lifecycleScope.launch {
            binding.imgGameMainLogo.visibility = View.INVISIBLE
            binding.lottVinn.visibility = View.VISIBLE

            Toast.makeText(
                requireContext(),
                "You winn!!! ${2*currentGame.priceForPlay}",
                Toast.LENGTH_SHORT
            ).show()
            delay(2000)
            findNavController().navigate(R.id.action_gaaameFragment_to_reloooadingFragment)
        }
    }

    private fun looose() {
        lifecycleScope.launch {
            Toast.makeText(
                requireContext(),
                "You lose!!! I will restart game now",
                Toast.LENGTH_SHORT
            ).show()
            delay(1000)
            findNavController().navigate(R.id.action_gaaameFragment_to_reloooadingFragment)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGaaameBinding = FragmentGaaameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            loadElements()

            binding.tvUserBalancePoint.text = totalBalance.toString()
            binding.imgGameMainLogo.setImageResource(currentGame.enemyLogo)

            binding.imgGameMainLogo.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Not me, i am just ${currentGame.enemyName}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            initOnPressListener()


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
        fragmentGaaameBinding = null
        super.onDestroy()
    }

    private fun vfvvf() {
        Snackbar.make(
            binding.root,
            "Some error...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}