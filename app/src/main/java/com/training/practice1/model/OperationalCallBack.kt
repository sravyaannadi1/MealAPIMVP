package com.training.practice1.model

interface OperationalCallBack {
    fun onSuccess(mealResponse: MealResponse)
    fun onFailure(message: String)
}