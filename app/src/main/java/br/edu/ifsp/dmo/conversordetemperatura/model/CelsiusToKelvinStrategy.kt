package br.edu.ifsp.dmo.conversordetemperatura.model

object CelsiusToKelvinStrategy: ConverterTemperatura {

    override fun converter(temperature: Double): Double {
        return temperature + 273.15
    }
    override fun getScale(): String {
        return "°K"
    }
}