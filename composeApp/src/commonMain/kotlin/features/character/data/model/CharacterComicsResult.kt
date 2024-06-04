package features.character.data.model


import features.character.data.model.response.Events
import features.character.data.model.response.Series
import features.character.data.model.response.Url
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterComicsResult(
    @SerialName("characters")
    val characters: Characters,
    @SerialName("collectedIssues")
    val collectedIssues: List<Unit>,
    @SerialName("collections")
    val collections: List<Unit>,
    @SerialName("creators")
    val creators: Creators,
    @SerialName("dates")
    val dates: List<Date>,
    @SerialName("description")
    val description: String,
    @SerialName("diamondCode")
    val diamondCode: String,
    @SerialName("digitalId")
    val digitalId: Int,
    @SerialName("ean")
    val ean: String,
    @SerialName("events")
    val events: Events,
    @SerialName("format")
    val format: String,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<Image>,
    @SerialName("isbn")
    val isbn: String,
    @SerialName("issn")
    val issn: String,
    @SerialName("issueNumber")
    val issueNumber: Int,
    @SerialName("modified")
    val modified: String,
    @SerialName("pageCount")
    val pageCount: Int,
    @SerialName("prices")
    val prices: List<Price>,
    @SerialName("resourceURI")
    val resourceURI: String,
    @SerialName("series")
    val series: Series,
    @SerialName("stories")
    val stories: Stories,
    @SerialName("textObjects")
    val textObjects: List<Unit>,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail,
    @SerialName("title")
    val title: String,
    @SerialName("upc")
    val upc: String,
    @SerialName("urls")
    val urls: List<Url>,
    @SerialName("variantDescription")
    val variantDescription: String,
    @SerialName("variants")
    val variants: List<Variant>
)