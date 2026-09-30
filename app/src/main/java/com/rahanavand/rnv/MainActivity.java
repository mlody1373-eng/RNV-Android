package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends Activity {

    private SharedPreferences prefs;

    // =========================
    // RNV COLORS
    // =========================

    private final int RNV_DARK = Color.rgb(20, 32, 45);
    private final int RNV_PRIMARY = Color.rgb(25, 118, 150);
    private final int RNV_PRIMARY_DARK = Color.rgb(16, 82, 105);
    private final int RNV_LIGHT = Color.rgb(242, 247, 249);
    private final int RNV_CARD = Color.WHITE;
    private final int RNV_TEXT = Color.rgb(30, 40, 48);
    private final int RNV_SECONDARY = Color.rgb(90, 105, 115);
    private final int RNV_BORDER = Color.rgb(220, 228, 232);
    private final int RNV_SUCCESS = Color.rgb(45, 125, 80);
    private final int RNV_WARNING = Color.rgb(190, 125, 35);

    // =========================
    // CREATE
    // =========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences(
                "RNV_DATA",
                MODE_PRIVATE
        );

        showMainMenu();
    }

    // =========================
    // BACKGROUND
    // =========================

    private GradientDrawable background(
            int color,
            float radius) {

        GradientDrawable drawable =
                new GradientDrawable();

        drawable.setColor(color);
        drawable.setCornerRadius(radius);
        drawable.setStroke(1, RNV_BORDER);

        return drawable;
    }

    // =========================
    // PAGE
    // =========================

    private LinearLayout layout() {

        LinearLayout l =
                new LinearLayout(this);

        l.setOrientation(
                LinearLayout.VERTICAL
        );

        l.setPadding(
                20,
                18,
                20,
                30
        );

        l.setBackgroundColor(
                RNV_LIGHT
        );

        return l;
    }

    private ScrollView page(
            LinearLayout content) {

        ScrollView scroll =
                new ScrollView(this);

        scroll.setFillViewport(true);
        scroll.setBackgroundColor(
                RNV_LIGHT
        );

        scroll.addView(content);

        return scroll;
    }

    // =========================
    // HEADER
    // =========================

    private LinearLayout header(
            String titleText,
            String subText) {

        LinearLayout box =
                new LinearLayout(this);

        box.setOrientation(
                LinearLayout.VERTICAL
        );

        box.setGravity(
                Gravity.CENTER
        );

        box.setPadding(
                15,
                18,
                15,
                18
        );

        box.setBackground(
                background(
                        RNV_CARD,
                        26
                )
        );

        TextView logo =
                new TextView(this);

        logo.setText("RNV");
        logo.setTextSize(30);
        logo.setTextColor(
                RNV_PRIMARY
        );

        logo.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        logo.setGravity(
                Gravity.CENTER
        );

        TextView title =
                new TextView(this);

        title.setText(titleText);
        title.setTextSize(22);
        title.setTextColor(
                RNV_DARK
        );

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setGravity(
                Gravity.CENTER
        );

        TextView sub =
                new TextView(this);

        sub.setText(subText);
        sub.setTextSize(14);
        sub.setTextColor(
                RNV_SECONDARY
        );

        sub.setGravity(
                Gravity.CENTER
        );

        sub.setPadding(
                5,
                5,
                5,
                0
        );

        box.addView(logo);
        box.addView(title);
        box.addView(sub);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(
                0,
                0,
                0,
                16
        );

        box.setLayoutParams(p);

        return box;
    }

    // =========================
    // TEXT
    // =========================

    private TextView title(
            String text) {

        TextView t =
                new TextView(this);

        t.setText(text);
        t.setTextSize(25);
        t.setTextColor(
                RNV_DARK
        );

        t.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        t.setGravity(
                Gravity.CENTER
        );

        t.setPadding(
                8,
                15,
                8,
                8
        );

        return t;
    }

    private TextView label(
            String text) {

        TextView t =
                new TextView(this);

        t.setText(text);
        t.setTextSize(16);
        t.setTextColor(
                RNV_TEXT
        );

        t.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        t.setPadding(
                5,
                12,
                5,
                5
        );

        return t;
    }

    private TextView infoText(
            String text) {

        TextView t =
                new TextView(this);

        t.setText(text);
        t.setTextSize(15);
        t.setTextColor(
                RNV_SECONDARY
        );

        t.setPadding(
                16,
                16,
                16,
                16
        );

        t.setBackground(
                background(
                        RNV_CARD,
                        20
                )
        );

        return t;
    }

    // =========================
    // CARD
    // =========================

    private Button cardButton(
            String icon,
            String titleText,
            String description) {

        Button b =
                new Button(this);

        b.setAllCaps(false);
        b.setTextSize(16);
        b.setTextColor(
                RNV_DARK
        );

        b.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        b.setGravity(
                Gravity.CENTER_VERTICAL |
                Gravity.RIGHT
        );

        b.setText(
                icon + "   " +
                titleText +
                "\n" +
                "      " +
                description
        );

        b.setBackground(
                background(
                        RNV_CARD,
                        22
                )
        );

        b.setPadding(
                18,
                14,
                18,
                14
        );

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(
                0,
                6,
                0,
                6
        );

        b.setLayoutParams(p);

        return b;
    }

    // =========================
    // BUTTON
    // =========================

    private Button button(
            String text) {

        Button b =
                new Button(this);

        b.setText(text);
        b.setTextSize(16);
        b.setTextColor(
                RNV_DARK
        );

        b.setAllCaps(false);

        b.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        b.setBackground(
                background(
                        RNV_CARD,
                        18
                )
        );

        b.setPadding(
                15,
                8,
                15,
                8
        );

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(
                0,
                6,
                0,
                6
        );

        b.setLayoutParams(p);

        return b;
    }

    private Button primaryButton(
            String text) {

        Button b =
                new Button(this);

        b.setText(text);
        b.setTextSize(16);
        b.setTextColor(
                Color.WHITE
        );

        b.setAllCaps(false);

        b.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        b.setBackground(
                background(
                        RNV_PRIMARY,
                        18
                )
        );

        b.setPadding(
                15,
                9,
                15,
                9
        );

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(
                0,
                7,
                0,
                7
        );

        b.setLayoutParams(p);

        return b;
    }

    // =========================
    // INPUT
    // =========================

    private EditText input(
            String hint) {

        EditText e =
                new EditText(this);

        e.setHint(hint);
        e.setTextSize(16);

        e.setTextColor(
                RNV_TEXT
        );

        e.setHintTextColor(
                RNV_SECONDARY
        );

        e.setPadding(
                16,
                10,
                16,
                10
        );

        e.setBackground(
                background(
                        Color.WHITE,
                        16
                )
        );

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(
                0,
                3,
                0,
                8
        );

        e.setLayoutParams(p);

        return e;
    }

    // =====================================================
    // MAIN DASHBOARD
    // =====================================================

    private void showMainMenu() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "راهاناوند",
                        "RAHANAVAND • RNV"
                )
        );

        String name =
                prefs.getString(
                        "name",
                        ""
                );

        String welcomeText;

        if (name.isEmpty()) {

            welcomeText =
                    "🌱 به راهاناوند خوش آمدی\n\n"
                    + "یک اکوسیستم برای ارتباط انسان‌ها، "
                    + "مهارت، آموزش، کار، تولید و بازار.";

        } else {

            welcomeText =
                    "👋 سلام " +
                    name +
                    "\n\n"
                    + "راهاناوند آماده ادامه مسیر توست.";
        }

        TextView welcome =
                infoText(
                        welcomeText
                );

        welcome.setGravity(
                Gravity.CENTER
        );

        l.addView(welcome);

        l.addView(
                title(
                        "مرکز اصلی RNV"
                )
        );

        Button people =
                cardButton(
                        "👥",
                        "افراد و ارتباط",
                        "پروفایل، مهارت، تجربه و همکاری"
                );

        Button education =
                cardButton(
                        "🎓",
                        "آموزش و کشف استعداد",
                        "یادگیری، آموزش و مسیر رشد"
                );

        Button work =
                cardButton(
                        "🛠",
                        "کار و پروژه",
                        "پروژه‌ها، نیروها و اجرای کار"
                );

        Button knowledge =
                cardButton(
                        "📚",
                        "دانش و روش انجام کار",
                        "ثبت تجربه و کشف روش بهتر"
                );

        Button market =
                cardButton(
                        "🏪",
                        "بازار و تولید",
                        "تولید، فروش، تأمین و بازار"
                );

        Button security =
                cardButton(
                        "🔐",
                        "حفاظت و امنیت",
                        "حریم خصوصی، دسترسی و حفاظت"
                );

        Button management =
                cardButton(
                        "⚙️",
                        "مدیریت RNV",
                        "ساختار، تصمیم‌گیری و کنترل سیستم"
                );

        l.addView(people);
        l.addView(education);
        l.addView(work);
        l.addView(knowledge);
        l.addView(market);
        l.addView(security);
        l.addView(management);

        people.setOnClickListener(
                v -> showPeople()
        );

        education.setOnClickListener(
                v -> showEducation()
        );

        work.setOnClickListener(
                v -> showWork()
        );

        knowledge.setOnClickListener(
                v -> showKnowledge()
        );

        market.setOnClickListener(
                v -> showMarket()
        );

        security.setOnClickListener(
                v -> showSecurity()
        );

        management.setOnClickListener(
                v -> showManagement()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // PEOPLE
    // =====================================================

    private void showPeople() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "افراد و ارتباط",
                        "انسان، مهارت و همکاری"
                )
        );

        Button profile =
                cardButton(
                        "👤",
                        "پروفایل من",
                        "اطلاعات و معرفی کاری"
                );

        Button skills =
                cardButton(
                        "🧰",
                        "مهارت‌ها",
                        "توانایی‌ها و تخصص‌ها"
                );

        Button experience =
                cardButton(
                        "📊",
                        "سابقه و تجربه",
                        "پروژه‌ها و تجربه‌های عملی"
                );

        Button search =
                cardButton(
                        "🔎",
                        "پیدا کردن افراد",
                        "جستجوی افراد و متخصصان"
                );

        Button cooperation =
                cardButton(
                        "🤝",
                        "همکاری",
                        "درخواست همکاری و تشکیل تیم"
                );

        Button privacy =
                cardButton(
                        "🛡️",
                        "حریم خصوصی",
                        "کنترل نمایش اطلاعات"
                );

        l.addView(profile);
        l.addView(skills);
        l.addView(experience);
        l.addView(search);
        l.addView(cooperation);
        l.addView(privacy);

        Button back =
                button("←  بازگشت");

        l.addView(back);

        profile.setOnClickListener(
                v -> showProfile()
        );

        skills.setOnClickListener(
                v -> showSkills()
        );

        experience.setOnClickListener(
                v -> showExperience()
        );

        search.setOnClickListener(
                v -> showSearch()
        );

        cooperation.setOnClickListener(
                v -> showCooperation()
        );

        privacy.setOnClickListener(
                v -> showPrivacy()
        );

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // PROFILE
    // =====================================================

    private void showProfile() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "پروفایل من",
                        "نمایه کاری RNV"
                )
        );

        l.addView(
                infoText(
                        "این بخش پایه‌ی «نمایه فرد» در RNV است. "
                        + "اطلاعات در حافظه داخلی برنامه ذخیره می‌شود."
                )
        );

        EditText name =
                input(
                        "نام و نام خانوادگی"
                );

        EditText job =
                input(
                        "شغل یا تخصص اصلی"
                );

        EditText city =
                input(
                        "شهر / محدوده فعالیت"
                );

        EditText phone =
                input(
                        "شماره تماس"
                );

        EditText skills =
                input(
                        "مهارت‌های اصلی"
                );

        EditText about =
                input(
                        "معرفی کوتاه"
                );

        name.setText(
                prefs.getString(
                        "name",
                        ""
                )
        );

        job.setText(
                prefs.getString(
                        "job",
                        ""
                )
        );

        city.setText(
                prefs.getString(
                        "city",
                        ""
                )
        );

        phone.setText(
                prefs.getString(
                        "phone",
                        ""
                )
        );

        skills.setText(
                prefs.getString(
                        "skills",
                        ""
                )
        );

        about.setText(
                prefs.getString(
                        "about",
                        ""
                )
        );

        l.addView(
                label("نام و نام خانوادگی")
        );

        l.addView(name);

        l.addView(
                label("شغل یا تخصص اصلی")
        );

        l.addView(job);

        l.addView(
                label("شهر / محدوده فعالیت")
        );

        l.addView(city);

        l.addView(
                label("شماره تماس")
        );

        l.addView(phone);

        l.addView(
                label("مهارت‌های اصلی")
        );

        l.addView(skills);

        l.addView(
                label("معرفی کوتاه")
        );

        l.addView(about);

        Button save =
                primaryButton(
                        "💾  ذخیره پروفایل"
                );

        Button back =
                button("←  بازگشت");

        l.addView(save);
        l.addView(back);

        save.setOnClickListener(v -> {

            prefs.edit()
                    .putString(
                            "name",
                            name.getText().toString()
                    )
                    .putString(
                            "job",
                            job.getText().toString()
                    )
                    .putString(
                            "city",
                            city.getText().toString()
                    )
                    .putString(
                            "phone",
                            phone.getText().toString()
                    )
                    .putString(
                            "skills",
                            skills.getText().toString()
                    )
                    .putString(
                            "about",
                            about.getText().toString()
                    )
                    .apply();

            Toast.makeText(
                    this,
                    "پروفایل ذخیره شد ✓",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // SKILLS
    // =====================================================

    private void showSkills() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "مهارت‌ها و تخصص‌ها",
                        "ساخت بانک مهارت RNV"
                )
        );

        l.addView(
                infoText(
                        "مهارت‌های خود را انتخاب کن. "
                        + "در نسخه‌های بعدی این اطلاعات می‌تواند "
                        + "برای تطبیق فرد با پروژه استفاده شود."
                )
        );

        String[] skillList = {

                "ساختمان و عمران",
                "جوشکاری",
                "آرماتوربندی",
                "قالب‌بندی",
                "بنایی",
                "تأسیسات",
                "برق",
                "نجاری",
                "نقاشی ساختمان",
                "کاشی‌کاری",
                "فروش و بازاریابی",
                "حسابداری",
                "تولید",
                "مدیریت",
                "حمل‌ونقل",
                "فناوری و نرم‌افزار"
        };

        String saved =
                prefs.getString(
                        "selectedSkills",
                        ""
                );

        for (String skill : skillList) {

            CheckBox check =
                    new CheckBox(this);

            check.setText(skill);
            check.setTextSize(16);
            check.setTextColor(
                    RNV_TEXT
            );

            check.setPadding(
                    8,
                    7,
                    8,
                    7
            );

            if (saved.contains(
                    "|" + skill + "|"
            )) {

                check.setChecked(true);
            }

            l.addView(check);

            check.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> {

                        String current =
                                prefs.getString(
                                        "selectedSkills",
                                        ""
                                );

                        String item =
                                "|" + skill + "|";

                        if (
                                isChecked &&
                                !current.contains(item)
                        ) {

                            current += item;
                        }

                        if (!isChecked) {

                            current =
                                    current.replace(
                                            item,
                                            ""
                                    );
                        }

                        prefs.edit()
                                .putString(
                                        "selectedSkills",
                                        current
                                )
                                .apply();
                    }
            );
        }

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // EXPERIENCE
    // =====================================================

    private void showExperience() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "سابقه و تجربه کاری",
                        "ثبت تجربه‌های واقعی"
                )
        );

        EditText years =
                input(
                        "چند سال سابقه کار دارید؟"
                );

        EditText projects =
                input(
                        "مهم‌ترین پروژه‌ها یا کارها"
                );

        EditText specialty =
                input(
                        "تخصص اصلی"
                );

        EditText quality =
                input(
                        "توانایی و کیفیت کار"
                );

        years.setText(
                prefs.getString(
                        "years",
                        ""
                )
        );

        projects.setText(
                prefs.getString(
                        "projects",
                        ""
                )
        );

        specialty.setText(
                prefs.getString(
                        "specialty",
                        ""
                )
        );

        quality.setText(
                prefs.getString(
                        "quality",
                        ""
                )
        );

        l.addView(
                label("سابقه کاری")
        );

        l.addView(years);

        l.addView(
                label("پروژه‌ها و تجربه‌ها")
        );

        l.addView(projects);

        l.addView(
                label("تخصص اصلی")
        );

        l.addView(specialty);

        l.addView(
                label("توانایی و کیفیت کار")
        );

        l.addView(quality);

        Button save =
                primaryButton(
                        "💾  ذخیره سابقه"
                );

        Button back =
                button("←  بازگشت");

        l.addView(save);
        l.addView(back);

        save.setOnClickListener(v -> {

            prefs.edit()
                    .putString(
                            "years",
                            years.getText().toString()
                    )
                    .putString(
                            "projects",
                            projects.getText().toString()
                    )
                    .putString(
                            "specialty",
                            specialty.getText().toString()
                    )
                    .putString(
                            "quality",
                            quality.getText().toString()
                    )
                    .apply();

            Toast.makeText(
                    this,
                    "سابقه کاری ذخیره شد ✓",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // SEARCH
    // =====================================================

    private void showSearch() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "پیدا کردن افراد",
                        "جستجوی متخصصان RNV"
                )
        );

        EditText search =
                input(
                        "نام، شغل یا مهارت"
                );

        l.addView(search);

        Button searchButton =
                primaryButton(
                        "🔎  جستجو"
                );

        l.addView(searchButton);

        TextView result =
                infoText(
                        "پایگاه افراد هنوز به شبکه آنلاین RNV متصل نیست."
                );

        l.addView(result);

        searchButton.setOnClickListener(
                v -> {

                    String text =
                            search.getText()
                                    .toString()
                                    .trim();

                    if (text.isEmpty()) {

                        result.setText(
                                "لطفاً عبارت جستجو را وارد کنید."
                        );

                    } else {

                        result.setText(
                                "عبارت جستجو:\n\n"
                                + text
                                + "\n\n"
                                + "این بخش در نسخه شبکه‌ای "
                                + "به بانک افراد RNV متصل خواهد شد."
                        );
                    }
                }
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // COOPERATION
    // =====================================================

    private void showCooperation() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "همکاری و ارتباط",
                        "ساخت تیم‌های کاری"
                )
        );

        l.addView(
                infoText(
                        "هسته همکاری RNV باید بتواند "
                        + "فرد مناسب را به کار مناسب و "
                        + "افراد مناسب را به یکدیگر متصل کند."
                )
        );

        l.addView(
                label(
                        "چرخه همکاری"
                )
        );

        l.addView(
                infoText(
                        "۱. ایجاد درخواست\n\n"
                        + "۲. پیدا کردن افراد مناسب\n\n"
                        + "۳. بررسی مهارت و سابقه\n\n"
                        + "۴. تشکیل تیم\n\n"
                        + "۵. اجرای کار\n\n"
                        + "۶. ثبت نتیجه و عملکرد"
                )
        );

        Button request =
                primaryButton(
                        "＋  ایجاد درخواست همکاری"
                );

        l.addView(request);

        request.setOnClickListener(
                v -> Toast.makeText(
                        this,
                        "سامانه درخواست همکاری "
                                + "در مرحله اتصال داده فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // PRIVACY
    // =====================================================

    private void showPrivacy() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "حریم خصوصی",
                        "کنترل دسترسی به اطلاعات"
                )
        );

        l.addView(
                infoText(
                        "اطلاعات هر فرد باید تحت کنترل "
                        + "خود او باشد و دسترسی‌ها بر اساس "
                        + "سطح مجاز تعریف شوند."
                )
        );

        CheckBox showPhone =
                new CheckBox(this);

        showPhone.setText(
                "نمایش شماره تماس"
        );

        showPhone.setTextSize(16);
        showPhone.setTextColor(
                RNV_TEXT
        );

        showPhone.setChecked(
                prefs.getBoolean(
                        "showPhone",
                        false
                )
        );

        l.addView(showPhone);

        CheckBox showProfile =
                new CheckBox(this);

        showProfile.setText(
                "نمایش پروفایل در جستجو"
        );

        showProfile.setTextSize(16);
        showProfile.setTextColor(
                RNV_TEXT
        );

        showProfile.setChecked(
                prefs.getBoolean(
                        "showProfile",
                        true
                )
        );

        l.addView(showProfile);

        Button save =
                primaryButton(
                        "💾  ذخیره تنظیمات"
                );

        l.addView(save);

        save.setOnClickListener(
                v -> {

                    prefs.edit()
                            .putBoolean(
                                    "showPhone",
                                    showPhone.isChecked()
                            )
                            .putBoolean(
                                    "showProfile",
                                    showProfile.isChecked()
                            )
                            .apply();

                    Toast.makeText(
                            this,
                            "تنظیمات ذخیره شد ✓",
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showPeople()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // EDUCATION
    // =====================================================

    private void showEducation() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "آموزش و کشف استعداد",
                        "رشد انسان از شناخت تا مهارت"
                )
        );

        l.addView(
                infoText(
                        "🎓 آموزش در RNV فقط انتقال اطلاعات نیست.\n\n"
                        + "هدف، شناخت توانایی فرد، آموزش عملی، "
                        + "ارزیابی و اتصال به مسیر کاری مناسب است."
                )
        );

        addModule(
                l,
                "📖",
                "مسیر یادگیری",
                "سطح فعلی → آموزش → تمرین → ارزیابی"
        );

        addModule(
                l,
                "🧠",
                "کشف استعداد",
                "شناخت علاقه، توانایی و ظرفیت یادگیری"
        );

        addModule(
                l,
                "🛠",
                "آموزش عملی",
                "یادگیری از تجربه و انجام واقعی کار"
        );

        addModule(
                l,
                "🎯",
                "اتصال به مسیر کار",
                "تبدیل مهارت به فرصت واقعی"
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // WORK
    // =====================================================

    private void showWork() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "کار و پروژه",
                        "اتصال انسان، مهارت و پروژه"
                )
        );

        l.addView(
                infoText(
                        "هسته اجرایی اولیه RNV می‌تواند از "
                        + "حوزه ساخت‌وساز شروع شود و بعد "
                        + "به سایر حوزه‌ها گسترش پیدا کند."
                )
        );

        addModule(
                l,
                "🏗",
                "پروژه‌ها",
                "ثبت پروژه و نیازهای اجرایی"
        );

        addModule(
                l,
                "👷",
                "نیروی انسانی",
                "تطبیق افراد با نیاز پروژه"
        );

        addModule(
                l,
                "📦",
                "مصالح و منابع",
                "شناخت منابع، تأمین‌کننده و موجودی"
        );

        addModule(
                l,
                "✅",
                "کنترل کیفیت",
                "ثبت نتیجه، کیفیت و عملکرد"
        );

        addModule(
                l,
                "📈",
                "ارزیابی عملکرد",
                "زمان، هزینه، کیفیت و رضایت"
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // KNOWLEDGE
    // =====================================================

    private void showKnowledge() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "دانش و روش انجام کار",
                        "ثبت تجربه و کشف روش بهتر"
                )
        );

        l.addView(
                infoText(
                        "📚 RNV باید تجربه‌های عملی را ثبت کند "
                        + "تا دانش یک فرد با از بین رفتن یا تغییر "
                        + "او از سیستم حذف نشود."
                )
        );

        addModule(
                l,
                "📝",
                "ثبت روش کار",
                "مراحل واقعی انجام یک کار"
        );

        addModule(
                l,
                "🔧",
                "ابزار و مصالح",
                "ابزار موردنیاز و مصرف منابع"
        );

        addModule(
                l,
                "⏱",
                "زمان و بازدهی",
                "اندازه‌گیری زمان و خروجی"
        );

        addModule(
                l,
                "💰",
                "هزینه",
                "ثبت هزینه و مصرف منابع"
        );

        addModule(
                l,
                "⭐",
                "روش برتر",
                "مقایسه روش‌ها و شناسایی روش کارآمدتر"
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // MARKET
    // =====================================================

    private void showMarket() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "بازار و تولید",
                        "اتصال تولید، فروش و تأمین"
                )
        );

        addModule(
                l,
                "🏭",
                "تولید",
                "ثبت تولیدکنندگان و ظرفیت‌ها"
        );

        addModule(
                l,
                "📦",
                "تأمین",
                "ارتباط با تأمین‌کنندگان و منابع"
        );

        addModule(
                l,
                "🛒",
                "فروش",
                "اتصال محصول یا خدمت به بازار"
        );

        addModule(
                l,
                "📊",
                "تحلیل بازار",
                "شناخت نیاز، قیمت و تقاضا"
        );

        l.addView(
                infoText(
                        "هدف نهایی این بخش، ایجاد یک زنجیره "
                        + "شفاف‌تر بین تولیدکننده، نیروی کار، "
                        + "تأمین‌کننده و مشتری است."
                )
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // SECURITY
    // =====================================================

    private void showSecurity() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "حفاظت و امنیت",
                        "لایه محافظ RNV"
                )
        );

        l.addView(
                infoText(
                        "🔐 امنیت یکی از حساس‌ترین بخش‌های "
                        + "راهاناوند است؛ چون سیستم به مرور "
                        + "اطلاعات افراد، کار، تجربه و ارتباطات "
                        + "را در کنار هم قرار می‌دهد."
                )
        );

        addModule(
                l,
                "🔑",
                "سطح دسترسی",
                "هر شخص فقط به اطلاعات مجاز دسترسی داشته باشد"
        );

        addModule(
                l,
                "🛡",
                "حریم خصوصی",
                "کنترل نمایش و استفاده از اطلاعات"
        );

        addModule(
                l,
                "📋",
                "ثبت رویداد",
                "ثبت تغییرات مهم سیستم"
        );

        addModule(
                l,
                "⚠️",
                "تشخیص خطر",
                "شناسایی رفتار یا دسترسی غیرعادی"
        );

        addModule(
                l,
                "🔒",
                "حفاظت داده",
                "محافظت از اطلاعات حساس"
        );

        Button settings =
                primaryButton(
                        "⚙️  تنظیمات حریم خصوصی"
                );

        l.addView(settings);

        settings.setOnClickListener(
                v -> showPrivacy()
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // MANAGEMENT
    // =====================================================

    private void showManagement() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "مدیریت RNV",
                        "ساختار و تصمیم‌گیری سیستم"
                )
        );

        l.addView(
                infoText(
                        "⚙️ مدیریت RNV باید بر پایه داده، "
                        + "منطق، مشورت، بررسی پیامدها و "
                        + "حفاظت از هدف اصلی سیستم باشد."
                )
        );

        addModule(
                l,
                "🏛",
                "ساختار",
                "لایه‌های مدیریتی و عملیاتی"
        );

        addModule(
                l,
                "👥",
                "هیئت و مسئولیت‌ها",
                "تعریف نقش‌ها و مسئولیت‌ها"
        );

        addModule(
                l,
                "📊",
                "گزارش و عملکرد",
                "بررسی عملکرد بخش‌ها"
        );

        addModule(
                l,
                "🧠",
                "تصمیم‌گیری",
                "تحلیل داده و پیامد تصمیم‌ها"
        );

        addModule(
                l,
                "💰",
                "سهم و تقسیم منافع",
                "ثبت سهم مشارکت و سازوکار توزیع"
        );

        addModule(
                l,
                "🛡",
                "لایه محافظ",
                "حفاظت از ساختار و مأموریت RNV"
        );

        Button back =
                button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(
                v -> showMainMenu()
        );

        setContentView(
                page(l)
        );
    }

    // =====================================================
    // MODULE CARD
    // =====================================================

    private void addModule(
            LinearLayout parent,
            String icon,
            String titleText,
            String description) {

        Button b =
                cardButton(
                        icon,
                        titleText,
                        description
                );

        parent.addView(b);

        b.setOnClickListener(
                v -> Toast.makeText(
                        this,
                        titleText +
                                " در مرحله توسعه فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );
    }

    // =====================================================
    // BACK
    // =====================================================

    @Override
    public void onBackPressed() {

        showMainMenu();
    }
}
