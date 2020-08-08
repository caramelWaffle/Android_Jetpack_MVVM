package com.example.totorial.coroutine.manager

import kotlinx.coroutines.*

class DataManager {

    //    Unstructured concurrency
    suspend fun getTotalUserCount(): Int {
        val count = CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            return@async 300
        }

        val extra = CoroutineScope(Dispatchers.IO).async {
            delay(2000)
            return@async 400
        }

        return count.await() + extra.await()
    }

    //   Structured concurrency
    //   Guarantee to complete all task in coroutine
    suspend fun getTotalUserCount2(): Int {
        var count: Deferred<Int>
        var extra: Deferred<Int>

        coroutineScope {
            count = async(Dispatchers.IO) {
                delay(1000)
                return@async 50
            }
            extra = async(Dispatchers.IO) {
                delay(4000)
                return@async 70
            }
        }

        return count.await() + extra.await()
    }
}