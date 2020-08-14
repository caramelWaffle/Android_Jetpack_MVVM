package com.example.totorial.template

import Contextor
import android.content.Context


class ResourceProvider private constructor() {

    private var context = Contextor.getContext()

    private object HOLDER {
        val INSTANCE = ResourceProvider()
    }

    fun getString(stringId: Int): String {
        return context.resources.getString(stringId)
    }

    companion object {
        val resource: ResourceProvider by lazy { HOLDER.INSTANCE }
    }
}