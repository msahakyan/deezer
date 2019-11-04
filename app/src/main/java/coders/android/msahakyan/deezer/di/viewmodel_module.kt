package coders.android.msahakyan.deezer.di

import coders.android.msahakyan.deezer.viewmodel.HomeViewModel
import coders.android.msahakyan.deezer.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author msahakyan.
 */

val viewModelsModule = module {

    viewModel { HomeViewModel(searchRepository = get()) }

    // Experimental
    viewModel { SearchViewModel(searchRepository = get()) }

}