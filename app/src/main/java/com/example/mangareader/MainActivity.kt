package com.example.mangareader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mangareader.ui.HomeScreen
import com.example.mangareader.ui.PdfViewerScreen
import android.net.Uri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomeScreen(navController) }
                        composable("pdfViewer/{uri}") { backStackEntry ->
                            val uriString = backStackEntry.arguments?.getString("uri")
                            if (uriString != null) {
                                PdfViewerScreen(Uri.parse(Uri.decode(uriString)))
                            }
                        }
                    }
                }
            }
        }
    }
}
