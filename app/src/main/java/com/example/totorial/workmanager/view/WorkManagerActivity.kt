package com.example.totorial.workmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.totorial.R
import com.example.totorial.databinding.ActivityWorkManagerBinding
import com.example.totorial.workmanager.UploadWorker

class WorkManagerActivity : AppCompatActivity() {

    companion object{
        const val DATA_KEY = "myKey"
    }

    private lateinit var binding: ActivityWorkManagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)
        binding.apply {
            binding.lifecycleOwner = this@WorkManagerActivity
            btnRequest.setOnClickListener {
                setOneTimeWorkRequest()
            }
        }
    }


    private fun setOneTimeWorkRequest() {
        val workManager = WorkManager.getInstance(applicationContext)
        val constrain = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val data: Data = Data.Builder().putInt(DATA_KEY, 125)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constrain)
            .setInputData(data)
            .build()

        workManager.enqueue(uploadRequest)
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                binding.tvLog.text = it.state.name
                if (it.state.isFinished){
                    Toast.makeText(this, it.outputData.getString(UploadWorker.WORKER_DATA_KEY), Toast.LENGTH_SHORT)
                        .show()
                }
            })

    }
}