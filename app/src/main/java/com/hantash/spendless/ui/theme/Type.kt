package com.hantash.spendless.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.hantash.spendless.R

val figtree = FontFamily(
    Font(
        resId = R.font.figtree_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.figtree_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.figtree_semibold,
        weight = FontWeight.SemiBold
    ),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        textAlign = TextAlign.Center
    ),
    displayMedium = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        textAlign = TextAlign.Center
    ),

    headlineLarge = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        textAlign = TextAlign.Center
    ),
    headlineMedium = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        textAlign = TextAlign.Center
    ),

    titleLarge = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 26.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),

    labelMedium = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = figtree,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),

    bodyLarge = TextStyle( //Medium
        fontFamily = figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle( //Small
        fontFamily = figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle( //x-Small
        fontFamily = figtree,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
)