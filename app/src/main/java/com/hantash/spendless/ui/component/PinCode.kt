package com.hantash.spendless.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.R
import com.hantash.spendless.ui.theme.OnBackground
import com.hantash.spendless.ui.theme.OnPrimary
import com.hantash.spendless.ui.theme.OnPrimaryFixed
import com.hantash.spendless.ui.theme.Primary
import com.hantash.spendless.ui.theme.PrimaryFixed

@Preview(showBackground = true)
@Composable
fun PinCode(
    modifier: Modifier = Modifier,
    pinCode: String = "",
    pinSize: Int = 5,
    onPinChange: (String) -> Unit = {}
) {

    val buttonList = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("", "0", "-"),
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppSpacer(value = 32.dp, EnumSpacer.HEIGHT)

        //Pin Indicators UI
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(pinSize) { index ->
                Box(
                    modifier = modifier
                        .size(18.dp)
                        .background(
                            color = if (index < pinCode.length) Primary else OnBackground.copy(alpha = 0.12f),
                            shape = CircleShape
                        )
                )
            }
        }

        AppSpacer(value = 32.dp, EnumSpacer.HEIGHT)

        //Number Pad UI
        buttonList.forEach { innerButtons ->
            Row {
                innerButtons.forEach { button ->
                    PadItem(value = button, onPinChange = onPinChange)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PadItem(value: String = "0", onPinChange: (String) -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .size(108.dp)
            .background(
                color = if (value.isNotEmpty() && value != "-") PrimaryFixed else
                    if (value == "-") PrimaryFixed.copy(alpha = 0.30f) else Color.Transparent,
                shape = RoundedCornerShape(corner = CornerSize(32.dp))
            )
            .clickable { if (value.isNotEmpty()) onPinChange.invoke(value) },
        contentAlignment = Alignment.Center
    ) {
        if (value != "-") {
            Text(
                text = value,
                style = MaterialTheme.typography.headlineLarge,
                color = OnPrimaryFixed
            )
        } else {
            Image(
                painter = painterResource(R.drawable.ic_delete_pin),
                contentDescription = "Image Logo"
            )
        }
    }
}










