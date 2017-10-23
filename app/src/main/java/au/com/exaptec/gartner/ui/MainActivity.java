package au.com.exaptec.gartner.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.qihancloud.opensdk.base.TopBaseActivity;
import com.qihancloud.opensdk.beans.FuncConstant;
import com.qihancloud.opensdk.function.unit.SpeechManager;

import javax.inject.Inject;

import au.com.exaptec.gartner.R;
import au.com.exaptec.gartner.adapter.RecyclerViewRecyclerAdapter;
import au.com.exaptec.gartner.dagger.GartnerApplication;

public class MainActivity extends TopBaseActivity implements OptionsFragment.ItenClickListener, RecyclerViewRecyclerAdapter.RobotSpeak {
    @Inject
    DetailFragment detailFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SpeechManager speechManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        ((GartnerApplication) getApplication()).getAppComponent().inject(this);
        speechManager = (SpeechManager) getUnitManager(FuncConstant.SPEECH_MANAGER);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.detail_fragment_container, detailFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onMainServiceConnected() {

    }


    @Override
    public void itemClickUpdate(String sessionText) {
        detailFragment= (DetailFragment) fragmentManager.findFragmentById(R.id.detail_fragment_container);

        if(detailFragment!=null){
            detailFragment.updateLists(sessionText);
        }
    }

    @Override
    public void speakQuestion(String Text) {
        speechManager.startSpeak(Text);
    }
}
