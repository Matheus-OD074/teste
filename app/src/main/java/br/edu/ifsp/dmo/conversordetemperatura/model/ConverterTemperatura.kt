package br.edu.ifsp.dmo.conversordetemperatura.model

interface ConverterTemperatura {
    fun converter(temperature : Double) : Double
    fun getScale() : String
}