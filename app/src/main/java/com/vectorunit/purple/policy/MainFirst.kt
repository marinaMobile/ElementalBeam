package com.vectorunit.purple.policy

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.vectorunit.purple.R
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named


class MainFirst : Fragment() {

    private lateinit var mContext: Context
    lateinit var deepSt: String

    val shareP: SharedPreferences by inject(named("SharedPreferences"))
    val viewMainModel by viewModel<ViMod>(named("MainModel"))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_first, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMainModel.fbDeee(mContext)

        findNavController().navigate(R.id.action_mainFirst_to_countryFragm)


//        viewMainModel.deepS.observeForever {
//            if(it!=null){
//                deepSt = it.toString()
//                shareP.edit().putString("deepSt", deepSt).apply()
//            } else {
//                shareP.edit().putString("deepSt", "null").apply()
//            }
//
//        }

    }
}