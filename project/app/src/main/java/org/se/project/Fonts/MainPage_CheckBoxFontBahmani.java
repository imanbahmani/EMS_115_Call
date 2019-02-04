package domino.app.android.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckBox;

import domino.app.android.R;

public class MainPage_CheckBoxFontBahmani extends CheckBox {

    public MainPage_CheckBoxFontBahmani(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public MainPage_CheckBoxFontBahmani(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public MainPage_CheckBoxFontBahmani(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = MainPage_FontCache.getTypeface(context.getString(R.string.Bahmani_font), context);
        setTypeface(customFont);
    }
}