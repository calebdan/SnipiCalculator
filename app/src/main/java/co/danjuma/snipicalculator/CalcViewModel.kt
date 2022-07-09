package co.danjuma.snipicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {

    var state by mutableStateOf(CalcState())

    private set


    fun onAction(action: CalcAction){
        when(action){

            is CalcAction.Number -> enterNumber(action.number)
            is CalcAction.Decimal -> enterDecimal()
            is CalcAction.Clear -> state = CalcState()
            is CalcAction.Operation -> enterOperation(action.operation)
            is CalcAction.Calculate -> performCalculate()
            is CalcAction.Delete -> PerformDeletion()

        }
    }

    class PerformDeletion {

    }

    private fun performCalculate() {
        TODO("Not yet implemented")
    }

    private fun enterOperation(operation: CalcOperation) {

        if(state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }



    }

    private fun enterDecimal() {
        TODO("Not yet implemented")
    }

    private fun enterNumber(number: Int) {

    }

}