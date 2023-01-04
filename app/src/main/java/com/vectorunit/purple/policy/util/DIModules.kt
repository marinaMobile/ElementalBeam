package com.vectorunit.purple.policy.util

import com.vectorunit.purple.policy.BeamModel
import com.vectorunit.purple.policy.ViMod
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {
    viewModel (named("MainModel")){
        ViMod(get())
    }
    viewModel(named("BeamModel")) {
        BeamModel(get())
    }
}
