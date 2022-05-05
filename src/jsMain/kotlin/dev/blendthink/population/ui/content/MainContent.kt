package dev.blendthink.population.ui.content

import androidx.compose.runtime.Composable
import dev.blendthink.population.ui.component.prefecture.PrefCheckboxes
import org.jetbrains.compose.web.dom.Div
import org.koin.core.context.GlobalContext

@Composable
fun MainContent(notifier: MainContentNotifier = GlobalContext.get().get()) {

    Div {
        PrefCheckboxes(notifier.prefectures.value) { prefCode, isChecked ->
            println("prefCode: $prefCode, isChecked: $isChecked")
        }
    }

    notifier.fetchPrefectures()
}
