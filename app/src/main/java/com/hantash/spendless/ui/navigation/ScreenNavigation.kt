package com.hantash.spendless.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hantash.spendless.ui.component.PinCode
import com.hantash.spendless.ui.screen.LoginScreen
import com.hantash.spendless.ui.screen.PinCodeScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val defaultScreen = EnumScreen.PIN_CODE.name

    NavHost(navController = navController, startDestination = defaultScreen) {
        composable(defaultScreen) {
            PinCodeScreen(navController)
        }
    }
}