package com.master.killercode.wizard.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.master.killercode.wizard.Preferences;
import com.master.killercode.wizard.R;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

/**
 * Created by John on 01/12/2017.
 */

public class Splash extends AppCompatActivity {

    //init
    private Activity activity;
    private Bundle extras;
    private int splashSeconds = 3000;
    private Preferences prefs;
    private Class afterSplash;

    //Model's Array for Wizard Adapter
    private ArrayList<WizardPageModel> wList = new ArrayList<>();
    Boolean itens = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._00_splash);

        activity = Splash.this;

        prefs = new Preferences(activity);

        extras = getIntent().getExtras();

        if (extras != null && extras.containsKey("class")) {
            afterSplash = (Class) extras.get("class");
        }

        if (extras != null && extras.containsKey("seconds")) {
            splashSeconds = (int) extras.get("seconds") * 1000;
        }

        if (extras != null) {
            wList = (ArrayList<WizardPageModel>) extras.getSerializable("arr");
        }
        valideWList(wList);

        splashVerif();//Pega do prefs se já está criado
    }

    private void valideWList(ArrayList<WizardPageModel> wList) {
        if (wList.size() > 0) {
            itens = true;
        }
    }

    private void splashVerif() {
        String name = "";
        Boolean splash = false;
        if (extras != null && extras.containsKey("namesplash")) {
            name = extras.getString("namesplash");
            splash = prefs.getSplashFinished(name);
            if (!splash) {
                prefs.setSplashFinished(name);
            }
        }

        if (splash) {
            killPage();
        } else {
            Splash();

        }
    }

    private void Splash() {

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          if (itens) {
                                              WizardActivity wizard = new WizardActivity(activity, wList);
                                              wizard.setAfterWizard(afterSplash);
                                              if (extras != null && extras.containsKey("thw")) {
                                                  wizard.setThemeGoogle();
                                              }
                                              wizard.show(true);
                                          } else {
                                              killPage();
                                          }

                                      }
                                  }, splashSeconds
        );

    }

    private void killPage() {
        if (afterSplash != null) {
            final Intent nextPage = new Intent(activity, afterSplash);
            startActivity(nextPage);
        }
        finish();
    }

    private Bundle verifieBundle(String keyName) {
        if (extras != null && extras.containsKey(keyName)) {
            return (Bundle) extras.get(keyName);
        } else {
            return null;
        }
    }

}
