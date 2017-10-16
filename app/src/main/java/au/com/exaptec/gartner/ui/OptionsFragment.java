package au.com.exaptec.gartner.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;

import au.com.exaptec.gartner.dagger.GartnerApplication;
import au.com.exaptec.gartner.model.DataSource;
import butterknife.OnClick;

/**
 * Created by sai on 15/10/2017.
 */

public class OptionsFragment extends ListFragment {
    @Inject
    DataSource dataSource;

    private MainActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (MainActivity) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((GartnerApplication)(getContext().getApplicationContext())).getAppComponent().inject(this);
        dataSource.optionListData();
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, dataSource.getOptionsList()));
    }


    public interface  ItenClickListener {
       public void itemClickUpdate(String session);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        mActivity.itemClickUpdate(dataSource.getItem(position));
    }
}
