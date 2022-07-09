package co.danjuma.snipicalculator

sealed class CalcOperation(val symbol: String): CalcAction(){

    object Add: CalcOperation("+")
    object Subtract: CalcOperation("-")
    object Multiply: CalcOperation("*")
    object Divide: CalcOperation("/")

}
