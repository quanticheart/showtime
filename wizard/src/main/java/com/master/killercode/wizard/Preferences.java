package com.master.killercode.wizard;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static final String CONSTANTE_SHAREDPREFS_DO_PROJETO = "Wizard";
    private final SharedPreferences Prefs;

    public Preferences(Context context) {
        Prefs = context.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
    }
    public Boolean getWizardFinished(String s) {
        return Prefs.getBoolean(s, false);
    }


    public static final String CONSTANTE_SHAREDPREFS_DO_SPLASH = "splash";

    public void setSplashFinished(String nameSplash) {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(nameSplash, true);
        editor.commit();
    }

    public Boolean getSplashFinished(String s) {
        return Prefs.getBoolean(s, false);
    }



}
