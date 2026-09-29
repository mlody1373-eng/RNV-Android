package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // صفحه اصلی
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        mainLayout.setPadding(30, 40, 30, 30);
        mainLayout.setBackgroundColor(Color.WHITE);

        // لوگو / نام سیستم
        TextView logo = new TextView(this);
        logo.setText("RNV");
        logo.setTextSize(46);
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setTextColor(Color.BLACK);
        logo.setGravity(Gravity.CENTER);

        mainLayout.addView(logo,
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

        // نام فارسی
        TextView title = new TextView(this);
        title.setText("راهاناوند");
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        mainLayout.addView(title,
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

        // نام انگلیسی
        TextView englishTitle = new TextView(this);
        englishTitle.setText("RAHANAVAND");
        englishTitle.setTextSize(18);
        englishTitle.setTextColor(Color.DKGRAY);
        englishTitle.setGravity(Gravity.CENTER);

        mainLayout.addView(englishTitle);

        // معرفی
        TextView description = new TextView(this);
        description.setText(
                "یک اکوسیستم برای ارتباط انسان، مهارت، آموزش، کار و بازار"
        );
        description.setTextSize(16);
        description.setTextColor(Color.DKGRAY);
        description.setGravity(Gravity.CENTER);
        description.setPadding(10, 25, 10, 30);

        mainLayout.addView(description);

        // عنوان بخش‌ها
        TextView sectionTitle = new TextView(this);
        sectionTitle.setText("بخش‌های راهاناوند");
        sectionTitle.setTextSize(22);
        sectionTitle.setTypeface(Typeface.DEFAULT_BOLD);
        sectionTitle.setTextColor(Color.BLACK);
        sectionTitle.setGravity(Gravity.CENTER);

        mainLayout.addView(sectionTitle);

        // دکمه‌ها
        addButton(mainLayout, "👥 افراد و ارتباط");
        addButton(mainLayout, "🎓 آموزش و کشف استعداد");
        addButton(mainLayout, "🛠 کار و مهارت");
        addButton(mainLayout, "🏪 بازار و تولید");
        addButton(mainLayout, "🛡 حفاظت و امنیت");
        addButton(mainLayout, "⚙️ مدیریت سیستم");

        // اسکرول
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(mainLayout);

        setContentView(scrollView);
    }

    private void addButton(LinearLayout layout, String text) {

        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(17);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0,
