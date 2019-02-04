package org.se.project;
import com.orm.SugarRecord;

/**
 * Created by imanbahmani on 1/21/2018 AD.
 */

public class BookDataBase extends SugarRecord {
    String title;

    public BookDataBase(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
