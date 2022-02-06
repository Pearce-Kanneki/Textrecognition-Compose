package com.kanneki.textrecognition

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.kanneki.textrecognition.ui.theme.TextRecognitionTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST = 34
    }

    private fun foregroundPermissionApproved(context: Context): Boolean {
        return PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(
            context, Manifest.permission.CAMERA
        )
    }

    private fun requestForegroundPermission(context: Context) {
        val provideRationale = foregroundPermissionApproved(context)

        if (provideRationale) {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST
            )
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextRecognitionTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        requestForegroundPermission(this@MainActivity)
                        TopAppBar(title = {
                            Text(
                                text = "Text Recognition",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        })
                        MLKitTextRecognition()
                    }
                }
            }
        }
    }
}

