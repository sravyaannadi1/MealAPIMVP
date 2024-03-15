package com.training.practice1.presenter

import com.training.practice1.model.MealResponse

interface MealMVP {
    interface MealPresenter{
        fun fetchData()
    }
    interface MealView{
        fun onsetResult(mealResponse: MealResponse)
        fun onError(message:String)
    }
}