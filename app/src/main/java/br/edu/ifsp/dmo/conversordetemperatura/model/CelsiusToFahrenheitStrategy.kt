package br.edu.ifsp.dmo.conversordetemperatura.model

object CelsiusToFahrenheitStrategy: ConverterTemperatura {

    override fun converter(temperature: Double): Double {
        return 1.8 * temperature + 32
    }
    override fun getScale(): String {
        return "°F"
    }

}