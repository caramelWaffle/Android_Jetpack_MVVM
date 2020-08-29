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

class UploadWorker(context: Context, workerParam: WorkerParameters) : Worker(context, workerParam) {

    companion object {
        val WORKER_DATA_KEY = "WORKER_DATA_KEY"
    }

    override fun doWork(): Result {
        return try {
            val count = inputData.getInt(WorkManagerActivity.DATA_KEY, 100)
            for (i in 0 until count) {
                Log.i("myTag", "Uploading $i")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss", Locale.CHINA)
            val currentTime = time.format(Date())
            val outputData = Data.Builder()
                .putString(WORKER_DATA_KEY, currentTime)
                .build()
            Result.success(outputData)
        } catch (e: Exception) {
            Result.failure()
        }
    }
}