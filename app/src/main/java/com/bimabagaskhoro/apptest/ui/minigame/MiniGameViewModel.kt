package com.bimabagaskhoro.apptest.ui.minigame

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.apptest.data.ResponseMiniGame
import com.bimabagaskhoro.apptest.data.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MiniGameViewModel  : ViewModel() {
    val dataMiniGame = MutableLiveData<ResponseMiniGame>()
    fun setMiniGame(){
        RetrofitClient.apiInstance
            .getFact().enqueue(object : Callback<ResponseMiniGame>{
                override fun onResponse(
                    call: Call<ResponseMiniGame>,
                    response: Response<ResponseMiniGame>
                ) {
                    if (response.isSuccessful){
                        dataMiniGame.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ResponseMiniGame>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }
    fun getMiniGame(): LiveData<ResponseMiniGame> = dataMiniGame

}