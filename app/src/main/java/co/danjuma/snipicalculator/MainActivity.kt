package co.danjuma.snipicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun CalcUI(modifier: Modifier = Modifier) { // this functions contains the logic for displays calculation and result activities nd

    Column(
        modifier = modifier
            .background(color = Color(0xFF22252e))
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
fun CalcButtons(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .then(modifier)) {

        Text(
            text = symbol,
            color = Color.White,
            style = MaterialTheme.typography.body1
        )


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnipiCalculatorTheme {
        CalculatorScreen()
    }
}