package br.edu.ifsp.dmo.conversordetemperatura.model

object FahrenheitToKelvinStrategy: ConverterTemperatura {

    override fun converter(temperature: Double): Double {
        return (temperature-32) * 1.8 + 273.15
    }
    override fun getScale(): String {
        return "°K"
    }
}