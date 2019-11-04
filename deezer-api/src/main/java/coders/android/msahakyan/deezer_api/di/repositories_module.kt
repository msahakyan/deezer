package coders.android.msahakyan.deezer_api.di


import coders.android.msahakyan.deezer_api.repository.AlbumRepository
import coders.android.msahakyan.deezer_api.repository.SearchRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single {
        SearchRepository(searchApi = get())
    }

    single {
        AlbumRepository(albumApi = get())
    }
}