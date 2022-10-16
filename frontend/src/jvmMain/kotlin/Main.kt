import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

@Composable
fun App() {
    MaterialTheme {
        var done by remember { mutableStateOf(false) }
        var error by remember { mutableStateOf(false) }
        if (done) DoneScreen(onBack = { done = false })
        else if (!error) MainScreen(onDone = { done = true }, onError = { error = true })
        else ErrorScreen()
    }
}

@Composable
fun MainScreen(onDone: () -> Unit, onError: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Click to kill VS Code")
        Button(onClick = {
            try {
                Runtime.getRuntime().exec("vscode-killer")
                onDone()
            } catch (_: Exception) {
                onError()
            }
        }) {
            Text("Kill")
        }
    }
}

@Composable
fun DoneScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("Done")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}

@Composable
fun ErrorScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
            "Couldn't find vscode-killer. Make sure it's in your PATH.", textAlign = TextAlign.Center
        )
    }
}
