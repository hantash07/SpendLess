package com.hantash.spendless.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.spendless.model.Currency
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant
import com.hantash.spendless.ui.theme.Primary

@Preview(showBackground = true)
@Composable
fun ItemCurrency(currency: Currency = currencyList.first(), isSelected: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier.width(40.dp),
            text = currency.symbol,
            style = MaterialTheme.typography.labelMedium.copy(textAlign = TextAlign.Center),
            color = OnSurface
        )

        Text(
            modifier = Modifier.weight(1f),
            text = currency.name,
            style = MaterialTheme.typography.bodyLarge.copy(color = OnSurfaceVariant),
        )

        if (isSelected) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "Checked Icon",
                tint = Primary,
            )
        }
    }
}