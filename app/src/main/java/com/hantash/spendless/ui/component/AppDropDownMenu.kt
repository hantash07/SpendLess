package com.hantash.spendless.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.hantash.spendless.model.Currency
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppDropDownMenu(
    modifier: Modifier = Modifier.fillMaxWidth(),
    items: List<Currency> = currencyList,
    selectedItem: Currency = items.first(),
    onSelectItem: (Currency) -> Unit = {},
    expanded: Boolean = false,
    onExpandedChange: () -> Unit = {}
) {
    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { onExpandedChange.invoke() }
    ) {
        AppCard(
            modifier = Modifier
//                .padding(bottom = if (expanded) 8.dp else 0.dp)
                .padding(bottom = 8.dp)
                .menuAnchor()
                .height(48.dp),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = selectedItem.symbol,
                    style = MaterialTheme.typography.labelMedium,
                    color = OnSurface
                )

                BasicTextField(
                    modifier = Modifier.weight(1f),
                    value = selectedItem.name,
                    onValueChange = {},
                    readOnly = true,
                    singleLine = true,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = OnSurfaceVariant),
                )

                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "DropDownArrow Icon"
                )
            }
        }
        DropdownMenu(
            modifier = Modifier
                .exposedDropdownSize()
                .offset(y = 8.dp)
                .height(230.dp),
            expanded = expanded,
            onDismissRequest = { //called when the user requests to dismiss the menu, such as by tapping outside the menu's bounds
                onExpandedChange.invoke()
            }
        ) {
            items.forEach { currency ->
                DropdownMenuItem(
                    text = {
                        ItemCurrency(currency, selectedItem == currency)
                    },
                    onClick = {
                        onSelectItem(currency)
                        onExpandedChange.invoke()
                    }
                )
            }
        }
    }

}

val currencyList = listOf(
    Currency("$", "US Dollar (USD)"),
    Currency("€", "Euro (EUR)"),
    Currency("£", "British Pound Sterling (GBP)"),
    Currency("¥", "Japanese Yen (JPY)"),
    Currency("CHF", "Swiss Franc (CFH)"),
    Currency("C$", "Canadian Dollar (CAD)"),
    Currency("A$", "Australian Dollar (AUD)"),
    Currency("¥", "Chinese Yuan Renminbi (CNY)"),
    Currency("₹", "Indian Rupee (INR)"),
    Currency("R", "South African Rand (ZAR)"),
)