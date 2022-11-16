
package com.example.android.tuniflix.ui.trailer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.tuniflix.data.MovieRepository;
import com.example.android.tuniflix.model.VideoResponse;

/**
 * {@link ViewModel} for TrailerFragment
 */
public class TrailerViewModel extends ViewModel {

    private final MovieRepository mRepository;
    private final LiveData<VideoResponse> mVideoResponse;

    public TrailerViewModel (MovieRepository repository, int movieId) {
        mRepository = repository;
        mVideoResponse = mRepository.getVideoResponse(movieId);
    }

    public LiveData<VideoResponse> getVideoResponse() {
        return mVideoResponse;
    }
}
