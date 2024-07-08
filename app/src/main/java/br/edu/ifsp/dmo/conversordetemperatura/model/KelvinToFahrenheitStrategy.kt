package br.edu.ifsp.dmo.conversordetemperatura.model

object KelvinToFahrenheitStrategy: ConverterTemperatura {

    override fun converter(temperature: Double): Double {
        return (temperature - 273.15) * 1.8 + 32
    }
    override fun getScale(): String {
        return "°F"
    }
}