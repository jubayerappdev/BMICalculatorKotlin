package com.creativeitinstitute.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.creativeitinstitute.bmicalculator.databinding.ActivityMainBinding
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val height = (binding.etHeight.text.toString()).toDouble()
            val weight = (binding.etWeight.text.toString()).toDouble()

            calculateBmi(height, weight)


        }
    }
//uhjvyuftyftyfjj
    private fun calculateBmi(height:Double, weight:Double) {

        val result = weight/(height*height)

        binding.txtBmiResult.text = "BMI: ${result.toBigDecimal().setScale(1,RoundingMode.CEILING)}"


        if (result>25){
            Toast.makeText(this@MainActivity,"You're OverWeight!",Toast.LENGTH_LONG).show()

            binding.status.text = "You're OverWeight, Walk everyday!"
        }else if (result<18){
            Toast.makeText(this@MainActivity,"You're UnderWeight!",Toast.LENGTH_LONG).show()
            binding.status.text = "You're UnderWeight, Eat more and more!!"
        }else{
            Toast.makeText(this@MainActivity,"You're Healthy, Enjoy Your Life!!!",Toast.LENGTH_LONG).show()

            binding.status.text = "You're Healthy, Enjoy Your Life!!!"
        }

    }
}