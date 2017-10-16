package au.com.exaptec.gartner.dagger;

import javax.inject.Singleton;

import au.com.exaptec.gartner.ui.DetailFragment;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sai on 16/10/2017.
 */
@Module
public class FragmentModule {
    @Singleton
    @Provides
    DetailFragment providesDetailFragment(){
        return new DetailFragment();
    }
}
