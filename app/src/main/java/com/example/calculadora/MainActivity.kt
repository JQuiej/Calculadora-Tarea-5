package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androidperu.calculator.ui.calculator.CaculadoraApp
import com.example.calculadora.ui.ui.calculadora.CalculadoraViewModel
import com.example.calculadora.ui.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    private val testViewModel by viewModels<CalculadoraViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaculadoraApp(testViewModel)
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Greeting("Android")
    }
}