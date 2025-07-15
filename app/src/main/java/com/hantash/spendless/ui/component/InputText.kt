package com.hantash.spendless.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.spendless.ui.theme.Error
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

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
            modifier = modifier
                .fillMaxWidth()
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
                modifier = modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    modifier = modifier.fillMaxWidth(),
                    onValueChange = onValueChange,
                    value = value,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = OnSurface
                    ),
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
            modifier = modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.08f))
                    .padding(horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    modifier = modifier.align(Alignment.Center),
                    onValueChange = onValueChange,
                    value = value,
                    textStyle = MaterialTheme.typography.displayMedium.copy(
                        textAlign = TextAlign.Center,
                        color = OnSurface
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = keyboardType,
                        imeAction = imeAction
                    ),
                    keyboardActions = keyboardActions,
                )
                if (value.isEmpty()) {
                    Text(
                        text = placeHolder,
                        style = MaterialTheme.typography.displayMedium,
                        color = OnSurface.copy(0.38f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransactionInputField(
    modifier: Modifier = Modifier,
    inputFieldType: InputFieldType = InputFieldType.AMOUNT,
    onValueChange: (String) -> Unit = {},
    value: String = "",
    placeHolder: String = "",
    leadingText: String = "",
    trailingText: String = "",
    leadingIcon: ImageVector? = null,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            modifier = modifier
                .height(if (inputFieldType == InputFieldType.AMOUNT) 64.dp else 24.dp),
//                .width(IntrinsicSize.Min),
            value = value,
            onValueChange = { newValue -> onValueChange(newValue) },
            textStyle = if (inputFieldType == InputFieldType.AMOUNT) MaterialTheme.typography.displayMedium.copy(textAlign = TextAlign.Center) else MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Center),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {

                    Text(
                        text = leadingText,
                        style = if (inputFieldType == InputFieldType.AMOUNT) MaterialTheme.typography.displayMedium else if (inputFieldType == InputFieldType.ENTITY) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                        color = if (inputFieldType == InputFieldType.AMOUNT) Error else OnSurface.copy(alpha = 0.60f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    if (value.isEmpty()) {
                        Text(
                            text = placeHolder,
                            style = if (inputFieldType == InputFieldType.AMOUNT) MaterialTheme.typography.displayMedium else if (inputFieldType == InputFieldType.ENTITY) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                            color = if (inputFieldType == InputFieldType.AMOUNT) OnSurface.copy(0.38f) else OnSurface.copy(0.60f)
                        )
                    }
                    if (value.isNotEmpty()) {
                        Box(modifier = Modifier.width(IntrinsicSize.Min)) {
                            innerTextField()
                        }
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = trailingText,
                        style = MaterialTheme.typography.displayMedium,
                        color = Error
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
        )
    }

}

enum class InputFieldType {
    ENTITY,
    AMOUNT,
    NOTES
}








