package com.hantash.spendless.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.ui.component.AppButton
import com.hantash.spendless.ui.component.AppCard
import com.hantash.spendless.ui.component.AppDropDownMenu
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.AppTopBar
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.component.SegmentButtonController
import com.hantash.spendless.ui.component.currencyList
import com.hantash.spendless.utils.debug

@Preview(showBackground = true)
@Composable
fun PreferencesScreen(navController: NavController? = null) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var currency by remember {
        mutableStateOf(currencyList.first())
    }

    Scaffold(
        topBar = {
            AppTopBar(title = "Preferences")
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                AppCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "-\$10,382.45",
                            style = MaterialTheme.typography.headlineLarge,
                        )
                        Text(
                            text = "spend this month",
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }

                SegmentButtonController(
                    modifier = Modifier.padding(top = 16.dp),
                    name = "Expenses format",
                    options = ExpensesFormat.entries.map { it.value },
                    selectedOption = ExpensesFormat.MINUS.value,
                    onOptionSelected = {}
                )

                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                Text(
                    text = "Currency",
                    style = MaterialTheme.typography.labelSmall
                )
                AppSpacer(value = 4.dp, EnumSpacer.HEIGHT)
                AppDropDownMenu(
                    items = currencyList,
                    selectedItem = currency,
                    onSelectItem = { item ->
                        currency = item
                    },
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                        debug("Expanded: $expanded")
                    }
                )

                SegmentButtonController(
                    modifier = Modifier.padding(top = 16.dp),
                    name = "Decimal Separator",
                    options = DecimalSeparator.entries.map { it.value },
                    selectedOption = DecimalSeparator.DOT.value,
                    onOptionSelected = {}
                )

                SegmentButtonController(
                    modifier = Modifier.padding(top = 16.dp),
                    name = "Thousands Separator",
                    options = ThousandsSeparator.entries.map { it.value },
                    selectedOption = ThousandsSeparator.DOT.value,
                    onOptionSelected = {}
                )

                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                AppButton(
                    name = "Save",
                    onClick = {}
                )
            }
        }
    )
}

enum class ExpensesFormat(val value: String) {
    MINUS("-\$10"),
    BRACKETS("($10)")
}

enum class DecimalSeparator(val value: String) {
    DOT("1.00"),
    COMMA("1,00")
}

enum class ThousandsSeparator(val value: String) {
    DOT("1.000"),
    COMMA("1,000"),
    SPACE("1 000")
}