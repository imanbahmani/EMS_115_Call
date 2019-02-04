package domino.app.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;

import com.andexert.library.RippleView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.marcinmoskala.videoplayview.VideoPlayView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.iwgang.countdownview.CountdownView;
import cn.iwgang.countdownview.DynamicConfig;
import domino.app.android.Fonts.MainPage_EditTextFontBahmaniLight;
import domino.app.android.Fonts.MainPage_TextViewFontBahmani;
import domino.app.android.Fonts.MainPage_TextViewFontBahmaniBold;
import domino.app.android.Fonts.MainPage_TextViewFontBahmaniLight;
import domino.app.android.discount.DiscountResponse;
import domino.app.android.follower.FollowerResponse;
import domino.app.android.following.FollowingResponse;
import domino.app.android.posts.PostResponse;
import domino.app.android.profileView.ProfileViewResponse;
import domino.app.android.quickSale.QuickSaleResponse;
import domino.app.android.shopps.ShopsResponse;
import domino.app.android.tickets.TicketsResponse;
import domino.app.android.userDiscount.UserDiscountResponse;
import movile.com.creditcardguide.model.IssuerCode;
import movile.com.creditcardguide.view.CreditCardView;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by imanbahmani on 9/29/2018 AD.
 */
public class UIGenerator {
    public static QuickSaleResponse golobalQuickSaleResponse = null;
    //public class QuickSaleResponse implements Serializable;
    public static final String serverAddress = "http://192.168.0.102:8000/api/";
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static String userId = "";
    public static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xMjcuMC4wLjE6ODAwMFwvYXBpXC9sb2dpbiIsImlhdCI6MTU0MDg4NzQ5MiwiZXhwIjoxNTQwOTczODkyLCJuYmYiOjE1NDA4ODc0OTIsImp0aSI6InJ6c0RpUHNlbERIOFBselMiLCJzdWIiOjEsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.KxspuTFbQ2yi35bo0RGD_r0lplly_R40YVEvRC2CJMI";

    public static RippleView rippleViewGenerator(Context context){
        RippleView rippleView = new RippleView(context);
        rippleView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        return rippleView;
    }

    public static MainPage_EditTextFontBahmaniLight editTextFontBahmaniLightGenerator(Context context, String text, int drawable, boolean isDivider,boolean isNumber){
        MainPage_EditTextFontBahmaniLight editTextFontBahmaniLight = new MainPage_EditTextFontBahmaniLight(context);
        editTextFontBahmaniLight.setPadding(20,20,20,20);
        if(isDivider)
            editTextFontBahmaniLight.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            editTextFontBahmaniLight.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        editTextFontBahmaniLight.setHint(text);
        editTextFontBahmaniLight.setGravity(Gravity.RIGHT | Gravity.CENTER);
        editTextFontBahmaniLight.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        if(isNumber)
            editTextFontBahmaniLight.setInputType(InputType.TYPE_CLASS_PHONE);
        return editTextFontBahmaniLight;
    }

    public static MainPage_TextViewFontBahmaniBold buttonBoldGenerator(Context context, String text,String color, int drawable,boolean isDivider){
        MainPage_TextViewFontBahmaniBold button = new MainPage_TextViewFontBahmaniBold(context);
        button.setPadding(20,20,20,20);
        if(isDivider)
            button.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            button.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        button.setBackgroundColor(Color.parseColor(color));
        button.setText(text);
        button.setGravity(Gravity.RIGHT | Gravity.CENTER);
        button.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        return button;
    }

    public static MainPage_TextViewFontBahmaniBold buttonBoldMatchGenerator(Context context, String text,String color, int drawable,boolean isDivider){
        MainPage_TextViewFontBahmaniBold button = new MainPage_TextViewFontBahmaniBold(context);
        button.setPadding(20,20,20,20);
        if(isDivider)
            button.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            button.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        button.setBackgroundColor(Color.parseColor(color));
        button.setText(text);
        button.setGravity(Gravity.RIGHT | Gravity.CENTER);
        button.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        return button;
    }

    public static MainPage_TextViewFontBahmani buttonGenerator(Context context, String text,String color, int drawable,boolean isDivider){
        MainPage_TextViewFontBahmani button = new MainPage_TextViewFontBahmani(context);
        button.setPadding(20,20,20,20);
        if(isDivider)
            button.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            button.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        button.setBackgroundColor(Color.parseColor(color));
        button.setText(text);
        button.setGravity(Gravity.RIGHT | Gravity.CENTER);
        button.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        return button;
    }

    public static MainPage_TextViewFontBahmaniLight buttonLightGenerator(Context context, String text, String color, int drawable,boolean isDivider){
        MainPage_TextViewFontBahmaniLight button = new MainPage_TextViewFontBahmaniLight(context);
        button.setPadding(20,20,20,20);
        if(isDivider)
            button.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            button.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        button.setBackgroundColor(Color.parseColor(color));
        button.setText(text);
        button.setGravity(Gravity.RIGHT | Gravity.CENTER);
        button.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        return button;
    }

    public static ImageView imageViewURLGenerator(Context context, String url,int x,int y){
        ImageView imageView = new ImageView(context);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        Picasso.with(context)
                .load(url)
                .into(imageView);
        return imageView;
    }

    public static VideoPlayView videoViewURLGenerator(Context context, String url){
        VideoPlayView videoPlayerView = new VideoPlayView(context);
        videoPlayerView.setBackgroundColor(Color.GRAY);
        videoPlayerView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
        videoPlayerView.setVideoUrl(url);
        videoPlayerView.setLooping(true);
        videoPlayerView.setAutoplay(true);
//        Picasso.with(context)
//                .load(R.drawable.ic_favorite_black_32dp)
//                .into(videoPlayerView.getLoadingView());
        return videoPlayerView;
    }

