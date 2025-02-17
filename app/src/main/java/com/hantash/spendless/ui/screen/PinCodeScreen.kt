package com.hantash.spendless.ui.screen

import android.util.Log
import androidx.collection.mutableIntListOf
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavHostController
import com.hantash.spendless.R
import com.hantash.spendless.ui.component.AppBackButton
import com.hantash.spendless.ui.component.AppImage
import com.hantash.spendless.ui.component.AppSpacer
import com.hantash.spendless.ui.component.AppTopBar
import com.hantash.spendless.ui.component.EnumSpacer
import com.hantash.spendless.ui.component.PinCode
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.OnSurfaceVariant

@Preview(showBackground = true)
@Composable
fun PinCodeScreen(navController: NavHostController? = null) {
    var pinCode by remember {
        mutableStateOf("")
    }

    Scaffold(
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AppBackButton(onButtonClick = {})
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppImage(
                        modifier = Modifier.padding(16.dp),
                        resourceId = R.drawable.ic_logo
                    )
                    Text(
                        text = "Create PIN",
                        style = MaterialTheme.typography.headlineMedium,
                    )
                    AppSpacer(value = 8.dp, enumSpacer = EnumSpacer.HEIGHT)
                    Text(
                        text = "Use PIN to login to your account",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    PinCode(
                        pinCode = pinCode,
                        onPinChange = { pin ->
                            if (pin == "-") {
                                pinCode = pinCode.dropLast(1)
                            } else if (pin.isNotEmpty()) {
                                pinCode += pin
                            }
                            Log.d("app-debug", "PINCODE: $pinCode")
                        }
                    )
                }
            }
        }
    )
}