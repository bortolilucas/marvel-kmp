import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import io.ktor.client.request.get
import kotlinx.coroutines.launch
import network.service.apiService

class TestScreenModel() : ScreenModel {

    fun test() {
        screenModelScope.launch {
            val response = apiService.get("comics")

            println(response)
        }
    }
}