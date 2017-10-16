package au.com.exaptec.gartner.model;

import java.util.ArrayList;

/**
 * Created by sai on 15/10/2017.
 */

public class DataSource {




    private ArrayList<String> optionsList;

     public void optionListData(){

        optionsList=new ArrayList<>();
        optionsList.add("Morning Session");
        optionsList.add("Lunch Session");
        optionsList.add("Afternoon Session");
    }
    public ArrayList<String> getOptionsList() {
        return optionsList;
    }
    public String getItem(int position){
        return getOptionsList().get(position);
    }

}
