package au.com.exaptec.gartner.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import javax.inject.Inject;

import au.com.exaptec.gartner.R;
import au.com.exaptec.gartner.dagger.GartnerApplication;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OptionsFragment.ItenClickListener {
    @Inject
    DetailFragment detailFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        ((GartnerApplication) getApplication()).getAppComponent().inject(this);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.detail_fragment_container, detailFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void itemClickUpdate(String sessionText) {
        detailFragment= (DetailFragment) fragmentManager.findFragmentById(R.id.detail_fragment_container);

        if(detailFragment!=null){
//            detailFragment.updateText(sessionText);
        }
    }
}
