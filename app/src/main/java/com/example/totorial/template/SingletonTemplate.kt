package com.example.totorial.template

import Contextor
import android.content.Context

/**
 * Created by nuuneoi on 11/16/2014.
 */
class SingletonTemplate private constructor() {
    private val context: Context = Contextor.getContext()

    companion object {
          fun foo(){

          }
    }


}