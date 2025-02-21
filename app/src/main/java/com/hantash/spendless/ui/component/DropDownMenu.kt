package com.hantash.spendless.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.spendless.model.Currency
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier.fillMaxWidth(),
    items: List<Currency> = currencyList,
    selectedItem: Currency = items.first(),
    onSelectItem: (Currency) -> Unit = {},
    expanded: Boolean = true,
    onExpandedChange: (Boolean) -> Unit = {}
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) {
        OutlinedTextField(
            modifier = modifier
                .height(58.dp)
                .menuAnchor(),
            value = selectedItem.name,
            onValueChange = {},
            readOnly = true,
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = OnSurfaceVariant),
            leadingIcon = {
                Text(
                    text = selectedItem.symbol,
                    style = MaterialTheme.typography.labelMedium,
                    color = OnSurface
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "DropDownArrow Icon"
                )
            },
        )
    }
}

val currencyList = listOf(
    Currency("$", "US Dollar (USD)"),
    Currency("€", "Euro ()"),
    Currency("£", "British Pound Sterling (GBP)"),
    Currency("¥", "Japanese Yen (JPY)"),
    Currency("CHF", "Swiss Franc (CFH)"),
    Currency("C$", "Canadian Dollar (CAD)"),
    Currency("A$", "Australian Dollar (AUD)"),
    Currency("¥", "Chinese Yuan Renminbi (CNY)"),
    Currency("₹", "Indian Rupee (INR)"),
    Currency("R", "South African Rand (ZAR)"),
)