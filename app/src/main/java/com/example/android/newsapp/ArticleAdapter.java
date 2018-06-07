package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        /* Set the section name on the layout */
        Article currentArticle = getItem(position);
        TextView articleSection = listItemView.findViewById(R.id.section);
        String sectionName = currentArticle.getmSection();
        articleSection.setText(sectionName);

        /* Set the article title on the layout */
        TextView titleView = listItemView.findViewById(R.id.article_title);
        String articleTitle = currentArticle.getmTitle();
        titleView.setText(articleTitle);

        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(currentArticle.getmDate());
        dateView.setText(formattedDate);

        return listItemView;
    }


    private String formatDate(String dateString) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String newString = new SimpleDateFormat("MMM d, yyyy", Locale.US).format(date);
        return newString;
    }
}

