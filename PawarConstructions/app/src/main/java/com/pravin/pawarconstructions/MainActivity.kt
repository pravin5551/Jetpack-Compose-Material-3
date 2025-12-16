package com.pravin.pawarconstructions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pravin.pawarconstructions.ui.theme.PawarConstructionsTheme
import com.pravin.pawarconstructions.ui.widgets.AlertDialogM3
import com.pravin.pawarconstructions.ui.widgets.AssistChipM3
import com.pravin.pawarconstructions.ui.widgets.CheckboxM3
import com.pravin.pawarconstructions.ui.widgets.ElevatedAssistChipM3
import com.pravin.pawarconstructions.ui.widgets.ElevatedFilterChipM3
import com.pravin.pawarconstructions.ui.widgets.ElevatedSuggestionChipM3
import com.pravin.pawarconstructions.ui.widgets.FilterChipM3
import com.pravin.pawarconstructions.ui.widgets.InputChipM3
import com.pravin.pawarconstructions.ui.widgets.RangeSliderM3
import com.pravin.pawarconstructions.ui.widgets.SliderM3
import com.pravin.pawarconstructions.ui.widgets.SuggestionChipM3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PawarConstructionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {

    var isChecked by remember { mutableStateOf(false) }

    val icons = if (isChecked) Icons.Filled.Check else Icons.Filled.Close

    val icon: (@Composable () -> Unit)? = if (isChecked) {
        {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        }
    } else null


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            thumbContent = icon
        )
        SliderM3()

        CheckboxM3()

        RangeSliderM3()

        AssistChipM3()

        ElevatedAssistChipM3()

        FilterChipM3()

        ElevatedFilterChipM3()

        SuggestionChipM3()

        ElevatedSuggestionChipM3()

        InputChipM3()

        AlertDialogM3()
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    PawarConstructionsTheme {
        MyScreen()
    }
}