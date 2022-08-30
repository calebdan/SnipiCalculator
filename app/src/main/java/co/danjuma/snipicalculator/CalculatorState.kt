package co.danjuma.snipicalculator

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class CalculatorState(
    var calcValue:String = "308 x 42",
    val resultValue:String = "12,939",
)
