package au.com.exaptec.gartner.dagger;

import android.content.Context;

import javax.inject.Singleton;

import au.com.exaptec.gartner.model.DataSource;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sai on 16/10/2017.
 */
@Module
public class DataModule {


    @Singleton
    @Provides
    DataSource providesDataSource(){
        return new DataSource();
    }
}
