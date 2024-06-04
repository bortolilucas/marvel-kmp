package features.character.data.model


import features.character.data.model.response.Events
import features.character.data.model.response.Series
import features.character.data.model.response.Url
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterComicsResult(
    @SerialName("id")
    val id: Int?,
    @SerialName("digitalId")
    val digitalId: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("issueNumber")
    val issueNumber: Int?,
    @SerialName("variantDescription")
    val variantDescription: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("modified")
    val modified: String?,
    @SerialName("isbn")
    val isbn: String?,
    @SerialName("upc")
    val upc: String?,
    @SerialName("diamondCode")
    val diamondCode: String?,
    @SerialName("ean")
    val ean: String?,
    @SerialName("issn")
    val issn: String?,
    @SerialName("format")
    val format: String?,
    @SerialName("pageCount")
    val pageCount: Int?,
    @SerialName("textObjects")
    val textObjects: List<TextObjectsItem>?,
    @SerialName("resourceURI")
    val resourceURI: String?,
    @SerialName("urls")
    val urls: List<Url>?,
    @SerialName("series")
    val series: Variant?,
    @SerialName("variants")
    val variants: List<Variant>?,
    @SerialName("collections")
    val collections: List<Variant>?,
    @SerialName("collectedIssues")
    val collectedIssues: List<Variant>?,
    @SerialName("dates")
    val dates: List<Date>?,
    @SerialName("prices")
    val prices: List<Price>?,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerialName("images")
    val images: List<Image>?,
    @SerialName("creators")
    val creators: Creators?,
    @SerialName("characters")
    val characters: Characters?,
    @SerialName("stories")
    val stories: Stories?,
    @SerialName("events")
    val events: Events?,
)