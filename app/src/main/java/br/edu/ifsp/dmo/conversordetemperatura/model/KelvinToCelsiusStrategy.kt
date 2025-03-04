package br.edu.ifsp.dmo.conversordetemperatura.model

object KelvinToCelsiusStrategy: ConverterTemperatura {

    override fun converter(temperature: Double): Double {
        return temperature - 273.15
    }
    override fun getScale(): String {
        return "°C"
    }
}