package com.training.practice1.presenter

import com.training.practice1.model.MealResponse
import com.training.practice1.model.OperationalCallBack
import com.training.practice1.model.VolleyHandler

class MealPresenter(private val volleyHandler: VolleyHandler,private val mealView: MealMVP.MealView):MealMVP.MealPresenter {
    override fun fetchData() {
        volleyHandler.makeApiCall(object : OperationalCallBack{
            override fun onSuccess(mealResponse: MealResponse) {
                mealView.onsetResult(mealResponse)
            }

            override fun onFailure(message: String) {
                mealView.onError(message)
            }
        })
    }
}