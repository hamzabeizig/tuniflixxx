
package com.example.android.tuniflix.utilities;

import android.content.Context;

import com.example.android.tuniflix.AppExecutors;
import com.example.android.tuniflix.data.MovieDatabase;
import com.example.android.tuniflix.data.MovieRepository;
import com.example.android.tuniflix.ui.main.FavViewModelFactory;
import com.example.android.tuniflix.ui.info.InfoViewModelFactory;
import com.example.android.tuniflix.ui.main.MainViewModelFactory;
import com.example.android.tuniflix.ui.review.ReviewViewModelFactory;
import com.example.android.tuniflix.ui.trailer.TrailerViewModelFactory;

/**
 * Provides static methods to inject the various classes needed for PopularMovies
 */
public class InjectorUtils {

    public static MovieRepository provideRepository(Context context) {
        MovieDatabase database = MovieDatabase.getInstance(context.getApplicationContext());
        AppExecutors executors = AppExecutors.getInstance();
        // The Retrofit class generates an implementation of the TheMovieApi interface
        TheMovieApi theMovieApi = Controller.getClient().create(TheMovieApi.class);
        return MovieRepository.getInstance(database.movieDao(), theMovieApi, executors);
    }

    public static MainViewModelFactory provideMainActivityViewModelFactory(Context context, String sortCriteria) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new MainViewModelFactory(repository, sortCriteria);
    }

    public static InfoViewModelFactory provideInfoViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new InfoViewModelFactory(repository, movieId);
    }

    public static ReviewViewModelFactory provideReviewViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new ReviewViewModelFactory(repository, movieId);
    }

    public static TrailerViewModelFactory provideTrailerViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new TrailerViewModelFactory(repository, movieId);
    }

    public static FavViewModelFactory provideFavViewModelFactory(Context context, int movieId) {
        MovieRepository repository = provideRepository(context.getApplicationContext());
        return new FavViewModelFactory(repository, movieId);
    }
}
