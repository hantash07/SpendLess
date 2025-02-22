package com.hantash.spendless.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hantash.spendless.ui.component.AppTopBar
import com.hantash.spendless.ui.navigation.EnumScreen
import com.hantash.spendless.ui.theme.Background
import com.hantash.spendless.ui.theme.OnPrimary
import com.hantash.spendless.ui.theme.OnPrimaryFixed
import com.hantash.spendless.ui.theme.OnSecondaryContainer
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.Primary
import com.hantash.spendless.ui.theme.SecondaryContainer
import com.hantash.spendless.ui.theme.Surface

@Preview(showBackground = true)
@Composable
fun DashboardScreen(navController: NavController? = null) {
    Scaffold(
        containerColor = OnPrimaryFixed,
        topBar = {
            AppTopBar(
                enumScreen = EnumScreen.DASHBOARD,
                title = "username123"
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                BalanceUI(Modifier.weight(4f))
                TransactionsUI(Modifier.weight(6f))
            }
        },
        floatingActionButton = {
            FloatingButton {

            }
        }
    )
}

@Composable
private fun BalanceUI(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$10,382.45",
                style = MaterialTheme.typography.displayLarge,
                color = OnPrimary
            )
            Text(
                text = "Account Balance",
                style = MaterialTheme.typography.bodyMedium,
                color = OnPrimary
            )
        }
    }
}

@Composable
private fun TransactionsUI(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = Background)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
    ) {

    }
}

@Composable
private fun FloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        containerColor = SecondaryContainer,
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = "Add Icon",
            tint = OnSecondaryContainer
        )
    }
}









