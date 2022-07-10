package co.danjuma.snipicalculator

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.danjuma.snipicalculator.ui.theme.NotVeryDarkBlue
import co.danjuma.snipicalculator.ui.theme.SnipiCalculatorTheme
import co.danjuma.snipicalculator.ui.theme.VeryDarkBlue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnipiCalculatorTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    CalcUI()

}

@Composable
fun CalcUI(modifier: Modifier = Modifier) { // this functions contains the logic for displays calculation and result activities nd

    Column(
        modifier = modifier
            .background(color = VeryDarkBlue)
            .height(250.dp)
            .fillMaxWidth()
            .padding(20.dp),

        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {

        Text(
            text = "308 x 42",
            style = MaterialTheme.typography.body1,
            color = Color.White

        )


        Text(
            text = "12,939",
            style = MaterialTheme.typography.h1,
            color = Color.White
        )
    }


}

@Composable
fun CalcButton() {

Box(modifier = Modifier.fillMaxWidth()
    .background(color = NotVeryDarkBlue) ){
    
}


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnipiCalculatorTheme {
        CalculatorScreen()
    }
}