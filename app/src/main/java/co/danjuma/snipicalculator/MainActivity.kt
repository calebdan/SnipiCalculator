package co.danjuma.snipicalculator

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun CalcUI() { // this functions contains the logic for displays calculation and result activities nd

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = VeryDarkBlue)
    ) {


        Column(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(25.dp),

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

        CalcButton()

    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalcButton() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(color = NotVeryDarkBlue)
    ) {

        val data = listOf(
            "AC",
            "+-",
            "%",
            "\u00F7",
            "7",
            "8",
            "9",
            "*",
            "4",
            "5",
            "6",
            "-",
            "1",
            "2",
            "3",
            "+",
            "H",
            "0",
            ".",
            "="
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(4),
            contentPadding = PaddingValues(6.dp)
        ) {
            items(data.size) { item ->

                Card(
                    modifier = Modifier.padding(10.dp),
                    backgroundColor = VeryDarkBlue,
                    elevation = 2.dp,
                    shape = RoundedCornerShape(5.dp)
                ) {

                    Text(
                        text = item.toString() ,
                        fontSize = 24.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(24.dp)
                    )

                }

            }

        }

    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnipiCalculatorTheme {
        CalculatorScreen()
    }
}