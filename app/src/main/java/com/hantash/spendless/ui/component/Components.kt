package com.hantash.spendless.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hantash.spendless.R
import com.hantash.spendless.ui.theme.OnBackground
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

enum class EnumSpacer {
    WIDTH,
    HEIGHT
}

@Preview(showBackground = true)
@Composable
fun AppImage(modifier: Modifier = Modifier, resourceId: Int = R.drawable.ic_logo) {
    Image(
        modifier = modifier,
        painter = painterResource(resourceId),
        contentDescription = "Image Logo"
    )
}

@Preview(showBackground = true)
@Composable
fun AppInputField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    value: String = "",
    placeHolder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    if (placeHolder != "username") {
        Card(
            modifier = modifier.fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(
                width = 1.dp,
                color = if (value.isNotEmpty()) MaterialTheme.colorScheme.primary else Color.Transparent
            )
        ) {
            Box(
                modifier = modifier.fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    modifier = modifier.fillMaxWidth(),
                    onValueChange = onValueChange,
                    value = value,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    keyboardActions = keyboardActions
                )
                if (value.isEmpty()) {
                    Text(
                        text = placeHolder,
                        style = MaterialTheme.typography.bodyLarge,
                        color = OnSurfaceVariant
                    )
                }
            }
        }
    } else {
        Card(
            modifier = modifier.fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary),
        ) {
            Box(
                modifier = modifier.fillMaxSize()
                    .alpha(0.08f)
                    .background(OnBackground)
                    .padding(horizontal =  10.dp),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    modifier = modifier.align(Alignment.Center),
                    onValueChange = onValueChange,
                    value = value,
                    textStyle = MaterialTheme.typography.displayMedium,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    keyboardActions = keyboardActions,
                )
                if (value.isEmpty()) {
                    Text(
                        modifier = modifier
                            .alpha(0.38f),
                        text = placeHolder,
                        style = MaterialTheme.typography.displayMedium,
                        color = OnSurface
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    name: String = "",
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppTextButton(
    modifier: Modifier = Modifier,
    name: String = "",
    onClick: () -> Unit = {}
) {
    TextButton (
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleMedium
        )
    }
}


@Composable
fun AppSpacer(value: Dp, enumSpacer: EnumSpacer) {
    Spacer(
        modifier = if (enumSpacer == EnumSpacer.WIDTH) Modifier.width(value) else Modifier.height(value)
    )
}