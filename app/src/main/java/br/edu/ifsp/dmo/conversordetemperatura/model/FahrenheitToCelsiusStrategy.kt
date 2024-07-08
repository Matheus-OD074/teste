package br.edu.ifsp.dmo.conversordetemperatura.model

object FahrenheitToCelsiusStrategy: ConverterTemperatura{

    override fun converter(temperature: Double) = (temperature - 32) / 1.8
    override fun getScale(): String {
        return "°C"
    }

}