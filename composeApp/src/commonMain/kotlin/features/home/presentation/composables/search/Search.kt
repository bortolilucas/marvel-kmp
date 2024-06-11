package features.home.presentation.composables.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.marvelkmp.core.domain.model.Character
import br.com.marvelkmp.core.presentation.composables.images.GifImage
import br.com.marvelkmp.core.presentation.theme.Theme
import features.home.presentation.composables.CharacterListItem
import features.home.presentation.screens.home.HomeState

@Composable
fun Search(
    searchInput: String,
    state: HomeState,
    onChangeSearchInput: (String) -> Unit,
    onGoToCharacterDetails: (Character) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(all = Theme.spacing.medium),
            shape = RoundedCornerShape(8.dp),
            value = searchInput,
            onValueChange = { onChangeSearchInput(it) },
            label = {
                Text("Search...", color = Theme.colors.onBackground)
            },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Theme.colors.onBackground,
                focusedLabelColor = Theme.colors.onBackground,
                cursorColor = Theme.colors.onBackground,
                textColor = Theme.colors.onBackground,
                unfocusedBorderColor = Theme.colors.onBackground
            )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (state.searchResults.isEmpty() and !state.hasNotFoundResults) {
                GifImage(
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp).padding(bottom = 30.dp),
                    resource = searchResources.typeToSearchResource
                )
                Text(
                    text = "Type to init a search...",
                    style = Theme.typography.h3,
                    color = Theme.colors.onBackground
                )

                return
            }

            if (state.hasNotFoundResults) {
                GifImage(
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(300.dp).padding(top = 80.dp, bottom = 30.dp),
                    resource = searchResources.notFoundResource,
                )
                Text(
                    text = "Not found results for this search",
                    style = Theme.typography.h3,
                    color = Theme.colors.onBackground
                )

                return
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(Theme.spacing.extraLarge),
                horizontalArrangement = Arrangement.spacedBy(Theme.spacing.large),
                contentPadding = PaddingValues(
                    start = Theme.spacing.large,
                    end = Theme.spacing.large,
                    bottom = Theme.spacing.large,
                    top = Theme.spacing.medium
                ),
            ) {
                items(state.searchResults) {
                    CharacterListItem(
                        character = it,
                        onClick = { onGoToCharacterDetails(it) }
                    )
                }
            }
        }
    }
}