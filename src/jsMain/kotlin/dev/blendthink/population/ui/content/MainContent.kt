package dev.blendthink.population.ui.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import dev.blendthink.population.ui.content.graph.GraphContent
import dev.blendthink.population.ui.style.AppStyle.loading
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.koin.core.context.GlobalContext

@Composable
fun MainContent(notifier: MainContentNotifier = GlobalContext.get().get()) {
    val state = remember { notifier.state }

    MainContent(state.value)

    LaunchedEffect(true) {
        notifier.fetchPrefectures()
    }
}

@Composable
fun MainContent(
    state: MainContentState,
) {
    when (state) {
        is MainContentState.Initialize,
        is MainContentState.Loading -> {
            Div({ classes(loading) })
        }
        is MainContentState.Success -> {
            GraphContent(state.prefectures)
        }
        is MainContentState.Failure -> {
            Span {
                Text(state.exception.toString())
            }
        }
    }
}
