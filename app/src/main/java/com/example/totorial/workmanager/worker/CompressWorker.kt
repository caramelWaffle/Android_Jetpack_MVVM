package com.example.totorial.workmanager.worker

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.totorial.workmanager.view.WorkManagerActivity
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class CompressWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            for (i in 0 until 100) {
                Log.i("myTag", "Compressing $i")
            }

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}