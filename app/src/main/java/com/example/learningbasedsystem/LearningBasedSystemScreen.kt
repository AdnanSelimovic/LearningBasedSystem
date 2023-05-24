package com.example.learningbasedsystem

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class LearningBasedSystemScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
}

@Composable
fun LearningBasedSystemAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        }
    )
}


@Composable
fun LearningBasedSystemApp() {
    //Controller and Initialization
    val navController = rememberNavController()

    // Get current back stack entry
    val backStackEntry by
        navController.currentBackStackEntryAsState()

    //Get the name of the current screen
    val currentScreen = LearningBasedSystemScreen.valueOf(
        backStackEntry?.destination?.route ?: LearningBasedSystemScreen.Start.name
    )
}