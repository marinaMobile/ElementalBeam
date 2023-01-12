package com.vectorunit.purple.firstgame

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vectorunit.purple.R
import com.vectorunit.purple.databinding.FragmentPagerBinding
import com.vectorunit.purple.firstgame.connsta.Costyya
import com.vectorunit.purple.firstgame.connsta.Costyya.KEY_BALAMCE
import com.vectorunit.purple.firstgame.connsta.Costyya.MAIN_KEY_SHARED_PREF_BALANVE
import com.vectorunit.purple.firstgame.ooother.AdapterPager
import com.vectorunit.purple.firstgame.ooother.GameVariant


class PagerFragment : Fragment() {
    private var fragmentChooseLevelBinding: FragmentPagerBinding? = null
    private val binding
        get() = fragmentChooseLevelBinding ?: throw RuntimeException("FragmentPagerBinding = null")

    private fun saveBalance(balllance:Int) {
        totalBalanceSP.edit().apply {
            putInt(KEY_BALANCE, balllance)
            apply()
        }
    }

    val MAIN_KEY_SHARED_PREF_BALANCE = MAIN_KEY_SHARED_PREF_BALANVE
    val KEY_BALANCE = KEY_BALAMCE

    private val totalBalanceSP by lazy {
        requireActivity().getSharedPreferences(
            MAIN_KEY_SHARED_PREF_BALANCE,
            Context.MODE_PRIVATE
        )
    }

    private val  totalBalance by lazy {
        totalBalanceSP.getInt(KEY_BALANCE, Costyya.START_BALANCE_DEF)
    }

    private lateinit var currentGameVariant: GameVariant


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentChooseLevelBinding = FragmentPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            val listOfGameVariants = listOf(
                GameVariant.One(),
                GameVariant.Tvo(),
                GameVariant.Three(),
                GameVariant.Four(),
                GameVariant.Five(),
            )
            val pagerAdapter = AdapterPager(listOfGameVariants)
            binding.pager.adapter = pagerAdapter
            binding.circleIndicatorPhotoGalery.setViewPager(binding.pager)

            binding.tvUserBalancePoint.text = totalBalance.toString()

            pagerAdapter.setOnItemClickListener {

                if (totalBalance >= it.priceForPlay) {


                    currentGameVariant = it
                    initAlertDialog(it)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Your balance is less than PRICE for game. Need more money",
                        Toast.LENGTH_LONG
                    ).show()
                }


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
        fragmentChooseLevelBinding = null
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


    private fun jkkjkoo(currentPoint: Int) {
        Snackbar.make(
            binding.root,
            "You recived $currentPoint points",
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun initAlertDialog(gameVariant: GameVariant) {
        AlertDialog.Builder(requireContext())
            .setTitle("Game rules")
            .setMessage("The main task of the game is to find a prize element among a number of elements.\nThe total number of elements is 8. Only one of them is a winner.\nThe cost of one game varies from 100 to 300. The cost of the game will be debited from your balance.\nIf the size of  balance is less than the value of  game, you need to add to the balance.\nBefore starting the game, you need to concentrate as much as possible, turn on your intuition, and then choose one of the 8 elements.\nIf you have chosen the item correctly, you will receive 2x the cost of the game, which will automatically be added to your balance.")
            .setPositiveButton("Ok, start") { _, _ ->
                val baaal = totalBalance - currentGameVariant.priceForPlay
                binding.tvUserBalancePoint.text = baaal.toString()
                saveBalance(baaal)

                PagerFragmentDirections.actionPagerFragmentToGaaameFragment(currentGameVariant)
                    .also {
                        findNavController().navigate(it)
                    }
            }
            .setNegativeButton("No") { _, _ ->

            }

            .setCancelable(true)
            .create()
            .show()
    }
}