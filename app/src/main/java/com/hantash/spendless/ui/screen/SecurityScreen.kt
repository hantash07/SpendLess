package com.hantash.spendless.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.ui.component.AppButton
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.AppTopBar
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.component.SegmentButtonController

@Preview(showBackground = true)
@Composable
fun SecurityScreen(navController: NavController? = null) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "Security",
                onBackButtonClick = {}
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {

                SegmentButtonController(
                    name = "Session expiry duration",
                    options = ExpiryDuration.entries.map { it.value },
                    selectedOption = ExpiryDuration.FIVE_MINUTE.value,
                ) { }

                SegmentButtonController(
                    modifier = Modifier.padding(top = 16.dp),
                    name = "Locked out duration",
                    options = LockedDuration.entries.map { it.value },
                    selectedOption = LockedDuration.FIFTEEN_SECOND.value,
                ) { }

                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                AppButton(
                    name = "Save",
                    onClick = {}
                )
            }
        }
    )
}

enum class ExpiryDuration(val value: String) {
    FIVE_MINUTE("5 min"),
    FIFTEEN_MINUTE("15 min"),
    THIRTY_MINUTE("30 min"),
    ONE_HOUR("1 hour"),
}

enum class LockedDuration(val value: String) {
    FIFTEEN_SECOND("15s"),
    THIRTY_SECOND("30s"),
    ONE_MINUTE("1 min"),
    FIVE_MINUTE("5 min"),
}