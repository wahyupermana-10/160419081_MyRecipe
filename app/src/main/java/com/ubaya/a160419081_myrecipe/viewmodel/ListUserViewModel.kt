package com.ubaya.a160419081_myrecipe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.a160419081_myrecipe.model.User
import com.ubaya.a160419081_myrecipe.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListUserViewModel(application:Application):AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User>()
    val userLoadErrorLD = MutableLiveData<Boolean>()
    val userloadingLD = MutableLiveData<Boolean>()

    private var job = Job()

    fun fetch(email:String,password:String){
        launch{
            val db = buildDb(getApplication())
            userLD.value = db.userDao().selectUser(email,password)
        }
    }

    fun addUser(user: User){
        launch {
            val db = buildDb(getApplication())
            db.userDao().insertUser(user)
        }
    }

    fun updateActive(username: String){
        launch{
            val db = buildDb(getApplication())
            db.userDao().updateActive(username)
        }
    }

    fun updateOff(username: String){
        launch{
            val db = buildDb(getApplication())
            db.userDao().updateActive(username)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}