package com.master.killercode.wizard;

import android.graphics.Color;
import android.util.Log;

public class ColorBox {

//    String cor1 = Integer.toHexString(getResources().getColor(R.color.ColorSupremeWhite));
//    String rawcor2 = "#FFFFFF";
//    String cor2 = Integer.toHexString(Color.parseColor(rawcor2));
//    String cor5 = Integer.toHexString(0xffffff);
//    String cor3 = Integer.toHexString(Color.WHITE);
//    String cor4 = Integer.toHexString(Color.rgb(255 , 255 , 255));

    int[][] states = new int[][] {
            new int[] { android.R.attr.state_enabled}, // enabled
            new int[] {-android.R.attr.state_enabled}, // disabled
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] { android.R.attr.state_pressed}  // pressed
    };

    int[] colors = new int[] {
            Color.BLACK,
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };

//    ColorStateList myList = new ColorStateList(states, colors);

    public static int ConvertColorUniversal(int color) {
        String raw = Integer.toHexString(color).toLowerCase();
        if (raw.length() == 6) {
            raw = "#ff" + raw;
        } else {
            raw = "#" + raw;
        }
        int finalcolor = Color.parseColor(raw);
        Log.w("ColorBox", Integer.toHexString(finalcolor));
        return finalcolor;
    }

    public static int ConvertColorUniversal(String color) {
        int finalcolor = Color.parseColor(color);
        return finalcolor;
    }
}
