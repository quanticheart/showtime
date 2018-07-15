package com.master.killercode.wizard.Wizard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class WizardActivity {
    private Activity activity;
    private Intent intentWizard;
    private Class initialClass;
    private ArrayList<WizardPageModel> wList = new ArrayList<>();
    private int theme = 1;
    private String wizard = "Wizard";

    //theme
    private int INIT_THEME = 1;
    private int GOOGLE_THEME = 2;

    public WizardActivity(Activity activity, ArrayList<WizardPageModel> wList) {
        this.activity = activity;
        this.wList = wList;
        this.initialClass = activity.getClass();
        this.theme = INIT_THEME;
        intentWizard = new Intent(activity, Wizard.class);
    }

    public void setAfterWizard(Class cl) {
        initialClass = cl;
    }

    public void setThemeGoogle() {
        theme = GOOGLE_THEME;
    }

    public void show() {
        setIntent();
        activity.startActivity(intentWizard);
    }

    public void show(Boolean finish) {
        setIntent();
        activity.startActivity(intentWizard);
        if (finish)
            activity.finish();
    }

    public void setWizardFinished(String nameWizard) {
        SharedPreferences pref = activity.getSharedPreferences(wizard, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(nameWizard, true);
        editor.commit();
    }

    private void setIntent() {
        intentWizard.putExtra("class", initialClass);
        intentWizard.putExtra("arr", wList);
        intentWizard.putExtra("th", theme);
    }

}
