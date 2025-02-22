package com.hantash.spendless.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hantash.spendless.ui.navigation.EnumScreen
import com.hantash.spendless.ui.theme.OnPrimary
import com.hantash.spendless.ui.theme.OnSurface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String = "",
    enumScreen: EnumScreen = EnumScreen.LOGIN,
    onBackButtonClick: () -> Unit = {},
    onActionButtonClick: (EnumScreen) -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = if (enumScreen != EnumScreen.DASHBOARD) OnSurface else OnPrimary
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if (enumScreen != EnumScreen.DASHBOARD) {
                AppBackButton(onButtonClick = { onBackButtonClick.invoke() })
            }
        },
        actions = {
            if (enumScreen == EnumScreen.DASHBOARD) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = OnPrimary.copy(alpha = 0.12f),
                            shape = RoundedCornerShape(corner = CornerSize(16.dp))
                        )
                        .clickable {
                            onActionButtonClick.invoke(enumScreen)
                        }
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp)
                            .align(Alignment.Center),
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = "Settings Icon",
                        tint = OnPrimary
                    )
                }
            }
        }
    )
}

@Composable
fun AppBackButton(onButtonClick: () -> Unit = {}) {
    IconButton(onClick = { onButtonClick.invoke() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back Icon"
        )
    }
}