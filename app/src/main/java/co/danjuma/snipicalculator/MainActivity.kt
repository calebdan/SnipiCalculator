package co.danjuma.snipicalculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
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
    val calculationText by remember { mutableStateOf("308 x 142") }
    val resultText by remember { mutableStateOf("12,939") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = VeryDarkBlue)
    ) {


        Column(
            modifier = Modifier
                .height(315.dp)
                .fillMaxWidth()
                .padding(25.dp),

            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {


            Text(
                text = calculationText,
                style = MaterialTheme.typography.body1,
                color = Color.White,
                maxLines = 2

            )

            Text(
                text = resultText,
                style = MaterialTheme.typography.h1,
                color = Color.White,
                maxLines = 2
            )
        }


        CalcButton(calculationText, resultText)

    }
}


@Composable
fun CalcButton(s: String, a: String) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                )
            )
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
            GridCells.Fixed(4),
            contentPadding = PaddingValues(
                start = 25.dp,
                end = 25.dp,
                top = 40.dp,
                bottom = 70.dp
            )
        ) {
            items(data) { item ->

                Card(


                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "button $item  clicked",
                                    Toast.LENGTH_SHORT
                                )
                                .show()


                        },
                    backgroundColor = VeryDarkBlue,
                    elevation = 1.dp,
                    shape = RoundedCornerShape(5.dp)

                ) {
                    Text(
                        text = item,
                        fontSize = 19.sp,
                        style = MaterialTheme.typography.h1,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(15.dp)
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