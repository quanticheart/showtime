package com.master.killercode.wizard.Wizard;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;

import java.io.Serializable;
import java.util.ArrayList;

import static com.master.killercode.wizard.ColorBox.ConvertColorUniversal;

public class WizardPageModel implements Serializable {

    private String title;
    private String description;
    private int drawable;
    private int colorBackground;
    private int colorText;

    public static int NO_DRAWABLE = -1;
    public static int NO_COLOR = -1;
    public static int NO_COLORTEXT = -1;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public WizardPageModel(String title) {
        this.title = title;
        this.description = "";
        this.drawable = NO_DRAWABLE;
        this.colorBackground = NO_COLOR;
        this.colorText = NO_COLORTEXT;
    }

    public WizardPageModel(String title, String description) {
        this.title = title;
        this.description = description;
        this.drawable = NO_DRAWABLE;
        this.colorBackground = NO_COLOR;
        this.colorText = NO_COLORTEXT;
    }

    public WizardPageModel(String title, String description, int drawable) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = NO_COLOR;
        this.colorText = NO_COLORTEXT;
    }

    public WizardPageModel(String title, String description, int drawable, int colorBackground) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = NO_COLORTEXT;
    }

    public WizardPageModel(String title, String description, int drawable, String colorBackground) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = NO_COLORTEXT;
    }

    public WizardPageModel(String title, String description, int drawable, int colorBackground, int colorText) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = ConvertColorUniversal(colorText);
    }

    public WizardPageModel(String title, String description, int drawable, String colorBackground, String colorText) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = ConvertColorUniversal(colorText);
    }

    public WizardPageModel(String title, String description, int drawable, int colorBackground, String colorText) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = ConvertColorUniversal(colorText);
    }

    public WizardPageModel(String title, String description, int drawable, String colorBackground, int colorText) {
        this.title = title;
        this.description = description;
        this.drawable = drawable;
        this.colorBackground = ConvertColorUniversal(colorBackground);
        this.colorText = ConvertColorUniversal(colorText);
    }

    public WizardPageModel() {
        this.title = "";
        this.description = "";
        this.drawable = NO_DRAWABLE;
        this.colorBackground = NO_COLOR;
        this.colorText = NO_COLORTEXT;
    }

    public int getColorText() {
        return colorText;
    }

    public void setColorText(int colorText) {
        this.colorText = colorText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground) {
        this.colorBackground = colorBackground;
    }


}
