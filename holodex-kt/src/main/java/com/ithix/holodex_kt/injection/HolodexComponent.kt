package com.ithix.holodex_kt.injection

import com.ithix.holodex_kt.HolodexKt
import dagger.Component

@Component(modules = [HolodexModule::class])
internal interface HolodexComponent {

    fun inject(holodexKt: HolodexKt)
}