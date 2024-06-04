package features.character.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("comics")
    val comics: Comics,
    @SerialName("description")
    val description: String,
    @SerialName("events")
    val events: Events,
    @SerialName("id")
    val id: Int,
    @SerialName("modified")
    val modified: String,
    @SerialName("name")
    val name: String,
    @SerialName("resourceURI")
    val resourceURI: String,
    @SerialName("series")
    val series: Series,
    @SerialName("stories")
    val stories: Stories,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail,
    @SerialName("urls")
    val urls: List<Url>
)