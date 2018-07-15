package com.master.killercode.libwizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.master.killercode.wizard.Splash.SplashActivity;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;
import com.master.killercode.wizard.Preferences;

import java.util.ArrayList;

import static com.master.killercode.wizard.ColorBox.ConvertColorUniversal;

public class MainActivity extends AppCompatActivity {

    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
        initActions();
        Preferences wPrefs = new Preferences(MainActivity.this);
        Boolean w = wPrefs.getWizardFinished("init");

        TextView textView = findViewById(R.id.tx);

        if (w) {
            textView.setText("Finished");
        } else {
            textView.setText("No visualized");
        }

//        String cor1 = Integer.toHexString(getResources().getColor(R.color.ColorSupremeWhite));
//        String rawcor2 = "#FFFFFF";
//        String cor2 = Integer.toHexString(Color.parseColor(rawcor2));
//        String cor5 = Integer.toHexString(0xffffff);
//        String cor3 = Integer.toHexString(Color.WHITE);
//        String cor4 = Integer.toHexString(Color.rgb(255 , 255 , 255));

//        if (String.valueOf(color).contains("0x")) {
//            linearLayout.setBackgroundColor(activity.getResources().getColor(Color.RED));
//        } else {
//            linearLayout.setBackgroundColor(color);
//        }

//        Log.w("Cor" , cor1+" "+cor2+" "+cor3+" "+cor4+" "+cor5);
//        Log.w("Cor Swarped", Integer.toHexString(ConvertColorUniversal(getResources().getColor(R.color.Color_Palet_Flat_ALIZARIN))));

    }

    private void initVars() {
        WizardPageModel page1 = new WizardPageModel("Hello");
        wList.add(page1);

        WizardPageModel page2 = new WizardPageModel("Wow", "This is page two");
        wList.add(page2);

        WizardPageModel page3 = new WizardPageModel("Humm", "This is page Tree", R.mipmap.ic_launcher);
        wList.add(page3);

        WizardPageModel page4 = new WizardPageModel("Ops", "This is page Four", WizardPageModel.NO_DRAWABLE, getResources().getColor(R.color.Color_Palet_Flat_ALIZARIN));
        wList.add(page4);

        WizardPageModel page5 = new WizardPageModel("Finish", "This is page Five", R.mipmap.ic_launcher, getResources().getColor(R.color.Color_Palet_Flat_EMERALD), getResources().getColor(R.color.app_blue));
        wList.add(page5);

        /////////////////////////////////////////////

    }

    private void initActions() {
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WizardActivity wizard = new WizardActivity(MainActivity.this, wList);
                wizard.setWizardFinished("init");
                wizard.show();

            }
        });

        Button button2 = findViewById(R.id.splash);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplashActivity splash = new SplashActivity(MainActivity.this);
                splash.setTimer(10);
                splash.setWizardThemeGoogle();
                splash.show();
            }
        });
    }
}

