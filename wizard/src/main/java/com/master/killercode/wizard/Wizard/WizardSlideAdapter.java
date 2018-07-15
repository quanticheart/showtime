//package com.brasil.naville.materialdesigntemplates.Wizards;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.support.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.brasil.naville.materialdesigntemplates.R;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//
//public class WizardSlideAdapter extends PagerAdapter {
//
//    Context context;
//    LayoutInflater layoutInflater;
//
//    //Arrays
//    public int[] slideImages = {R.drawable.bee, R.drawable.carrot, R.drawable.ladybird};
//
//    public int[] slideBackground = {
//            Color.rgb(55, 55, 55),
//            Color.rgb(239, 85, 85),
//            Color.rgb(110, 49, 89),
//            Color.rgb(ic_categ_1, 188, 212),
//    };
//
//    public String[] slideHeadings = {"Bee", "Carrot", "Ladybird"};
//
//    public String[] slideDescriptions = {"Bzzzzzzzzzzzzzz", "Nhac?", "zzzzzzzzzuuuuummmmm"};
//
//
//    public WizardSlideAdapter(Context context) {
//        this.context = context;
//    }
//
//
//    @Override
//    public int getCount() {
//        return slideHeadings.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (RelativeLayout) object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        assert layoutInflater != null;
//        View view = layoutInflater.inflate(R.layout.activity_slide_itens, container, false);
//        LinearLayout linearLayout
//
//        CircleImageView circleImageViewSlide = view.findViewById(R.id.slideImage);
//        TextView txtHeadingsSlide = view.findViewById(R.id.txtHeadings);
//        TextView txtDescriptionsSlide = view.findViewById(R.id.txtDescriptions);
//
//        circleImageViewSlide.setImageResource(slideImages[position]);
//        txtHeadingsSlide.setText(slideHeadings[position]);
//        txtDescriptionsSlide.setText(slideDescriptions[position]);
//
//        container.addView(view);
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//
//        container.removeView((RelativeLayout) object);
//
//
//    }
//}

package com.master.killercode.wizard.Wizard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.killercode.wizard.R;

import java.util.ArrayList;

import static com.master.killercode.wizard.Wizard.WizardPageModel.NO_COLOR;
import static com.master.killercode.wizard.Wizard.WizardPageModel.NO_COLORTEXT;
import static com.master.killercode.wizard.Wizard.WizardPageModel.NO_DRAWABLE;

public class WizardSlideAdapter extends PagerAdapter {

    //init
    private Activity activity;
    private LayoutInflater inflater;

    //List for Wizard
    private ArrayList<WizardPageModel> dataBase;

    //Model
    private WizardPageModel data;

    //Variables from dataBase
    private String title;
    private String description;
    private int imgResorse;
    private int color;
    private int textColor;

    //Variables from xml
    private LinearLayout linearLayout;
    private ImageView img;
    private TextView txtTitle;
    private TextView txtDescriptions;

    public WizardSlideAdapter(Activity activity, ArrayList<WizardPageModel> wList) {
        this.activity = activity;
        this.dataBase = wList;
    }

    @Override
    public int getCount() {
        return dataBase.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout._01_activity_wizard_itens, container, false);
        //
        linearLayout = view.findViewById(R.id.slideLinearLayout);
        img = view.findViewById(R.id.slideImage);
        txtTitle = view.findViewById(R.id.txtHeadings);
        txtDescriptions = view.findViewById(R.id.txtDescriptions);
        //

        data = dataBase.get(position);
        color = data.getColorBackground();
        textColor = data.getColorText();
        imgResorse = data.getDrawable();
        title = data.getTitle();
        description = data.getDescription();
        //

        if (color != NO_COLOR) {
            linearLayout.setBackgroundColor(color);
        }

        if (imgResorse != NO_DRAWABLE) {
            img.setImageResource(imgResorse);
        }

        if (textColor != NO_COLORTEXT){
            txtTitle.setTextColor(textColor);
            txtDescriptions.setTextColor(textColor);
        }
        txtTitle.setText(title);
        txtDescriptions.setText(description);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


}