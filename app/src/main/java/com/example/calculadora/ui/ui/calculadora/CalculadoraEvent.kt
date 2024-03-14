package com.example.calculadora.ui.ui.calculadora

open class CalculadoraEvent {
    object Regresar: CalculadoraEvent()
    object BorrarTodo: CalculadoraEvent()
    object Calcular: CalculadoraEvent()
    class Escribir(val value: String): CalculadoraEvent()
}