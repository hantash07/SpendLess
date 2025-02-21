package com.hantash.spendless.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.hantash.spendless.ui.navigation.EnumScreen
import com.hantash.spendless.ui.theme.OnSurface

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String = "",
    enumScreen: EnumScreen = EnumScreen.LOGIN,
    onBackButtonClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = OnSurface
        ) },
        navigationIcon = {
            AppBackButton(onButtonClick = {onBackButtonClick.invoke()})
        }
    )
}

@Composable
fun AppBackButton(onButtonClick: () -> Unit = {}) {
    IconButton(onClick = {onButtonClick.invoke()}) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back Icon"
        )
    }
}