    public static CardView cardViewGenerator(Context context){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(10,10,10,10);
        CardView cardView = new CardView(context);
        cardView.setLayoutParams(layoutParams);
        cardView.setPadding(10,10,10,10);
        return cardView;
    }

    public static ViewGroup.LayoutParams layoutParamsGenerator(Context context){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,0.5f);
        //layoutParams.setMargins(10,10,10,10);
        return layoutParams;
    }

    public static ViewGroup.LayoutParams layoutParamsWrapContentGenerator(Context context){
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT,0.5f);
        layoutParams.setMargins(10,10,10,10);
        return layoutParams;
    }

    public static LinearLayout linearLayoutGenerator(Context context,boolean isDivider,boolean isVertical){
        LinearLayout linearLayout = new LinearLayout(context);
        if (isVertical)
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        else
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        if(isDivider)
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;
    }

    public static LinearLayout linearLayoutGeneratorWrap(Context context,boolean isDivider,boolean isVertical){
        LinearLayout linearLayout = new LinearLayout(context);
        if (isVertical)
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        else
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        if(isDivider)
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.5f));
        else
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        return linearLayout;
    }

    public static LinearLayout linearLayoutWrapContentGenerator(Context context,boolean isVertical){
        LinearLayout linearLayout = new LinearLayout(context);
        if (isVertical)
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        else
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;
    }

    public static LinearLayout linearLayoutMatchParentContentGenerator(Context context,boolean isVertical){
        LinearLayout linearLayout = new LinearLayout(context);
        if (isVertical)
            linearLayout.setOrientation(LinearLayout.VERTICAL);
        else
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return linearLayout;
    }

    public static ImageView imageViewCircleURLGenerator(Context context, String url,int x,int y,boolean isDivider,int drawable){
        ImageView imageView = new ImageView(context);
        imageView.setPadding(20,20,20,20);
        if(isDivider)
            imageView.setLayoutParams(new TableRow.LayoutParams(0,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));

        if(drawable!=0)
            imageView.setImageResource(drawable);
        else{
            Picasso.with(context)
                    .load(url)
                    .resize(x, y)
                    .centerCrop()
                    .transform(new CircleTransform())
                    .into(imageView);
        }
        return imageView;
    }

    public static ImageView imageViewGridViewURLGenerator(Context context, String url){
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            Picasso.with(context)
                    .load(url)
                    .into(imageView);
        return imageView;
    }

    public static TableRow tableRowGenerator(Context context,boolean isDivider){
        TableRow tableRow = new TableRow(context);
        tableRow.setPadding(1,1,1,1);
        if(isDivider)
            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,0.5f));
        else
            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return tableRow;
    }

    public static CardView instagramPostViewGenerator(final Context context, final QuickSaleResponse postResponse, final int index){
        CardView cardView = cardViewGenerator(context);
        cardView.setPadding(0,0,0,50);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.LEFT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        TableRow tableViewLine1 = tableRowGenerator(context,false);
        TableRow tableViewLine2 = tableRowGenerator(context,false);
        TableRow tableViewLine3 = tableRowGenerator(context,false);
        TableRow tableViewLine4 = tableRowGenerator(context,false);
        TableRow tableViewLine5 = tableRowGenerator(context,false);
        TableRow tableViewLine6 = tableRowGenerator(context,false);
        TableRow tableViewLine7 = tableRowGenerator(context,false);
        TableRow tableViewLine8 = tableRowGenerator(context,false);

        cardView.addView(linearLayout);

        linearLayout.addView(tableViewLine1);
        tableViewLine1.addView(imageViewCircleURLGenerator(context,"https://scontent-mad1-1.cdninstagram.com/vp/f010e3df4c8259ee94d43b7b1f62f860/5C5CD330/t51.2885-19/s150x150/22582387_1921874858064296_3573200601707708416_n.jpg",85,85,false,0));
        tableViewLine1.addView(buttonBoldGenerator(context,postResponse.getData().get(index).getUser().getUsername(),"#ffffff",0,true));

        linearLayout.addView(tableViewLine2);
        tableViewLine2.addView(imageViewURLGenerator(context,postResponse.getData().get(index).getImageUrl(),500,300));

        linearLayout.addView(tableViewLine3);
        final ImageView imageViewLike = imageViewCircleURLGenerator(context,"https://banner2.kisspng.com/20171202/0e4/instagram-heart-free-download-png-5a22bccc79de32.3196237915122259964992.jpg",100,100,false,R.drawable.ic_favorite_black_32dp);
        imageViewLike.setColorFilter(Color.BLACK);
        imageViewLike.setTag(0);
        imageViewLike.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        imageViewLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(imageViewLike.getTag().toString())==0)
                    httpRequest.like_request(context,String.valueOf(1),String.valueOf(postResponse.getData().get(index).getId()),imageViewLike);
                else
                    httpRequest.unlike_request(context,String.valueOf(1),String.valueOf(postResponse.getData().get(index).getId()),imageViewLike);
            }
        });
        tableViewLine3.addView(imageViewLike);
        tableViewLine3.addView(imageViewCircleURLGenerator(context,"https://cdn2.iconfinder.com/data/icons/instagram-ui/48/jee-69-512.png",100,100,false,R.drawable.ic_mode_comment_black_32dp));

        linearLayout.addView(tableViewLine4);
