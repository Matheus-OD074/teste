package br.edu.ifsp.dmo.conversordetemperatura.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura.R
import br.edu.ifsp.dmo.conversordetemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.conversordetemperatura.model.FahrenheitToCelsiusStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.ConverterTemperatura
import br.edu.ifsp.dmo.conversordetemperatura.model.CelsiusToFahrenheitStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.CelsiusToKelvinStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.FahrenheitToKelvinStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.KelvinToCelsiusStrategy
import br.edu.ifsp.dmo.conversordetemperatura.model.KelvinToFahrenheitStrategy
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var converterStrategy: ConverterTemperatura

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener(){
        binding.btnFahrenheitToCelsius.setOnClickListener{
            handleConversion(FahrenheitToCelsiusStrategy)
        }

        binding.btnCelsiusToFahrennheit.setOnClickListener{
            handleConversion(CelsiusToFahrenheitStrategy)
        }
        binding.btnCelsiusToKelvin.setOnClickListener{
            handleConversion(CelsiusToKelvinStrategy)
        }

        binding.btnFahrenheitToKelvin.setOnClickListener{
            handleConversion(FahrenheitToKelvinStrategy)
        }
        binding.btnKelvinToCelsius.setOnClickListener{
            handleConversion(KelvinToCelsiusStrategy)
        }

        binding.btnKelvinToFahrenheit.setOnClickListener{
            handleConversion(KelvinToFahrenheitStrategy)
        }
    }

    private fun readTemperature(): Double{
        return try{
            binding.edittextTemperature.text.toString().toDouble()
        }catch (e: NumberFormatException) {
            throw NumberFormatException("Input Error")
        }
    }

    private fun handleConversion(strategy: ConverterTemperatura){
        converterStrategy = strategy

        try {
            val inputValue = readTemperature()
            binding.textviewResultNumber.text = String.format("%.2f %s" , converterStrategy.converter(inputValue), converterStrategy.getScale())
            binding.textviewResultMessage.text = if(this.converterStrategy is FahrenheitToCelsiusStrategy){
                getString(R.string.msgFtoC)
            }else{
                getString(R.string.msgCtoF)
            }
        }catch (e: Exception){
            Toast.makeText(this, getString(R.string.error_popup_notify), Toast.LENGTH_SHORT).show()
            Log.e("APP_DMO", e.stackTraceToString())
        }
    }

}