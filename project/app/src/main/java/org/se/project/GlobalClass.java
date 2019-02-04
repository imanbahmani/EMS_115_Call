package org.se.project;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abideveloprs.smartmarket.debug.activity.CalendarTool;
import com.abideveloprs.smartmarket.debug.activity.MainActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by imanbahmani on 10/5/16 AD.
 */
public class GlobalClass {
    public static String usermobile = "";
    public static String userpassword = "";
    ///////////////////////////
    public static String json = "";
    public static String totalPrice = "";
    public static String mobile = "";
    public static String subset = "";
    //////////////////////////////////////////
    public static Context context;
    public static String PREFS_NAME = "MyShp"; //shared pref name
    public static int    preProducID      = 0;
    public static int    productHeadID    = 0;
    public static String productName      = "";
    public static String productHeadName  = "";
    public static String productHeadColor = "";
    public static String productHeadImage = "";
    public static String paymentDescription = "";
    public static String personName = "";
    public static String invoicePrice = "";
    ////Settings
    public static String appName = "";
    public static String appNameEn = "";
    public static String slogan = "";
    public static String appLogo = "";
    public static String splashScreen = "";
    public static String androidLink = "";
    public static String siteAddress = "";
    public static String colorPrimary = "";
    public static String colorPrimaryDark = "";
    public static String colorAccent = "";
    ////EndSetting
    public static int sliderProductID = 0 ;
    public static boolean isSearch = false;
    ////

    public static String serverAddress       = "http://senik-shop.com/App/Admin/";
    public static String apiaddress          = serverAddress+"RestFull/WebService.php";
    public static String paymentAddress      = serverAddress+"RestFull/Pay.php";
    public static String PasargadPayAddress  = serverAddress+"RestFull/pepco/index.php";
    public static String loginAddress    = serverAddress+"RestFull/Login.php";
    public static String signUpAddress   = serverAddress+"RestFull/SignUp.php";
    public static String profileAddress  = serverAddress+"RestFull/Profile.php";
    public static String recommandAddress= serverAddress+"RestFull/Recommend.php";
    public static String bankAddress     = serverAddress+"RestFull/Bank.php";
    public static String regIDAddress    = serverAddress+"RestFull/regID.php";
    public static String imagesaddress   = serverAddress+"upimg/";
    public static void ImageCatch(Context con, ImageView imageView, String URL) {
        Glide
                .with(con)
                .load(URL)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_processing)
                .into(imageView);
    }
    public static void ImageCatchGrid(Context con, ImageView imageView, String URL) {
        Glide
                .with(con)
                .load(URL)
                .crossFade()
                .override(400, 400)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.loadingplace)
                .into(imageView);
    }
    public static void SnackbarShow(View AndroidRIdContent, String msg){
        Snackbar.make(AndroidRIdContent, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public static Context getContext() {
        return context;
    }
    public static boolean isOnline(Context contex) {
        ConnectivityManager cm = (ConnectivityManager) contex.getSystemService(contex.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    public static void overrideFont(Context context, String defaultFontNameToOverride, String customFontFileNameInAssets) {
        try {
            final Typeface customFontTypeface = Typeface.createFromAsset(context.getAssets(), customFontFileNameInAssets);

            final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFontNameToOverride);
            defaultFontTypefaceField.setAccessible(true);
            defaultFontTypefaceField.set(null, customFontTypeface);
        } catch (Exception e) {
            Log.e("TypefaceUtil", "Can not set custom font " + customFontFileNameInAssets + " instead of " + defaultFontNameToOverride);
        }
    }
    public static void setAllTextView(ViewGroup parent) {
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                setAllTextView((ViewGroup) child);
            } else if (child instanceof TextView) {
                ((TextView) child).setTypeface(getFont());
            }
        }
    }
    public static Typeface getFont() {
        return Typeface.createFromAsset(context.getAssets(), "Yekan.ttf");
    }
    public static String ConvertToCurency(String input){
        return NumberFormat.getIntegerInstance().format(Integer.parseInt(input));
    }
    public static String ConvertToCurencyInteger(int input){
        return ""+ NumberFormat.getIntegerInstance().format(input);
    }
    public static String discountPrice(int discount, int price){
       return ""+(discount * price)/100;
    }
    public static String usernameReturn(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MainActivity.MY_PREFS_NAME, 0);
        String usernameString = prefs.getString("username", null);
        return usernameString;
    }
    public static String passwordReturn(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MainActivity.MY_PREFS_NAME, 0);
        String passwordString = prefs.getString("password", null);
        return passwordString;
    }
    public static boolean saveUsernamePassword(String userName, String Password){
        SharedPreferences.Editor editor = getContext().getSharedPreferences(MainActivity.MY_PREFS_NAME, 0).edit();
        editor.putString("username", userName);
        editor.putString("password", Password);
        editor.commit();
        return true;
    }
    public static void removeSharePrefrences(Context context){
        SharedPreferences preferences = context.getSharedPreferences(MainActivity.MY_PREFS_NAME, 0);
        preferences.edit().remove("username").commit();
        preferences.edit().remove("password").commit();
    }
    public static String convertToJalali (String history) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = format.parse(history);
            System.out.println(d);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year  = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date  = c.get(Calendar.DATE);
        month = month+1;
        CalendarTool calTool = new CalendarTool(year,month,date);
        String historyi = calTool.getIranianDate();
        history= String.valueOf(historyi);
        return history;
    }
}
