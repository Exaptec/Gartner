package au.com.exaptec.gartner.dagger;

import javax.inject.Singleton;

import au.com.exaptec.gartner.ui.MainActivity;
import au.com.exaptec.gartner.ui.OptionsFragment;
import dagger.Component;

/**
 * Created by sai on 16/10/2017.
 */
@Singleton
@Component (modules = {DataModule.class,FragmentModule.class})
public interface AppComponent {


    void inject(OptionsFragment fragment);

    void inject(MainActivity activity);
}
