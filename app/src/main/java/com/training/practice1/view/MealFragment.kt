package com.training.practice1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.practice1.R
import com.training.practice1.databinding.FragmentMealBinding
import com.training.practice1.model.MealResponse
import com.training.practice1.model.VolleyHandler
import com.training.practice1.presenter.MealMVP
import com.training.practice1.presenter.MealPresenter


class MealFragment : Fragment(), MealMVP.MealView {
    private lateinit var binding: FragmentMealBinding
    private lateinit var presenter: MealPresenter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentMealBinding.inflate(inflater,container,false)
        initPresenterViews()

        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)


        return binding.root
        // Inflate the layout for this fragment
    }



    private fun initPresenterViews() {
        binding.btn1.setOnClickListener {
            val ext=binding.edtxt.getText().toString()

            presenter= MealPresenter(VolleyHandler(requireContext(),ext),this)
            presenter.fetchData()
        }
  }

    override fun onsetResult(mealResponse: MealResponse) {
        Log.i("data tag","${mealResponse}")
        val ylist=ArrayList<MealDetails>()
        val dataList=mealResponse.meals
        for(i in dataList.indices){
            ylist.add(MealDetails(dataList[i].idMeal,dataList[i].strMeal,dataList[i].strMealThumb))

        }
        val adapter=MealAdapter(requireContext(),ylist)
        binding.recyclerView.adapter=adapter

    }

    override fun onError(message: String) {

    }


}