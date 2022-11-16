
package com.example.android.tuniflix.ui.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.tuniflix.data.MovieRepository;
import com.example.android.tuniflix.model.MovieDetails;

/**
 * {@link ViewModel} for InformationFragment
 */
public class InfoViewModel extends ViewModel {

    private final MovieRepository mRepository;
    private final LiveData<MovieDetails> mMovieDetails;

    public InfoViewModel (MovieRepository repository, int movieId) {
        mRepository = repository;
        mMovieDetails = mRepository.getMovieDetails(movieId);
    }

    public LiveData<MovieDetails> getMovieDetails() {
        return mMovieDetails;
    }
}
