package com.hantash.spendless.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.R
import com.hantash.spendless.ui.component.AppCard
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.AppTopBar
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.component.ItemSettings

@Preview(showBackground = true)
@Composable
fun SettingsScreen(navController: NavController? = null) {
    Scaffold(
        topBar = {
            AppTopBar(title = "Settings", onBackButtonClick = {})
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                AppCard {
                    ItemSettings(image = R.drawable.ic_preferences, text = "Preferences") {

                    }
                    ItemSettings(image = R.drawable.ic_security, text = "Security") {

                    }
                }
                

                AppSpacer(value = 8.dp, EnumSpacer.HEIGHT)

                AppCard{
                    ItemSettings(image = R.drawable.ic_logout, text = "Log out") {

                    }
                }
            }
        }
    )
}