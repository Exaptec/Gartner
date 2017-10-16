package au.com.exaptec.gartner.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sai on 16/10/2017.
 */
@Module
public class AppModule {

        private Application application;

        public AppModule(Application application) {
            this.application = application;
        }

        @Provides
        @Singleton
        public Context provideContext() {
            return application;
        }

}
