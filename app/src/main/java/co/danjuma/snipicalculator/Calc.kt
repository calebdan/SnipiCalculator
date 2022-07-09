package co.danjuma.snipicalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.danjuma.snipicalculator.ui.theme.BabyBlue

@Composable
fun Calc(
    state: CalcState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalcAction) -> Unit
) {
    Box(modifier = modifier) {
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
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
                color = Color.White,
                maxLines = 2
            )

            Text(
                text = "12,939",
                style = MaterialTheme.typography.h1,
                color = Color.White,
                textAlign = TextAlign.End
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                CalcButton(symbol = "AC", modifier = Modifier
                    .background(color = BabyBlue),
                    onClick = {
                        onAction(CalcAction.Clear)
                    }
                )
                CalcButton(symbol = "\u00B1", modifier = Modifier
                    .background(color = BabyBlue),
                    onClick = {
                        onAction(CalcAction.Clear)
                    }
                )
                CalcButton(symbol = "%", modifier = Modifier
                    .background(color = BabyBlue),
                    onClick = {
                        onAction(CalcAction.Clear)
                    }
                )
                CalcButton(symbol = "\u00F7", modifier = Modifier
                    .background(color = BabyBlue),
                    onClick = {
                        onAction(CalcOperation.Divide)
                    }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {

                    CalcButton(symbol = "7", modifier = Modifier
                        .background(color = BabyBlue),
                        onClick = {
                            onAction(CalcAction.Number(7))
                        }
                    )
                    CalcButton(symbol = "8", modifier = Modifier
                        .background(color = BabyBlue),
                        onClick = {
                            onAction(CalcAction.Number(8))
                        }
                    )
                    CalcButton(symbol = "9", modifier = Modifier
                        .background(color = BabyBlue),
                        onClick = {
                            onAction(CalcAction.Number(9))
                        }
                    )
                    CalcButton(symbol = "\u00D7", modifier = Modifier
                        .background(color = BabyBlue),
                        onClick = {
                            onAction(CalcOperation.Multiply)
                        }
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                    ) {

                        CalcButton(symbol = "4", modifier = Modifier
                            .background(color = BabyBlue),
                            onClick = {
                                onAction(CalcAction.Number(4))
                            }
                        )
                        CalcButton(symbol = "5", modifier = Modifier
                            .background(color = BabyBlue),
                            onClick = {
                                onAction(CalcAction.Number(5))
                            }
                        )
                        CalcButton(symbol = "6", modifier = Modifier
                            .background(color = BabyBlue),
                            onClick = {
                                onAction(CalcAction.Number(6))
                            }
                        )
                        CalcButton(symbol = "-", modifier = Modifier
                            .background(color = BabyBlue),
                            onClick = {
                                onAction(CalcOperation.Subtract)
                            }
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalcButton(symbol = "1", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Number(1))
                                }
                            )
                            CalcButton(symbol = "2", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Number(2))
                                }
                            )
                            CalcButton(symbol = "3", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Number(3))
                                }
                            )
                            CalcButton(symbol = "+", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcOperation.Add)
                                }
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {

                            CalcButton(symbol = "H", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Clear)
                                }
                            )
                            CalcButton(symbol = "0", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Number(0))
                                }
                            )
                            CalcButton(symbol = ".", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Decimal)
                                }
                            )
                            CalcButton(symbol = "=", modifier = Modifier
                                .background(color = BabyBlue),
                                onClick = {
                                    onAction(CalcAction.Calculate)
                                }
                            )
                        }
                    }
                }

            }
        }
    }
}
