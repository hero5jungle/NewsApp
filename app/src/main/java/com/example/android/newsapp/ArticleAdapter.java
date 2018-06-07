package com.example.android.newsapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class ArticleAdapter extends ArrayAdapter<Article> {

    private static final String LOCATION_SEPARATOR = " of ";

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

        Article currentArticle = getItem(position);

        TextView articleSection = (TextView) listItemView.findViewById(R.id.section);
        String sectionName = currentArticle.getmSection();
        articleSection.setText(sectionName);

        TextView titleView = (TextView) listItemView.findViewById(R.id.article_title);
        String articleTitle = currentArticle.getmTitle();
        titleView.setText(articleTitle);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = sliceDate(currentArticle.getmDate(), 10);
        dateView.setText(formattedDate);

        return listItemView;
    }

    private String sliceDate(String s, int endIndex) {
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(0, endIndex);
    }
}

