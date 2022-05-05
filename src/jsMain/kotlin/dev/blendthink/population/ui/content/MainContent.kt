package dev.blendthink.population.ui.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import dev.blendthink.population.ui.component.prefecture.PrefCheckboxes
import dev.blendthink.population.ui.style.AppStylesheet.loading
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.koin.core.context.GlobalContext

@Composable
fun MainContent(notifier: MainContentNotifier = GlobalContext.get().get()) {
    val state = remember { notifier.state }
    val scope = rememberCoroutineScope()

    MainContent(state.value) { prefCode, isChecked ->
        scope.launch {
            println("prefCode: $prefCode, isChecked: $isChecked")
        }
    }

    LaunchedEffect(true) {
        notifier.fetchPrefectures()
    }
}

@Composable
fun MainContent(
    state: MainContentState,
    onChange: (prefCode: Int, isChecked: Boolean) -> Unit,
) {
    when (state) {
        is MainContentState.Initialize,
        is MainContentState.Loading -> {
            Div({ classes(loading) })
        }
        is MainContentState.Success -> {
            Div {
                PrefCheckboxes(state.prefectures, onChange)
            }
        }
        is MainContentState.Failure -> {
            Span {
                Text(state.exception.toString())
            }
        }
    }
}
