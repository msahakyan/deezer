package coders.android.msahakyan.deezer.di

import coders.android.msahakyan.deezer.viewmodel.HomeViewModel
import coders.android.msahakyan.deezer.viewmodel.HomeViewModelChannels
import coders.android.msahakyan.deezer.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author msahakyan.
 */

val viewModelsModule = module {

    viewModel { HomeViewModel(searchRepository = get(), genreRepository = get()) }
    viewModel { HomeViewModelChannels(searchRepository = get(), genreRepository = get()) }

    // TODO: Should be removed
    viewModel { SearchViewModel(searchRepository = get()) }

}