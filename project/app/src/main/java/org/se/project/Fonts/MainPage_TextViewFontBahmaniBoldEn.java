package domino.app.android.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import domino.app.android.R;

public class MainPage_TextViewFontBahmaniBoldEn extends TextView {

    public MainPage_TextViewFontBahmaniBoldEn(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public MainPage_TextViewFontBahmaniBoldEn(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public MainPage_TextViewFontBahmaniBoldEn(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = MainPage_FontCache.getTypeface(getContext().getString(R.string.Bahmani_font_bold_en), context);
        setTypeface(customFont);
    }
}