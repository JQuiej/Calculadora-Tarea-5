package com.example.calculadora.ui.ui.calculadora

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context


class CalculadoraViewModel: ViewModel() {
    private val _inputText = mutableStateOf(CalculadoraState())
    val inputText: State<CalculadoraState> = _inputText

    private val _outputText = mutableStateOf(CalculadoraState())
    val outputText: State<CalculadoraState> = _outputText

    fun onEvent(e: CalculadoraEvent){
      when (e) {
          CalculadoraEvent.BorrarTodo -> clear()
          CalculadoraEvent.Regresar -> regresar()
          CalculadoraEvent.Calcular -> calcular()
          is CalculadoraEvent.Escribir -> escribir(e.value)
      }
    }

    private fun clear (){
        _inputText.value = inputText.value.copy(
            text = " "
        )
        _outputText.value = inputText.value.copy(
            text = " "
        )
    }

    private fun regresar (){
        val lenght = _inputText.value.text.length
        if (lenght > 0){
            _inputText.value = inputText.value.copy(
                text = inputText.value.text.subSequence(0, lenght-1 ) as String
            )
        }
    }
    private fun calcular() {
        val result = rhinoSetUp(_inputText.value.text)
        _outputText.value = outputText.value.copy(
            text = result
        )
    }

    private fun escribir(value: String){
        _inputText.value = inputText.value.copy(
            text = inputText.value.text + value
        )
    }

    private fun rhinoSetUp(input: String): String {
        val rhino = Context.enter()
        rhino.optimizationLevel = -1

        val scriptable = rhino.initStandardObjects()
        return rhino.evaluateString(
            scriptable,
            input.replace("×","*"),
            "javascript",
            1,
            null
        ).toString()
    }
}