package com.coderz.f1.viewstatecompose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun StateActionBar(){
    TopAppBar(backgroundColor =
        if(isSystemInDarkTheme()){
            MaterialTheme.colors.primarySurface
        } else {
            MaterialTheme.colors.primary
        },
        modifier=Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Text(stringResource(R.string.app_name), color=
        if(isSystemInDarkTheme()) {
            MaterialTheme.colors.onSurface
        } else {
            MaterialTheme.colors.onPrimary
        }
        )
    }
}