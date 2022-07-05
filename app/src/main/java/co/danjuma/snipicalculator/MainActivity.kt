package co.danjuma.snipicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.danjuma.snipicalculator.ui.theme.SnipiCalculatorTheme

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
fun CalcUI() { // this functions contains the logic for displays calculation and result activities nd

    Box(
        modifier = Modifier
            .height(190.dp)
            .fillMaxWidth().padding(10.dp)
    ) {

        Text(
            text = "this is a text")



        Text(
            text = "Test",
            modifier = Modifier.align(Alignment.BottomEnd)
        )

    }



    GridButtons()
}

@Composable
fun GridButtons() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnipiCalculatorTheme {
        CalculatorScreen()
    }
}