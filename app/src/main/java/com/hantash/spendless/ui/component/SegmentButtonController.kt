package com.hantash.spendless.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hantash.spendless.ui.theme.OnPrimaryFixed
import com.hantash.spendless.ui.theme.OnSurface
import com.hantash.spendless.ui.theme.PrimaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentButtonController(
    modifier: Modifier = Modifier,
    name: String = "",
    options: List<String>,
    icons: List<Int> = emptyList(),
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        if (name.isNotEmpty()) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall
            )
            AppSpacer(value = 4.dp, EnumSpacer.HEIGHT)
        }
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = PrimaryContainer.copy(alpha = 0.08f),
                    shape = RoundedCornerShape(16.dp)
                ),
        ) {
            options.forEachIndexed { index, label ->
                val isSelected = selectedOption == label
                SegmentedButton(
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    selected = isSelected,
                    shape = RoundedCornerShape(12.dp),
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = Color.White,
                        inactiveContainerColor = Color.Transparent,
                        activeContentColor = OnSurface,
                        inactiveContentColor = OnPrimaryFixed
                    ),
                    border = SegmentedButtonDefaults.borderStroke(
                        width = 0.dp,
                        color = Color.Transparent
                    ),
                    icon = {
                        if (icons.isNotEmpty()) {
                            Icon(
                                painter = painterResource(icons[index]),
                                contentDescription = "Segmented Button Icon"
                            )
                        }
                    },
                    label = {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    onClick = { onOptionSelected(label) }
                )
            }
        }
    }
}