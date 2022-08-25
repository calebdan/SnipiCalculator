package co.danjuma.snipicalculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalcViewModel:ViewModel() {

    var state = mutableStateOf(CalculatorState())
    private set
}