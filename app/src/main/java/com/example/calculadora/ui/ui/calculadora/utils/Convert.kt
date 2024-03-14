package com.example.calculadora.ui.ui.calculadora.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.sp() = with(LocalDensity.current){toSp()}