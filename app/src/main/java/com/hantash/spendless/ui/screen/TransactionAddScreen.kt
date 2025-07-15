package com.hantash.spendless.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.R
import com.hantash.spendless.ui.component.AppButton
import com.hantash.spendless.ui.component.AppDropDownMenu
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.component.InputFieldType
import com.hantash.spendless.ui.component.SegmentButtonController
import com.hantash.spendless.ui.component.TransactionInputField

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun TransactionAddScreen(
    navController: NavController? = null,
    dismiss: Boolean = true,
    onClose: () -> Unit = {}
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = onClose,
        sheetState = sheetState
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun BottomSheetContent(onClose: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier =  Modifier.weight(1f),
                text = "Create Transaction",
                style = MaterialTheme.typography.titleLarge
            )
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = onClose
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "Closed Icon"
                )
            }
        }

        SegmentButtonController(
            modifier = Modifier.padding(top = 16.dp),
            options = TransactionType.entries.map { it.value },
            icons = TransactionType.entries.map { it.icon },
            selectedOption = TransactionType.EXPENSE.value,
        ) { }

        Column(

        ) {
            TransactionInputField(
                inputFieldType = InputFieldType.ENTITY,
                placeHolder = "Receiver",
            )
            AppSpacer(value = 10.dp, EnumSpacer.HEIGHT)
            TransactionInputField(
                inputFieldType = InputFieldType.AMOUNT,
                leadingText = "$",
                placeHolder = "00.00",
            )
            AppSpacer(value = 10.dp, EnumSpacer.HEIGHT)
            TransactionInputField(
                inputFieldType = InputFieldType.NOTES,
                leadingText = "+",
                placeHolder = "Add Note",
            )
        }

    }

    Box(modifier = Modifier.fillMaxSize()
        .padding(16.dp)) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            AppDropDownMenu()
            AppButton(name = "Create")
        }
    }
}


enum class TransactionType(val value: String, val icon: Int) {
    EXPENSE("Expense", R.drawable.ic_expense),
    INCOME("Income", R.drawable.ic_income)
}








