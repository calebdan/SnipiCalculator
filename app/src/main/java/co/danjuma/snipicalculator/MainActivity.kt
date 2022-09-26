package co.danjuma.snipicalculator

import android.os.Bundle


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
import androidx.compose.ui.graphics.toArgb

import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.danjuma.snipicalculator.ui.theme.*


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnipiCalculatorTheme {

                CalculatorScreen()

            }
        }
    }
}

@Composable
fun CalculatorScreen() {

    CalcView()
}


@Composable
fun CalcView() {

    /*
    * The purpose of this composable is to 1, view the calculations input,
    * for example when a user types in 5+5.  2, to display the result of
    * the calculation
    */


    /*
    * when calculationText and resultText was added they  were supposed
    * to somewhat act like global variables, yea I don't know what i was
    * thinking.  Right now they are
    */

    var calculation by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }


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

                text = calculation,
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

        CalcButton({ calculation = it }, {resultText = it})

    }


}


@Composable
fun CalcButton(
    onCalcChange: (String) -> Unit,
    onResultChange: (String) -> Unit
) {

    var currentItem by remember { mutableStateOf("") }
    var operatorActive: Boolean? = null





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
            "C",
            "+/-",
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
            "...",
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
                            currentItem += item


                            var nnew = calcOperations(currentItem)











                            onCalcChange(nnew)



                        },

                    backgroundColor = VeryDarkBlue,
                    elevation = 1.dp,
                    shape = RoundedCornerShape(5.dp)

                ) {
                    val btnTextColor = when (item) {

                        "C" -> {
                            Color(color = Teal200.toArgb())
                        }
                        "+/-" -> {
                            Color(color = Teal200.toArgb())
                        }
                        "%" -> {
                            Color(color = Teal200.toArgb())
                        }
                        "*" -> {
                            Color(color = somewhatRed.toArgb())
                        }
                        "÷" -> {
                            Color(color = somewhatRed.toArgb())
                        }
                        "-" -> {
                            Color(color = somewhatRed.toArgb())
                        }
                        "+" -> {
                            Color(color = somewhatRed.toArgb())
                        }
                        "=" -> {
                            Color(color = somewhatRed.toArgb())
                        }


                        else -> {
                            Color.White
                        }

                    }


                    Text(
                        text = item,
                        fontSize = 19.sp,
                        style = MaterialTheme.typography.h1,
                        color = btnTextColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(15.dp)
                    )
                }
            }

        }

    }
}

/*
 I want to create a function that accepts what ever is received by the 'currentItem' variable
 in line 185 but when an operator (+,\,-) is entered, it takes the digits entered before the
 operator and assigns it to a new variable

*/

fun calcOperations(input: String ): String {




    if (input.isNotBlank()) {
        when (input) {

            "C" -> {



            }

            "+/-" -> {


            }
            "%" -> {

            }

            "*" -> {


            }

            "÷" -> {

            }
            "-" -> {

            }
            "+" -> {

            }
            "=" -> {

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