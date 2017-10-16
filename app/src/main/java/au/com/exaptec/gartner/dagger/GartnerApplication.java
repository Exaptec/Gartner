package au.com.exaptec.gartner.dagger;

import android.app.Application;

/**
 * Created by sai on 16/10/2017.
 */

public class GartnerApplication extends Application {
    AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent=initDagger(this);
    }


    protected AppComponent initDagger(Application application) {
        return DaggerAppComponent.builder()
                .dataModule(new DataModule())
                .fragmentModule(new FragmentModule())
                .build();
    }
}
