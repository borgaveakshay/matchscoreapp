package com.assignment.onlinescoreupdateapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.routes.FixtureDetailsRoute
import com.assignment.onlinescoreupdateapp.presentation.fixturedetails.ui.FixtureDetailsParent
import com.assignment.onlinescoreupdateapp.presentation.fixures.routes.FixtureScreenRoute
import com.assignment.onlinescoreupdateapp.presentation.fixures.ui.FixtureScreenParent
import com.example.compose.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = FixtureScreenRoute
                    ) {
                        composable<FixtureDetailsRoute> { navBackStackEntry ->
                            val fixtureDetailsRoute =
                                navBackStackEntry.toRoute<FixtureDetailsRoute>()
                            FixtureDetailsParent(
                                navController = navController,
                                fixtureId = fixtureDetailsRoute.fixtureId
                            )
                        }
                        composable<FixtureScreenRoute> {
                            FixtureScreenParent(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}
