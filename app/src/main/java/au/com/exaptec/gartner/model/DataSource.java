package au.com.exaptec.gartner.model;

import java.util.ArrayList;

/**
 * Created by sai on 15/10/2017.
 */

public class DataSource {


    public static final String MORNINGSESSION = "MorningSession";
    public static final String AFTERNOONSESSION = "AfternoonSession";
    public static final String EVENINGSESSION = "EveningSession";
    ArrayList<String> MorningSessionQuestions = new ArrayList<>();
    ArrayList<String> MorningSessionAnswers = new ArrayList<>();
    ArrayList<String> AfternoonSessionQuestions = new ArrayList<>();
    ArrayList<String> AfternoonSessionAnswers = new ArrayList<>();
    ArrayList<String> EveningSessionQuestions = new ArrayList<>();
    ArrayList<String> EveningSessionAnswers = new ArrayList<>();
    /* public DataSource(Context context)
     {
         mcontext=context;
     }*/
    private ArrayList<String> optionsList;

    public void optionListData() {
        optionsList = new ArrayList<>();
        optionsList.add(MORNINGSESSION);
        /*optionsList.add(AFTERNOONSESSION);
        optionsList.add(EVENINGSESSION);*/
    }

    public ArrayList<String> getOptionsList() {
        return optionsList;
    }

    public String getItem(int position) {
        return getOptionsList().get(position);
    }



    private void saveAfternoonSessionData() {
    }

    private void saveEveningSessionData() {
    }
/*
    private void saveMorningSessionData() {
        SharedPreferences.Editor editor = msharedPrefernces.edit();
        editor.putString("Sanbot, where's the cloakroom / bagdrop? ", "The cloakroom is near the main entrance");
        editor.putString("Sanbot, where's the Keynote? Or what time is the Keynote?  ",
                "Monday AM: the keynote with Tan Li is at 10am in Arena 1B,\n" +
                        "Monday PM: the keynote with ? Is at 4:45pm in Arena 1B ,\n" +
                        "Tuesday AM: the Gartner Keynote is at 9am in Arena 2,\n" +
                        "Wednesday: the keynote with Genevieve Bell is 5pm in Area 2,\n" +
                        "Thursday AM: the keynote with Chris Hadfield is 9am in Arena 2, \n" +
                        "Thursday PM: the closing Keynote is 3pm in arena 2\n");
        editor.putString("Where is Arena 2? ", "Arena 2 is the main arena near the escalators");
        editor.putString("Sanbot, where can I get a coffee? ", "Coffee is available at in any of the cafes in ITxpo ? " +
                "Or, if you are a Member you can go to your Member lounge.");
        editor.putString("Sanbot, where is the Executive Programs Lounge? Or, EXP Lounge ? ",
                "The Executive Programs Lounge is across 2 levels this year, just head" +
                        " to the very south end of the building on either level and you can't miss it.");
        editor.putString("Sanbot, when does ITXPO open?  ",
                "ITXPO is open Tuesday 10am-6.30pm, Wednesday 9am-7.45pm and Thursday 9am-3.30pm");
        editor.putString("Sanbot, what is the wifi password?  ", "the wifi password is @gartner");
        editor.putString("Sanbot, where are the one on ones? Where is the one on one help desk?  ",
                "One on Ones are located in ITxpo. The booking desk near Arena 2 can help you with any questions you may have");
        editor.putString("Anything Sanbot cannot answer ", "Sorry, I'm not sure, I'm a new employee, if you go to " +
                "any of our help desks my friends can definitely assist with anything you need.");
        editor.putString("Sanbot what is the Twitter handle / hastag?", "Our Twitter hastag is #GartnerSym");
        editor.putString("Sanbot, tell me a joke?", "Does sanbot have any IT geek Jokes?");

        editor.commit();
    }

    public ArrayList<String> getmorningSessionList() {
        Map<String, ?> keys = msharedPrefernces.getAll();
        ArrayList<String> keysLIst = new ArrayList<>();
        for (String s : keys.keyadd()) {
            keysLIst.add(s);
        }
        return keysLIst;
    }*/


    public void setMorningsessionList() {


        MorningSessionQuestions.add("where's the cloakroom / bagdrop?");
        MorningSessionQuestions.add("where's the Keynote");
        MorningSessionQuestions.add("Where is Arena 2");
        MorningSessionQuestions.add("where can I get a coffee?");
        MorningSessionQuestions.add("where is the Executive Programs Lounge? Or, EXP Lounge ?");
        MorningSessionQuestions.add("when does ITXPO open?");
        MorningSessionQuestions.add("what is the wifi password?");
        MorningSessionQuestions.add("where are the one on ones? Where is the one on one help desk?");
        MorningSessionQuestions.add("Anything Sanbot cannot answer ");
        MorningSessionQuestions.add("Sanbot what is the Twitter handle / hastag?");
        MorningSessionQuestions.add("tell me a joke?");


        MorningSessionAnswers.add("The cloakroom is near the main entrance");
        MorningSessionAnswers.add("Monday AM: the keynote with Tan Li is at 10am in Arena 1B, " +
                "Monday PM: the keynote with ? Is at 4:45pm in Arena 1B ," +
                "Tuesday AM: the Gartner Keynote is at 9am in Arena 2," +
                "Wednesday: the keynote with Genevieve Bell is 5pm in Area 2," +
                "Thursday AM: the keynote with Chris Hadfield is 9am in Arena 2," +
                "Thursday PM: the closing Keynote is 3pm in arena 2");
        MorningSessionAnswers.add("Arena 2 is the main arena near the escalators");
        MorningSessionAnswers.add("Coffee is available at in any of the cafes in ITxpo ? " +
                "Or, if you are a Member you can go to your Member lounge.");
        MorningSessionAnswers.add("The Executive Programs Lounge is across 2 levels this year, just head" +
                " to the very south end of the building on either level and you can't miss it.");
        MorningSessionAnswers.add("ITXPO is open Tuesday 10am-6.30pm, Wednesday 9am-7.45pm and Thursday 9am-3.30pm");
        MorningSessionAnswers.add("the wifi password is @gartner");
        MorningSessionAnswers.add("One on Ones are located in ITxpo. The booking desk near Arena 2 can help you with any questions you may have");
        MorningSessionAnswers.add("Sorry, I'm not sure, I'm a new employee, if you go to " +
                "any of our help desks my friends can definitely assist with anything you need.");
        MorningSessionAnswers.add("Our Twitter hastag is #GartnerSym");
        MorningSessionAnswers.add("Does sanbot have any IT geek Jokes?");


    }


    public ArrayList<String> getMorningSessionQuestions() {
        return MorningSessionQuestions;
    }

    public ArrayList<String> getMorningSessionAnswers() {
        return MorningSessionAnswers;
    }
    void setAfternoonsessionList(){

    }

}