//        MainPage_TextViewFontBahmaniBold like = buttonBoldGenerator(context,postResponse.getData().get(index).getTotlalLikes()+" likes","#ffffff",0,false);
//        like.setGravity(Gravity.TOP | Gravity.LEFT);
//        tableViewLine4.addView(like);

        String likersString = "";
        for(int i=0;i<postResponse.getData().get(index).getTop10Likers().size();i++){
            likersString += " "+postResponse.getData().get(index).getTop10Likers().get(i).getLikerUser().getUsername();
        }

        MainPage_TextViewFontBahmaniLight likers = buttonLightGenerator(context,postResponse.getData().get(index).getTotlalLikes()+" پسند"+likersString,"#ffffff",0,true);
        likers.setEllipsize(TextUtils.TruncateAt.END);
        likers.setMaxLines(2);
        tableViewLine4.addView(likers);

        linearLayout.addView(tableViewLine5);
//        MainPage_TextViewFontBahmaniBold username = buttonBoldGenerator(context,"ImanBahmani","#ffffff",0,false);
//        username.setGravity(Gravity.TOP | Gravity.LEFT);
//        tableViewLine5.addView(username);
        final MainPage_TextViewFontBahmaniLight caption = buttonLightGenerator(context,postResponse.getData().get(index).getUser().getUsername()+" "+postResponse.getData().get(index).getCaption(),"#ffffff",0,true);
        caption.setEllipsize(TextUtils.TruncateAt.END);
        caption.setMaxLines(2);
        caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caption.setEllipsize(TextUtils.TruncateAt.END);
                caption.setMaxLines(50);
            }
        });
        tableViewLine5.addView(caption);

        linearLayout.addView(tableViewLine6);
        tableViewLine6.addView(buttonLightGenerator(context,"مشاهده هر "+postResponse.getData().get(index).getTotlalComments()+" نظر","#ffffff",0,true));

        linearLayout.addView(tableViewLine7);
        tableViewLine7.addView(imageViewCircleURLGenerator(context,"https://scontent-mad1-1.cdninstagram.com/vp/f010e3df4c8259ee94d43b7b1f62f860/5C5CD330/t51.2885-19/s150x150/22582387_1921874858064296_3573200601707708416_n.jpg",50,50,false,0));
        tableViewLine7.addView(buttonGenerator(context,"گذاشتن نظر","#ffffff",0,true));

        linearLayout.addView(tableViewLine8);
        tableViewLine8.addView(buttonLightGenerator(context,parseDate(postResponse.getData().get(index).getCreatedAt()),"#ffffff",0,true));

        return cardView;
    }

    public static CardView instagramProfileViewGenerator(Context context, ProfileViewResponse profileViewResponse){
        CardView cardView = cardViewGenerator(context);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.RIGHT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout linearLayout1Parent = linearLayoutGenerator(context,true,false);
        LinearLayout linearLayoutLeft = linearLayoutWrapContentGenerator(context,true);
        LinearLayout linearLayoutRight = linearLayoutGenerator(context,true,true);
        ImageView imageViewProfile = imageViewCircleURLGenerator(context,String.valueOf(profileViewResponse.getUser().get(0).getProfilePicUrl()),150,150,false,0);
        LinearLayout linearLayoutRightTop = linearLayoutGeneratorWrap(context,true,false);
        LinearLayout linearLayoutRightCenter = linearLayoutGeneratorWrap(context,true,false);
        LinearLayout linearLayoutRightBottom = linearLayoutGeneratorWrap(context,true,false);

        MainPage_TextViewFontBahmaniBold postCounterTitle = buttonBoldGenerator(context,"پست","#ffffff",0,true);
        postCounterTitle.setGravity(Gravity.CENTER);
        MainPage_TextViewFontBahmaniBold followerCounterTitle = buttonBoldGenerator(context,"دنبال شده","#ffffff",0,true);
        followerCounterTitle.setGravity(Gravity.CENTER);
        MainPage_TextViewFontBahmaniBold followingCounterTitle = buttonBoldGenerator(context,"دنبال کرده","#ffffff",0,true);
        followingCounterTitle.setGravity(Gravity.CENTER);

        MainPage_TextViewFontBahmaniLight postCounter = buttonLightGenerator(context,""+profileViewResponse.getPhoto(),"#ffffff",0,true);
        postCounter.setGravity(Gravity.CENTER);
        postCounter.setPadding(0,0,0,0);
        MainPage_TextViewFontBahmaniLight followerCounter = buttonLightGenerator(context,""+profileViewResponse.getFollower(),"#ffffff",0,true);
        followerCounter.setGravity(Gravity.CENTER);
        followerCounter.setPadding(0,0,0,0);
        MainPage_TextViewFontBahmaniLight followingCounter = buttonLightGenerator(context,""+profileViewResponse.getFollowing(),"#ffffff",0,true);
        followingCounter.setGravity(Gravity.CENTER);
        followingCounter.setPadding(0,0,0,0);

        MainPage_TextViewFontBahmani editProfile = buttonGenerator(context,"ویرایش","#ffffff",0,true);
        //editProfile.setPadding(10,2,10,2);
        editProfile.setGravity(Gravity.CENTER);
        editProfile.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        editProfile.setLayoutParams(layoutParamsGenerator(context));

        MainPage_TextViewFontBahmani promotionProfile = buttonGenerator(context,"امکانات ویژه","#ffffff",0,true);
        //promotionProfile.setPadding(10,2,10,2);
        promotionProfile.setGravity(Gravity.CENTER);
        promotionProfile.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        promotionProfile.setLayoutParams(layoutParamsGenerator(context));

        LinearLayout linearLayoutUsername = linearLayoutWrapContentGenerator(context,true);
        //linearLayoutUsername.setBackgroundColor(Color.RED);
        MainPage_TextViewFontBahmani username = buttonGenerator(context,profileViewResponse.getUser().get(0).getUsername(),"#ffffff",0,false);
        username.setGravity(Gravity.RIGHT);

        LinearLayout linearLayoutCaption = linearLayoutWrapContentGenerator(context,true);
        //linearLayoutCaption.setBackgroundColor(Color.RED);
        MainPage_TextViewFontBahmaniLight caption = buttonLightGenerator(context,"قسمت متن درباره من","#ffffff",0,false);
        caption.setGravity(Gravity.RIGHT);

        LinearLayout linearLayoutCallDirectionEmail = linearLayoutMatchParentContentGenerator(context,false);

        MainPage_TextViewFontBahmani callProfile = buttonGenerator(context,"تماس","#ffffff",0,true);
        callProfile.setGravity(Gravity.CENTER);
        callProfile.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        //callProfile.setLayoutParams(layoutParamsGenerator(context));

        MainPage_TextViewFontBahmani directionProfile = buttonGenerator(context,"مسیریابی","#ffffff",0,true);
        directionProfile.setGravity(Gravity.CENTER);
        directionProfile.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        directionProfile.setLayoutParams(layoutParamsGenerator(context));

        MainPage_TextViewFontBahmani emailProfile = buttonGenerator(context,"پست الکترونیکی","#ffffff",0,true);
        emailProfile.setGravity(Gravity.CENTER);
        emailProfile.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        emailProfile.setLayoutParams(layoutParamsGenerator(context));

        cardView.addView(linearLayout);
        linearLayout.addView(linearLayout1Parent);
        linearLayout1Parent.addView(linearLayoutLeft);
        linearLayout1Parent.addView(linearLayoutRight);
        linearLayoutLeft.addView(imageViewProfile);
        linearLayoutRight.addView(linearLayoutRightTop);
        linearLayoutRight.addView(linearLayoutRightCenter);
        linearLayoutRight.addView(linearLayoutRightBottom);
        linearLayoutRightTop.addView(postCounterTitle);
        linearLayoutRightTop.addView(followerCounterTitle);
        linearLayoutRightTop.addView(followingCounterTitle);
        linearLayoutRightCenter.addView(postCounter);
        linearLayoutRightCenter.addView(followerCounter);
        linearLayoutRightCenter.addView(followingCounter);
        linearLayoutRightBottom.addView(editProfile);
        linearLayoutRightBottom.addView(promotionProfile);

        linearLayout.addView(linearLayoutUsername);
        linearLayoutUsername.addView(username);

        linearLayout.addView(linearLayoutCaption);
        linearLayoutCaption.addView(caption);

        linearLayout.addView(linearLayoutCallDirectionEmail);
        linearLayoutCallDirectionEmail.addView(emailProfile);
        linearLayoutCallDirectionEmail.addView(callProfile);
        linearLayoutCallDirectionEmail.addView(directionProfile);

        linearLayout.addView(gridViewGenerator(context,linearLayout,profileViewResponse));

        return cardView;
    }

    public static CardView followingViewGenerator(final Context context, final FollowingResponse followingResponse, final int index){
        CardView cardView = cardViewGenerator(context);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.LEFT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout linearLayoutParent = linearLayoutGenerator(context,true,false);
        linearLayoutParent.setGravity(Gravity.CENTER);

        LinearLayout linearLayoutLeft = linearLayoutWrapContentGenerator(context,false);
        LinearLayout linearLayoutCenter = linearLayoutGenerator(context,true,true);
        LinearLayout linearLayoutRight = linearLayoutWrapContentGenerator(context,false);
        linearLayoutRight.setGravity(Gravity.CENTER);

        LinearLayout linearLayoutCenterTop = linearLayoutGenerator(context,true,true);
        LinearLayout linearLayoutCenterBottom = linearLayoutGenerator(context,true,true);

        ImageView imageViewProfile = imageViewCircleURLGenerator(context,"https://scontent-mad1-1.cdninstagram.com/vp/f010e3df4c8259ee94d43b7b1f62f860/5C5CD330/t51.2885-19/s150x150/22582387_1921874858064296_3573200601707708416_n.jpg",100,100,false,0);
        imageViewProfile.setAdjustViewBounds(true);

        MainPage_TextViewFontBahmaniBold usernameTitle = buttonBoldGenerator(context,""+followingResponse.getFollowing().get(index).getUserId(),"#ffffff",0,false);
        usernameTitle.setGravity(Gravity.CENTER);

        MainPage_TextViewFontBahmaniBold nameFamilyTitle = buttonBoldGenerator(context,""+followingResponse.getFollowing().get(index).getUserId(),"#ffffff",0,false);
        nameFamilyTitle.setGravity(Gravity.CENTER);

        final MainPage_TextViewFontBahmani followFollowing = buttonGenerator(context,"  following  ","#ffffff",0,true);
        followFollowing.setGravity(Gravity.CENTER);
        followFollowing.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        followFollowing.setLayoutParams(layoutParamsWrapContentGenerator(context));
        followFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followFollowing.setText(" follow ");
                followFollowing.setBackgroundColor(Color.BLUE);
                followFollowing.setTextColor(Color.WHITE);
                System.out.println("onSuccessResponse Click");
                httpRequest.unfollow_request(context,String.valueOf(followingResponse.getFollowing().get(index).getId()));
            }
        });

        cardView.addView(linearLayout);
        linearLayout.addView(linearLayoutParent);

        linearLayoutParent.addView(linearLayoutLeft);
        linearLayoutLeft.addView(imageViewProfile);

        linearLayoutParent.addView(linearLayoutCenter);
        linearLayoutCenter.addView(linearLayoutCenterTop);
        linearLayoutCenter.addView(linearLayoutCenterBottom);

        linearLayoutCenterTop.addView(usernameTitle);
        linearLayoutCenterBottom.addView(nameFamilyTitle);

        linearLayoutParent.addView(linearLayoutRight);
        linearLayoutRight.addView(followFollowing);

        return cardView;
    }

    public static CardView followerViewGenerator(Context context, FollowerResponse followerResponse, int index){
        CardView cardView = cardViewGenerator(context);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.LEFT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout linearLayoutParent = linearLayoutGenerator(context,true,false);
        linearLayoutParent.setGravity(Gravity.CENTER);

        LinearLayout linearLayoutLeft = linearLayoutWrapContentGenerator(context,false);
        LinearLayout linearLayoutCenter = linearLayoutGenerator(context,true,true);
        LinearLayout linearLayoutRight = linearLayoutWrapContentGenerator(context,false);
        linearLayoutRight.setGravity(Gravity.CENTER);

        LinearLayout linearLayoutCenterTop = linearLayoutGenerator(context,true,true);
        LinearLayout linearLayoutCenterBottom = linearLayoutGenerator(context,true,true);

        ImageView imageViewProfile = imageViewCircleURLGenerator(context,"https://scontent-mad1-1.cdninstagram.com/vp/f010e3df4c8259ee94d43b7b1f62f860/5C5CD330/t51.2885-19/s150x150/22582387_1921874858064296_3573200601707708416_n.jpg",100,100,false,0);
        imageViewProfile.setAdjustViewBounds(true);

        MainPage_TextViewFontBahmaniBold usernameTitle = buttonBoldGenerator(context,""+followerResponse.getFollower().get(index).getUserId(),"#ffffff",0,false);
        usernameTitle.setGravity(Gravity.CENTER);

        MainPage_TextViewFontBahmaniBold nameFamilyTitle = buttonBoldGenerator(context,""+followerResponse.getFollower().get(index).getUserId(),"#ffffff",0,false);
        nameFamilyTitle.setGravity(Gravity.CENTER);

        final MainPage_TextViewFontBahmani followFollowing = buttonGenerator(context,"  following  ","#ffffff",0,true);
        followFollowing.setGravity(Gravity.CENTER);
        followFollowing.setBackground(backgroundBorder("#ffffff",5,1,"#D3D3D3"));
        followFollowing.setLayoutParams(layoutParamsWrapContentGenerator(context));
        followFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                followFollowing.setBackgroundColor(Color.GRAY);
            }
        });

        cardView.addView(linearLayout);
        linearLayout.addView(linearLayoutParent);

        linearLayoutParent.addView(linearLayoutLeft);
        linearLayoutLeft.addView(imageViewProfile);

        linearLayoutParent.addView(linearLayoutCenter);
        //linearLayoutCenter.setBackgroundColor(Color.RED);
        linearLayoutCenter.addView(linearLayoutCenterTop);
        //linearLayoutCenterTop.setBackgroundColor(Color.BLUE);
        linearLayoutCenter.addView(linearLayoutCenterBottom);
        //linearLayoutCenterBottom.setBackgroundColor(Color.GRAY);

        linearLayoutCenterTop.addView(usernameTitle);
        linearLayoutCenterBottom.addView(nameFamilyTitle);

        linearLayoutParent.addView(linearLayoutRight);
        linearLayoutRight.addView(followFollowing);

        return cardView;
    }

    public static String parseDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date past = format.parse(date);
            Date now = new Date();
            long seconds= TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes=TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours=TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days=TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            if(seconds<60) {
                return ""+seconds+" ثانیه قبل";
                //System.out.println(seconds+" seconds ago");
            }
            else if(minutes<60) {
                return ""+minutes+" دقیقه قبل";
                //System.out.println(minutes+" minutes ago");
            }
            else if(hours<24) {
                return ""+hours+" ساعت قبل";
               // System.out.println(hours+" hours ago");
            }
            else {
                return ""+days+" روز قبل";
                //System.out.println(days+" days ago");
            }
        }
        catch (Exception j){
            j.printStackTrace();
        }
        return "error";

    }

    public static GradientDrawable backgroundBorder(String backgrounfColor,int cornerRadius,int stockSize,String stockColor){
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.parseColor(backgrounfColor)); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(cornerRadius);
        gd.setStroke(stockSize, Color.parseColor(stockColor));
        return gd;
    }

    public static GridLayout gridViewGenerator(Context context,LinearLayout linear, ProfileViewResponse profileViewResponse){

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int WidthScreen = width/3;

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.removeAllViews();
        int total = profileViewResponse.getPhotoList().size();

        int column = 3;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++) {
            if(c == column) {
                c = 0;
                r++;
            }

            LinearLayout linearLayoutFirst = new LinearLayout(context);
            linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            ImageView imageViewProfile = imageViewGridViewURLGenerator(context,profileViewResponse.getPhotoList().get(i).getImageUrl());
            imageViewProfile.setPadding(1,1,1,1);
            imageViewProfile.setAdjustViewBounds(true);

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            param.width  = WidthScreen-4;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec    = GridLayout.spec(r);
            linearLayoutFirst.setLayoutParams(param);
            gridLayout.addView(linearLayoutFirst);
            linearLayoutFirst.addView(linearLayout);
            linearLayout.addView(imageViewProfile);
        }
        return gridLayout;
    }

    public static GridLayout gridViewQuickSaleGenerator(final Context context, LinearLayout linear, final QuickSaleResponse quickSaleResponse){

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int WidthScreen = width/3;

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.removeAllViews();
        int total = quickSaleResponse.getData().size();

        int column = 3;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++) {
            if(c == column) {
                c = 0;
                r++;
            }

            LinearLayout linearLayoutFirst = new LinearLayout(context);
            linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            ImageView imageViewProfile = imageViewGridViewURLGenerator(context,quickSaleResponse.getData().get(i).getImageUrl());
            imageViewProfile.setPadding(1,1,1,1);
            imageViewProfile.setAdjustViewBounds(true);
            final int indexInt = i;
            imageViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    golobalQuickSaleResponse = null;
                    golobalQuickSaleResponse = quickSaleResponse;
                    Intent intent = new Intent(context,SingleContent.class);
                    intent.putExtra("index",indexInt);
                    context.startActivity(intent);
                }
            });

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            param.width  = WidthScreen-0;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec    = GridLayout.spec(r);
            linearLayoutFirst.setLayoutParams(param);
            gridLayout.addView(linearLayoutFirst);
            linearLayoutFirst.addView(linearLayout);
            linearLayout.addView(imageViewProfile);
        }
        return gridLayout;
    }

    public static GridLayout gridViewShopsGenerator(final Context context, LinearLayout linear, final ShopsResponse shopsResponse){

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int WidthScreen = width/3;

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.removeAllViews();
        int total = shopsResponse.getData().size();

        int column = 3;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++) {
            if(c == column) {
                c = 0;
                r++;
            }

            LinearLayout linearLayoutFirst = new LinearLayout(context);
            linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            ImageView imageViewProfile = imageViewGridViewURLGenerator(context,String.valueOf(shopsResponse.getData().get(i).getProfilePicUrl()));
            imageViewProfile.setPadding(1,1,1,1);
            imageViewProfile.setAdjustViewBounds(true);
            final String userIdString = String.valueOf(shopsResponse.getData().get(i).getId());
            imageViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UIGenerator.userId = userIdString;
                    Intent intent = new Intent(context,Profile.class);
                    context.startActivity(intent);
                }
            });
            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            param.width  = WidthScreen-0;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec    = GridLayout.spec(r);
            linearLayoutFirst.setLayoutParams(param);
            gridLayout.addView(linearLayoutFirst);
            linearLayoutFirst.addView(linearLayout);
            linearLayout.addView(imageViewProfile);
        }
        return gridLayout;
    }

    public static GridLayout gridViewMasterPageGenerator(final Context context, final ArrayList<String> list ){

        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int WidthScreen = width/3;

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.removeAllViews();
        int total = list.size();

        int column = 3;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++) {
            if(c == column) {
                c = 0;
                r++;
            }

            LinearLayout linearLayoutFirst = new LinearLayout(context);
            linearLayoutFirst.setOrientation(LinearLayout.VERTICAL);

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

            final MainPage_TextViewFontBahmaniBold title = buttonBoldMatchGenerator(context,list.get(i),"#ffffff",0,false);
            title.setPadding(20,20,20,20);
            title.setGravity(Gravity.CENTER);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,Post.class);
                    intent.putExtra("title",title.getText().toString());
                    context.startActivity(intent);
                }
            });

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = ViewGroup.LayoutParams.MATCH_PARENT;
            param.width  = WidthScreen-0;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec    = GridLayout.spec(r);
            linearLayoutFirst.setLayoutParams(param);
            gridLayout.addView(linearLayoutFirst);
            linearLayoutFirst.addView(linearLayout);
            linearLayout.addView(title);
        }
        return gridLayout;
    }

    public static CardView singleContent(QuickSaleResponse quickSaleResponse, int index, Context context){
        return UIGenerator.instagramPostViewGenerator(context,quickSaleResponse,index);
    }

    public static CardView profileViewGenerator(final Context context, final ShopsResponse shopsResponse){
        CardView cardView = cardViewGenerator(context);
        cardView.setPadding(0,0,0,50);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.RIGHT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        cardView.addView(linearLayout);

        MainPage_TextViewFontBahmaniBold username =  buttonBoldGenerator(context,"پروفایل","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight usernameEdit =  editTextFontBahmaniLightGenerator(context,"پروفایل",0,false,false);
        usernameEdit.setText(shopsResponse.getData().get(0).getUsername());
        linearLayout.addView(username);
        linearLayout.addView(usernameEdit);

        MainPage_TextViewFontBahmaniBold email =  buttonBoldGenerator(context,"ایمیل","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight emailEdit =  editTextFontBahmaniLightGenerator(context,"ایمیل",0,false,false);
        emailEdit.setText(shopsResponse.getData().get(0).getEmail());
        linearLayout.addView(email);
        linearLayout.addView(emailEdit);

        MainPage_TextViewFontBahmaniBold name =  buttonBoldGenerator(context,"نام","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight nameEdit =  editTextFontBahmaniLightGenerator(context,"نام",0,false,false);
        nameEdit.setText(shopsResponse.getData().get(0).getFname());
        linearLayout.addView(name);
        linearLayout.addView(nameEdit);

        MainPage_TextViewFontBahmaniBold family =  buttonBoldGenerator(context,"نام خانوادگی","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight familyEdit =  editTextFontBahmaniLightGenerator(context,"نام خانوادگی",0,false,false);
        familyEdit.setText(String.valueOf(shopsResponse.getData().get(0).getLname()));
        linearLayout.addView(family);
        linearLayout.addView(familyEdit);

        MainPage_TextViewFontBahmaniBold sex =  buttonBoldGenerator(context,"جنسیت","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight sexEdit =  editTextFontBahmaniLightGenerator(context,"جنسیت",0,false,false);
        sexEdit.setText(String.valueOf(shopsResponse.getData().get(0).getSex()));
        linearLayout.addView(sex);
        linearLayout.addView(sexEdit);

        MainPage_TextViewFontBahmaniBold address =  buttonBoldGenerator(context,"آدرس","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight addressEdit =  editTextFontBahmaniLightGenerator(context,"آدرس",0,false,false);
        addressEdit.setText(String.valueOf(shopsResponse.getData().get(0).getAddress()));
        linearLayout.addView(address);
        linearLayout.addView(addressEdit);

        MainPage_TextViewFontBahmaniBold shopName =  buttonBoldGenerator(context,"نام مغازه","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight shopNameEdit =  editTextFontBahmaniLightGenerator(context,"نام مغازه",0,false,false);
        shopNameEdit.setText(String.valueOf(shopsResponse.getData().get(0).getShopName()));
        linearLayout.addView(shopName);
        linearLayout.addView(shopNameEdit);

        MainPage_TextViewFontBahmaniBold visitorName =  buttonBoldGenerator(context,"شماره معرف","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight visitorNameEdit =  editTextFontBahmaniLightGenerator(context,"شماره معرف",0,false,false);
        visitorNameEdit.setText(String.valueOf(shopsResponse.getData().get(0).getVisitorUserId()));
        linearLayout.addView(visitorName);
        linearLayout.addView(visitorNameEdit);

        MainPage_TextViewFontBahmaniBold province =  buttonBoldGenerator(context,"استان","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight provinceEdit =  editTextFontBahmaniLightGenerator(context,"استان",0,false,false);
        provinceEdit.setText(String.valueOf(shopsResponse.getData().get(0).getProvinceId()));
        linearLayout.addView(province);
        linearLayout.addView(provinceEdit);

        MainPage_TextViewFontBahmaniBold city =  buttonBoldGenerator(context,"شهر","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight cityEdit =  editTextFontBahmaniLightGenerator(context,"شهر",0,false,false);
        cityEdit.setText(String.valueOf(shopsResponse.getData().get(0).getCityId()));
        linearLayout.addView(city);
        linearLayout.addView(cityEdit);

        MainPage_TextViewFontBahmaniBold category =  buttonBoldGenerator(context,"دسته بندی","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight categoryEdit =  editTextFontBahmaniLightGenerator(context,"دسته بندی",0,false,false);
        categoryEdit.setText(String.valueOf(shopsResponse.getData().get(0).getCategoryId()));
        linearLayout.addView(category);
        linearLayout.addView(categoryEdit);

        MainPage_TextViewFontBahmaniBold subCategory =  buttonBoldGenerator(context,"زیر دسته","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight subCategoryEdit =  editTextFontBahmaniLightGenerator(context,"زیر دسته",0,false,false);
        subCategoryEdit.setText(String.valueOf(shopsResponse.getData().get(0).getSubCategoryId()));
        linearLayout.addView(subCategory);
        linearLayout.addView(subCategoryEdit);

        MainPage_TextViewFontBahmaniBold isSpacial =  buttonBoldGenerator(context,"ویژه","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight isSpacialEdit =  editTextFontBahmaniLightGenerator(context,"ویژه",0,false,false);
        isSpacialEdit.setText(String.valueOf(shopsResponse.getData().get(0).getIsSpecialOffer()));
        linearLayout.addView(isSpacial);
        linearLayout.addView(isSpacialEdit);

        MainPage_TextViewFontBahmaniBold mobile =  buttonBoldGenerator(context,"موبایل","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight mobileEdit =  editTextFontBahmaniLightGenerator(context,"موبایل",0,false,false);
        mobileEdit.setText(String.valueOf(shopsResponse.getData().get(0).getMobile()));
        linearLayout.addView(mobile);
        linearLayout.addView(mobileEdit);

        MainPage_TextViewFontBahmaniBold profileUrl =  buttonBoldGenerator(context,"عکس پروفایل","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight profileUrlEdit =  editTextFontBahmaniLightGenerator(context,"عکس پروفایل",0,false,false);
        profileUrlEdit.setText(String.valueOf(shopsResponse.getData().get(0).getProfilePicUrl()));
        linearLayout.addView(profileUrl);
        linearLayout.addView(profileUrlEdit);

        MainPage_TextViewFontBahmaniBold userType =  buttonBoldGenerator(context,"نوع کاربری","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight userTypeEdit =  editTextFontBahmaniLightGenerator(context,"نوع کاربری",0,false,false);
        userTypeEdit.setText(String.valueOf(shopsResponse.getData().get(0).getUserType()));
        linearLayout.addView(userType);
        linearLayout.addView(userTypeEdit);

        MainPage_TextViewFontBahmaniBold createTime =  buttonBoldGenerator(context,"تاریخ ساخت","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight createTimeEdit =  editTextFontBahmaniLightGenerator(context,"تاریخ ساخت",0,false,false);
        createTimeEdit.setText(String.valueOf(shopsResponse.getData().get(0).getCreatedAt()));
        linearLayout.addView(createTime);
        linearLayout.addView(createTimeEdit);

        MainPage_TextViewFontBahmaniBold updateTime =  buttonBoldGenerator(context,"تاریخ آخرین بروز رسانی","#ffffff",0,false);
        MainPage_EditTextFontBahmaniLight updateTimeEdit =  editTextFontBahmaniLightGenerator(context,"تاریخ آخرین بروز رسانی",0,false,false);
        updateTimeEdit.setText(String.valueOf(shopsResponse.getData().get(0).getUpdatedAt()));
        linearLayout.addView(updateTime);
        linearLayout.addView(updateTimeEdit);



        return cardView;
    }

    public static LinearLayout ticketsViewGenerator(final Context context, final TicketsResponse ticketsResponse){

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.RIGHT);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        for(int i=0;i<ticketsResponse.getData().size();i++){

            CardView cardView = cardViewGenerator(context);
            cardView.setPadding(0,0,0,50);

            LinearLayout linearLayoutCardView = new LinearLayout(context);
            linearLayoutCardView.setOrientation(LinearLayout.VERTICAL);
            linearLayoutCardView.setGravity(Gravity.RIGHT);
            linearLayoutCardView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

            MainPage_TextViewFontBahmaniBold status =  buttonBoldGenerator(context,"پروفایل","#ffffff",0,false);
            status.setText("وضعیت: "+String.valueOf(ticketsResponse.getData().get(i).getTicketStatusId()));

            MainPage_TextViewFontBahmaniBold title =  buttonBoldGenerator(context,"پروفایل","#ffffff",0,false);
            title.setText("عنوان: "+String.valueOf(ticketsResponse.getData().get(i).getTitle()));

            MainPage_TextViewFontBahmaniBold date =  buttonBoldGenerator(context,"پروفایل","#ffffff",0,false);
            date.setText("تاریخ: "+String.valueOf(ticketsResponse.getData().get(i).getUpdatedAt()));

            linearLayout.addView(cardView);
            cardView.addView(linearLayoutCardView);

            linearLayoutCardView.addView(status);
            linearLayoutCardView.addView(title);
            linearLayoutCardView.addView(date);

        }


        return linearLayout;
    }

    public static LinearLayout discountViewGenerator(final Context context, final DiscountResponse discountResponse){

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        for(int i=0;i<discountResponse.getData().size();i++){

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);

            CardView cardView = cardViewGenerator(context);
            cardView.setPadding(4,4,4,50);
            cardView.setLayoutParams(params);

            final CreditCardView creditCardView = new  CreditCardView(context);
            creditCardView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            creditCardView.chooseFlag(IssuerCode.VISACREDITO);
            creditCardView.setTextNumber("مبلغ "+String.valueOf(discountResponse.getData().get(i).getPrice())+" تومان");
            creditCardView.setTextLabelOwner(discountResponse.getData().get(i).getTitle());
            creditCardView.setTextOwner("Iman Bahmani");
            creditCardView.setTextCVV("۳ ماهه");
            creditCardView.setTextLabelExpDate("مدت زمان");
            creditCardView.setTextExpDate("۳ ماهه");
            //creditCardView.setPadding(4,4,4,4);

            linearLayout.addView(cardView);
            cardView.addView(creditCardView);
        }

        return linearLayout;
    }

    public static LinearLayout userDiscountViewGenerator(final Context context, final UserDiscountResponse userDiscountResponse){

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        for(int i=0;i<userDiscountResponse.getData().size();i++){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            Date end = null;
            try {
                start = format.parse(String.valueOf(userDiscountResponse.getData().get(i).getStartTime()));
                end = format.parse(String.valueOf(userDiscountResponse.getData().get(i).getEndTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long seconds = (end.getTime()-start.getTime())/1000;

            final CreditCardView creditCardView = new  CreditCardView(context);
            creditCardView.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            creditCardView.chooseFlag(IssuerCode.VISACREDITO);
            creditCardView.setTextNumber("مبلغ "+String.valueOf(userDiscountResponse.getData().get(i).getDiscount().getPrice())+" تومان");
            creditCardView.setTextLabelOwner(userDiscountResponse.getData().get(i).getDiscount().getTitle());
            creditCardView.setTextOwner("Iman Bahmani");
            creditCardView.setTextCVV("۳ ماهه");
            creditCardView.setTextLabelExpDate("مدت زمان");
            creditCardView.setTextExpDate("۳ ماهه");
            creditCardView.setPadding(16,16,16,16);

            DynamicConfig.Builder dynamicConfigBuilder = new DynamicConfig.Builder();
            DynamicConfig.BackgroundInfo backgroundInfo = new DynamicConfig.BackgroundInfo();
            backgroundInfo.setColor(0xFF444444)
                    .setSize(40f)
                    .setRadius(3f)
                    .setShowTimeBgDivisionLine(true)
                    .setDivisionLineColor(Color.BLACK)
                    .setDivisionLineSize(1f);
            dynamicConfigBuilder.setTimeTextSize(22)
                    .setTimeTextColor(Color.BLACK)
                    .setTimeTextBold(true)
                    .setSuffixTextColor(Color.BLACK)
                    .setSuffixTextSize(18)
                    .setSuffixTextBold(true)
                    .setBackgroundInfo(backgroundInfo)
                    .setSuffixDay("روز").setSuffixHour("ساعت").setSuffixMinute("دقیقه").setSuffixSecond("ثانیه").setSuffixMillisecond("毫秒")
                    .setShowDay(true).setShowHour(true).setShowMinute(true).setShowSecond(true).setShowMillisecond(false);

            CountdownView mCvCountdownView = new CountdownView(context);
            //mCvCountdownView.set
            mCvCountdownView.start(seconds*1000);//milisecond
            mCvCountdownView.setPadding(16,16,16,16);
            mCvCountdownView.dynamicShow(dynamicConfigBuilder.build());


            linearLayout.addView(creditCardView);
            linearLayout.addView(mCvCountdownView);
            linearLayout.addView(buttonGenerator(context,"تاریخ شروع "+userDiscountResponse.getData().get(i).getStartTime(),"#ffffff",0,false));
            linearLayout.addView(buttonGenerator(context,"تاریخ پایان "+userDiscountResponse.getData().get(i).getEndTime(),"#ffffff",0,false));
        }

        return linearLayout;
    }

    public static boolean saveUsernamePassword(Context context,String userName,String Password){
        SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, 0).edit();
        editor.putString("username", userName);
        editor.putString("password", Password);
        editor.commit();
        return true;
    }

    public static String usernameReturn(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
        String usernameString = prefs.getString("username", null);
        return usernameString;
    }

    public static String passwordReturn(Context context){
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, 0);
        String passwordString = prefs.getString("password", null);
        return passwordString;
    }
}