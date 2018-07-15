package com.master.killercode.wizard.Wizard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.killercode.wizard.R;

import java.util.ArrayList;

import static com.master.killercode.wizard.Wizard.WizardPageModel.NO_COLORTEXT;

public class Wizard extends AppCompatActivity {

    //init
    private Activity activity;
    private static int currentPage;
    private Bundle extras;

    //Theme init
    private int theme = 1;
    private ColorStateList colorPrimary;

    //ViewPager
    private ViewPager viewPager;

    //Adapter for ViewPager
    private WizardSlideAdapter wizardSlideAdapter;

    //Model's Array for Adapter
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    //LinearLayout
    private LinearLayout dotsLinearLayout, ll_linha;

    //Button
    private Button btnNextPage, btnBackPage, btnJump, btnJump2;

    //TextView Array
    private TextView[] dots;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout._01_activity_wizard);
        //init
        activity = Wizard.this;

        // Now in your TargetActivity
        extras = getIntent().getExtras();
        if (extras != null) {
            wList = (ArrayList<WizardPageModel>) extras.getSerializable("arr");
            theme = extras.getInt("th");
        }
        valideWList(wList);

        initViews();
        initActions();
//        for (int i = 0; i < wList.size(); i++) {
//            WizardPageModel wizardPageModel = wList.get(i);
//            Toast.makeText(activity, wizardPageModel.getText(), Toast.LENGTH_SHORT).show();
//        }
    }

    private void valideWList(ArrayList<WizardPageModel> wList) {
        if (wList.size() <= 0) {
            WizardPageModel page1 = new WizardPageModel(
                    activity.getResources().getString(R.string.w_title),
                    activity.getResources().getString(R.string.w_description)
            );
//
            wList.add(page1);
        }
    }

    private void initViews() {

        viewPager = findViewById(R.id.viewPagerSlide);
        dotsLinearLayout = findViewById(R.id.dotLinearLayout);

        // tipo ic_categ_1
        btnBackPage = findViewById(R.id.btnBackPage);
        btnNextPage = findViewById(R.id.btnNextPage);
        btnJump = findViewById(R.id.btnJump);

        // tipo ic_categ_2
        ll_linha = findViewById(R.id.ll_linha);
        btnJump2 = findViewById(R.id.btnJump2);

        jumpWizardScreen(btnJump);
        jumpWizardScreen(btnJump2);

        colorPrimary = btnBackPage.getTextColors();
    }

    private void initActions() {

        addDotsIndicator(0);

        wizardSlideAdapter = new WizardSlideAdapter(this, wList);
        viewPager.setAdapter(wizardSlideAdapter);

        viewPager.addOnPageChangeListener(onPageChangeListener);

        setClickListenerNextBackButtons(btnBackPage, -1);
        setClickListenerNextBackButtons(btnNextPage, 1);

    }

    //===================================================================================================
    //
    //
    //===================================================================================================

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //===================================================================================================
    //
    //
    //===================================================================================================

    private void addDotsIndicator(int pos) {

        if (wList.size() > 1) {
            dots = new TextView[wList.size()];
//        pageLenght = dots.length;
            currentPage = pos;

            dotsLinearLayout.removeAllViews();

            for (int i = 0; i < dots.length; i++) {

                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                dots[i].setTextColor(getResources().getColor(R.color.gray_light));

                dotsLinearLayout.addView(dots[i]);

            }

            if (dots.length > 0) {
                dots[pos].setTextColor(getResources().getColor(R.color.white));
            }
        }

        setTheme(theme, pos);


    }

    //===================================================================================================
    //
    //
    //===================================================================================================

    private void setTheme(int tipo, int pos) {

        btnBackPage.setVisibility(View.GONE);
        btnNextPage.setVisibility(View.GONE);
        btnJump.setVisibility(View.GONE);

        ll_linha.setVisibility(View.GONE);
        btnJump2.setVisibility(View.GONE);

        if (wList.size() > 1) {
            switch (tipo) {
                case 1:

                    btnJump.setVisibility(View.VISIBLE);

                    if (pos == 0) {

                        btnBackPage.setEnabled(false);
                        btnBackPage.setText(getResources().getString(R.string.w_anterior));
                        btnBackPage.setVisibility(View.GONE);

                        btnNextPage.setEnabled(true);
                        btnNextPage.setText(getResources().getString(R.string.w_proximo));
                        btnNextPage.setVisibility(View.VISIBLE);


                    } else if (pos == dots.length - 1) {

                        btnBackPage.setEnabled(true);
                        btnBackPage.setText(getResources().getString(R.string.w_anterior));
                        btnBackPage.setVisibility(View.VISIBLE);

                        btnNextPage.setEnabled(true);
                        btnNextPage.setText(getResources().getString(R.string.w_terminar));
                        btnNextPage.setVisibility(View.VISIBLE);


                    } else {

                        btnBackPage.setEnabled(true);
                        btnBackPage.setText(getResources().getString(R.string.w_anterior));
                        btnBackPage.setVisibility(View.VISIBLE);

                        btnNextPage.setEnabled(true);
                        btnNextPage.setText(getResources().getString(R.string.w_proximo));
                        btnNextPage.setVisibility(View.VISIBLE);

                    }

                    break;

                case 2:

                    ll_linha.setVisibility(View.VISIBLE);

                    if (pos == 0) {

                        btnJump2.setEnabled(true);
                        btnJump2.setText(getResources().getString(R.string.w_pular));
                        btnJump2.setVisibility(View.VISIBLE);

                        btnNextPage.setEnabled(true);
                        btnNextPage.setText(getResources().getString(R.string.w_proximo));
                        btnNextPage.setVisibility(View.VISIBLE);


                    } else if (pos == dots.length - 1) {

                        btnJump2.setEnabled(true);
                        btnJump2.setText(getResources().getString(R.string.w_terminar));
                        btnJump2.setVisibility(View.VISIBLE);

                        btnNextPage.setEnabled(false);
                        btnNextPage.setText(getResources().getString(R.string.w_terminar));
                        btnNextPage.setVisibility(View.GONE);

                    } else {

                        btnJump2.setEnabled(true);
                        btnJump2.setText(getResources().getString(R.string.w_pular));
                        btnJump2.setVisibility(View.VISIBLE);

                        btnNextPage.setEnabled(true);
                        btnNextPage.setText(getResources().getString(R.string.w_proximo));
                        btnNextPage.setVisibility(View.VISIBLE);
                    }

                    break;
            }



        } else {
            switch (tipo) {
                case 1:

                    btnJump.setVisibility(View.GONE);

                    btnBackPage.setEnabled(true);
                    btnBackPage.setText(getResources().getString(R.string.w_anterior));
                    btnBackPage.setVisibility(View.GONE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_terminar));
                    btnNextPage.setVisibility(View.VISIBLE);

                    break;

                case 2:

                    ll_linha.setVisibility(View.VISIBLE);

                    btnJump2.setEnabled(true);
                    btnJump2.setText(getResources().getString(R.string.w_terminar));
                    btnJump2.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(false);
                    btnNextPage.setText(getResources().getString(R.string.w_terminar));
                    btnNextPage.setVisibility(View.GONE);

                    break;
            }
        }


        WizardPageModel page = wList.get(pos);

        int color = page.getColorText();

        if (color != NO_COLORTEXT){
            setTextColor(color);
        } else {
            setTextColor(colorPrimary);
        }

    }

    //===================================================================================================
    //
    //
    //===================================================================================================


    private void setTextColor(int color){
        btnBackPage.setTextColor(color);
        btnNextPage.setTextColor(color);
        btnJump.setTextColor(color);
        btnJump2.setTextColor(color);
    }

    private void setTextColor(ColorStateList color){
        btnBackPage.setTextColor(color);
        btnNextPage.setTextColor(color);
        btnJump.setTextColor(color);
        btnJump2.setTextColor(color);
    }
    //===================================================================================================
    //
    //
    //===================================================================================================

    private void setClickListenerNextBackButtons(Button btn, final int pos) {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (wList.size() > 1) {
                    if (pos == -1) {
                        viewPager.setCurrentItem(currentPage - 1);
                    } else {

                        if (currentPage == dots.length - 1) {
                            finishWizard();
                        } else {
                            viewPager.setCurrentItem(currentPage + 1);
                        }
                    }
                } else {
                    finishWizard();
                }

            }
        });

    }

    //===================================================================================================
    //
    //
    //===================================================================================================

    private void jumpWizardScreen(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishWizard();
            }
        });
    }

    //===================================================================================================
    //
    //
    //===================================================================================================

    private void finishWizard() {

        Class cl = (Class) extras.get("class");
        Intent intent = new Intent(activity, cl);
        startActivity(intent);

        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

