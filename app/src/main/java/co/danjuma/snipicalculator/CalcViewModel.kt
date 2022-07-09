package co.danjuma.snipicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel : ViewModel() {

    private var state by mutableStateOf(CalcState())
        private set


    fun onAction(action: CalcAction) {
        when (action) {

            is CalcAction.Number -> enterNumber(action.number)
            is CalcAction.Decimal -> enterDecimal()
            is CalcAction.Clear -> state = CalcState()
            is CalcAction.Operation -> enterOperation(action.operation)
            is CalcAction.Calculate -> performCalculate()
            is CalcAction.Delete -> performDeletion()

        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number2 = state.number1.dropLast(1)
            )
        }

    }

    private fun performCalculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 !== null) {
            val result = when (state.operation) {
                is CalcOperation.Add -> number1 + number2
                is CalcOperation.Subtract -> number1 - number2
                is CalcOperation.Multiply -> number1 * number2
                is CalcOperation.Divide -> number1 / number2
                null -> return
            }
        }
    }

    private fun enterOperation(operation: CalcOperation) {

        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }

    }

    private fun enterDecimal() {
        if (
               state.operation == null
            && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }

        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number1 = state.number2 + "."
            )

        }
    }

    private fun enterNumber(number: Int) {

        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }

            state = state.copy(
                number2 = state.number2 + number
            )
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }

        state = state.copy(
            number2 = state.number2 + number
        )


    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}