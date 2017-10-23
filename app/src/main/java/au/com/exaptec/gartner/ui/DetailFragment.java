package au.com.exaptec.gartner.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import au.com.exaptec.gartner.R;
import au.com.exaptec.gartner.adapter.RecyclerViewRecyclerAdapter;
import au.com.exaptec.gartner.dagger.GartnerApplication;
import au.com.exaptec.gartner.model.DataSource;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sai on 16/10/2017.
 */

public class DetailFragment extends Fragment {

    @Inject
    DataSource dataSource;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ArrayList<String> dataQuestions;
    private ArrayList<String> dataAnswers;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((GartnerApplication) (getContext().getApplicationContext())).getAppComponent().inject(this);
        dataSource.setMorningsessionList();
        /*recyclerView.setAdapter(new RecyclerViewRecyclerAdapter(dataSource.getMorningSessionQuestions()));*/

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        ButterKnife.bind(this, view);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Log.d("data", data.get(0));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateLists(String sessionText) {
        intialiseLists(sessionText);
        recyclerView.swapAdapter(new RecyclerViewRecyclerAdapter(dataQuestions, dataAnswers, mainActivity), true);

    }

    private void intialiseLists(String sessionText) {

        switch (sessionText) {
            case DataSource.MORNINGSESSION:
                dataQuestions = dataSource.getMorningSessionQuestions();
                dataAnswers = dataSource.getMorningSessionAnswers();
                break;
            case DataSource.AFTERNOONSESSION:
                dataQuestions = dataSource.getMorningSessionQuestions();
                dataAnswers = dataSource.getMorningSessionAnswers();
                break;
            default:
                dataQuestions = dataSource.getMorningSessionQuestions();
                dataAnswers = dataSource.getMorningSessionAnswers();
        }
    }


  /*  public void updateText( String text){

        ArrayList<String> keyList=dataSource.getmorningSessionList();
        list.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, keyList));

    }*/
}
