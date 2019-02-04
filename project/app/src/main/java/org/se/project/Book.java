package org.se.project;
import
/**
 * Created by imanbahmani on 1/21/2018 AD.
 */

public class Book extends SugarRecord<Book> {
    String title;

    public Book(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
