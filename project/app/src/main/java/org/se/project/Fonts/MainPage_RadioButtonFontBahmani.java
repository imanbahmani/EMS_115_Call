package domino.app.android.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RadioButton;

import domino.app.android.R;

public class MainPage_RadioButtonFontBahmani extends RadioButton {

    public MainPage_RadioButtonFontBahmani(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public MainPage_RadioButtonFontBahmani(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public MainPage_RadioButtonFontBahmani(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = MainPage_FontCache.getTypeface(context.getString(R.string.Bahmani_font_light), context);
        setTypeface(customFont);
    }
}