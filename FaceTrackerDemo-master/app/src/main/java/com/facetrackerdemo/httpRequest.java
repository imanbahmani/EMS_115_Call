package domino.app.android;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by imanbahmani on 9/29/2018 AD.
 */

public class httpRequest {
    public static void globalRequest(final String url, final Context context, final VolleyCallback callback) {
        StringRequest strReq = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onSuccessResponse(response);
            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("okappppppppppppppppppppppppp"+error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("reg_id", MainActivityDrawer.displayFirebaseRegId(context));
//                params.put("arrange", "1");
//                params.put("capitan", "646");
//                params.put("id", "0");
//                params.put("players", "1817,1826,1822,1256,1801,646,77,34,1806,736,866");
//                params.put("reserves", "2138,729,2093");
//                params.put("title", "hihi");
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                //params.put("Authorization", Global.authorizationReturn(context));
                //params.put("reg_id", MainActivityDrawer.displayFirebaseRegId(context));
                return params;
            }
        };

        Volley.newRequestQueue(context).add(strReq);
    }
    public  interface VolleyCallback {
        void onSuccessResponse(String result);
    }

    public static String follow_request(Context context, String user_id, String user_following_id, final ImageView imageView){
        httpRequest.globalRequest(UIGenerator.serverAddress+"follow_request?token="+UIGenerator.token
                        +"&user_id="+user_id
                        +"&user_following_id="+user_following_id
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        imageView.setColorFilter(Color.RED);
                        imageView.setImageResource(R.drawable.ic_favorite_black_32dp);
                        imageView.setTag(1);
                    }
                });
        return "";
    }
    public static String unfollow_request(Context context, String id){
        httpRequest.globalRequest(UIGenerator.serverAddress+"unfollow_request?token="+UIGenerator.token
                        +"&id="+id
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        System.out.println("onSuccessResponse"+result);
                    }
                });
        return "";
    }

    public static String like_request(Context context, String liker_user_id, String photo_id, final ImageView imageView){
        httpRequest.globalRequest(UIGenerator.serverAddress+"like_request?token="+UIGenerator.token
                        +"&liker_user_id="+liker_user_id
                        +"&photo_id="+photo_id
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        imageView.setColorFilter(Color.RED);
                        imageView.setImageResource(R.drawable.ic_favorite_black_32dp);
                        imageView.setTag(1);
                    }
                });
        return "";
    }
    public static String unlike_request(Context context, String liker_user_id, String photo_id, final ImageView imageView){
        httpRequest.globalRequest(UIGenerator.serverAddress+"like_request?token="+UIGenerator.token
                        +"&liker_user_id="+liker_user_id
                        +"&photo_id="+photo_id
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        imageView.setColorFilter(Color.BLACK);
                        imageView.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                        imageView.setTag(0);
                    }
                });
        return "";
    }

    public static String comment_request(Context context, String photo_id, String user_id, final String comment){
        httpRequest.globalRequest(UIGenerator.serverAddress+"comment_request?token="+UIGenerator.token
                        +"&photo_id="+photo_id
                        +"&user_id="+user_id
                        +"&comment="+comment
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                    }
                });
        return "";
    }
    public static String comment_update_request(Context context, String photo_id, String user_id, final String comment){
        httpRequest.globalRequest(UIGenerator.serverAddress+"comment_update_request?token="+UIGenerator.token
                        +"&photo_id="+photo_id
                        +"&user_id="+user_id
                        +"&comment="+comment
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                    }
                });
        return "";
    }
    public static String remove_comment_request(Context context, String photo_id, String user_id, final String comment){
        httpRequest.globalRequest(UIGenerator.serverAddress+"remove_comment_request?token="+UIGenerator.token
                        +"&photo_id="+photo_id
                        +"&user_id="+user_id
                        +"&comment="+comment
                , context, new httpRequest.VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {

                    }
                });
        return "";
    }

}
