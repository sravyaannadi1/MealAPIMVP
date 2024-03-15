package com.training.practice1.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.training.practice1.model.Constants.BASE_URL_MEAL

class VolleyHandler(private val context: Context, private val country:String) {
    fun makeApiCall(callBack: OperationalCallBack){
        val requestQueue= Volley.newRequestQueue(context)
        val url=BASE_URL_MEAL+country
        val stringRequest= StringRequest(Request.Method.GET,url,{
        Log.i("tag","$it")
            val typeToken= object: TypeToken<MealResponse>(){}
            val response=Gson().fromJson(it,typeToken)
            Log.i("success Tag","success")
            callBack.onSuccess(response)

        },{
            Log.i("Failture Tag","${it.message}")
            callBack.onFailure("server error")
        })
        requestQueue.add(stringRequest)

    }



}