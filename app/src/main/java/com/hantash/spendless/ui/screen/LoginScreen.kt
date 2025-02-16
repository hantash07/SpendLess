package com.hantash.spendless.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hantash.spendless.R
import com.hantash.spendless.ui.component.AppButton
import com.hantash.spendless.ui.component.AppImage
import com.hantash.spendless.ui.component.AppInputField
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.AppTextButton
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

@Preview(showBackground = true)
@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AppImage(
                    modifier = Modifier.padding(16.dp),
                    resourceId = R.drawable.ic_logo
                )
                Text(
                    text = "Welcome back!",
                    style = MaterialTheme.typography.headlineMedium,
                    color = OnSurface
                )
                Text(
                    text = "Enter your login details",
                    style = MaterialTheme.typography.bodyLarge,
                    color = OnSurfaceVariant
                )
                AppSpacer(value = 32.dp, EnumSpacer.HEIGHT)
                AppInputField(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {},
                    placeHolder = "Username",
                    value = ""
                )
                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                AppInputField(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {},
                    placeHolder = "PIN",
                )
                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                AppButton(
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp),
                    name = "Log in") {

                }
                AppSpacer(value = 16.dp, EnumSpacer.HEIGHT)
                AppTextButton(
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp),
                    name = "New to SpendLess?"
                ) {

                }
            }
        }
    )
}








