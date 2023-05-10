package com.ithix.holodex_kt.injection

class HolodexWrapper {

    private var mComponent: HolodexComponent? = null

    internal fun getComponent(): HolodexComponent? {
        return mComponent
    }

    fun initComponent(holoToken: String) {
        mComponent = DaggerHolodexComponent
            .builder()
            .holodexModule(HolodexModule(holoToken))
            .build()
    }

}