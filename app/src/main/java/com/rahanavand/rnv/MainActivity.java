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
    // رنگ‌های هویت بصری RNV
    // =========================

    private final int RNV_DARK = Color.rgb(20, 32, 45);
    private final int RNV_PRIMARY = Color.rgb(25, 118, 150);
    private final int RNV_PRIMARY_DARK = Color.rgb(18, 84, 108);
    private final int RNV_LIGHT = Color.rgb(242, 247, 249);
    private final int RNV_CARD = Color.WHITE;
    private final int RNV_TEXT = Color.rgb(30, 40, 48);
    private final int RNV_SECONDARY = Color.rgb(90, 105, 115);
    private final int RNV_BORDER = Color.rgb(220, 228, 232);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("RNV_DATA", MODE_PRIVATE);

        showMainMenu();
    }

    // =========================
    // ابزارهای ظاهری
    // =========================

    private GradientDrawable background(int color, float radius) {

        GradientDrawable drawable = new GradientDrawable();

        drawable.setColor(color);
        drawable.setCornerRadius(radius);
        drawable.setStroke(1, RNV_BORDER);

        return drawable;
    }

    private LinearLayout layout() {

        LinearLayout l = new LinearLayout(this);

        l.setOrientation(LinearLayout.VERTICAL);
        l.setPadding(22, 20, 22, 30);
        l.setBackgroundColor(RNV_LIGHT);

        return l;
    }

    private ScrollView page(LinearLayout content) {

        ScrollView scroll = new ScrollView(this);

        scroll.setFillViewport(true);
        scroll.setBackgroundColor(RNV_LIGHT);
        scroll.addView(content);

        return scroll;
    }

    private TextView title(String text) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextSize(27);
        t.setTextColor(RNV_DARK);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setGravity(Gravity.CENTER);
        t.setPadding(8, 15, 8, 8);

        return t;
    }

    private TextView subtitle(String text) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextSize(15);
        t.setTextColor(RNV_SECONDARY);
        t.setGravity(Gravity.CENTER);
        t.setPadding(10, 0, 10, 20);

        return t;
    }

    private TextView label(String text) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextSize(16);
        t.setTextColor(RNV_TEXT);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setPadding(5, 12, 5, 5);

        return t;
    }

    private TextView infoText(String text) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextSize(16);
        t.setTextColor(RNV_SECONDARY);
        t.setPadding(15, 15, 15, 15);

        t.setBackground(background(RNV_CARD, 20));

        return t;
    }

    // =========================
    // هدر RNV
    // =========================

    private LinearLayout header(String titleText, String subText) {

        LinearLayout box = new LinearLayout(this);

        box.setOrientation(LinearLayout.VERTICAL);
        box.setGravity(Gravity.CENTER);
        box.setPadding(15, 18, 15, 18);

        box.setBackground(background(RNV_CARD, 24));

        TextView logo = new TextView(this);

        logo.setText("RNV");
        logo.setTextSize(30);
        logo.setTextColor(RNV_PRIMARY);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView title = new TextView(this);

        title.setText(titleText);
        title.setTextSize(22);
        title.setTextColor(RNV_DARK);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView sub = new TextView(this);

        sub.setText(subText);
        sub.setTextSize(14);
        sub.setTextColor(RNV_SECONDARY);
        sub.setGravity(Gravity.CENTER);
        sub.setPadding(5, 5, 5, 0);

        box.addView(logo);
        box.addView(title);
        box.addView(sub);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, 0, 0, 18);

        box.setLayoutParams(p);

        return box;
    }

    // =========================
    // کارت اصلی
    // =========================

    private Button cardButton(String icon, String title, String description) {

        LinearLayout container = new LinearLayout(this);

        container.setOrientation(LinearLayout.HORIZONTAL);
        container.setGravity(Gravity.CENTER_VERTICAL);
        container.setPadding(18, 14, 18, 14);

        container.setBackground(background(RNV_CARD, 22));

        TextView iconView = new TextView(this);

        iconView.setText(icon);
        iconView.setTextSize(27);
        iconView.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams iconParams =
                new LinearLayout.LayoutParams(55, 65);

        iconView.setLayoutParams(iconParams);

        LinearLayout texts = new LinearLayout(this);

        texts.setOrientation(LinearLayout.VERTICAL);
        texts.setPadding(10, 0, 5, 0);

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextSize(17);
        titleView.setTextColor(RNV_DARK);
        titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        TextView descView = new TextView(this);

        descView.setText(description);
        descView.setTextSize(13);
        descView.setTextColor(RNV_SECONDARY);
        descView.setPadding(0, 4, 0, 0);

        texts.addView(titleView);
        texts.addView(descView);

        container.addView(iconView);
        container.addView(
                texts,
                new LinearLayout.LayoutParams(
                        0,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        1));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 7, 0, 7);

        container.setLayoutParams(params);

        return createInvisibleButton(container);
    }

    private Button createInvisibleButton(View view) {

        Button button = new Button(this);

        button.setText("");
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setPadding(0, 0, 0, 0);
        button.setMinHeight(0);
        button.setMinimumHeight(0);

        button.setContentDescription("RNV");

        button.setLayoutParams(view.getLayoutParams());

        button.addView(view);

        return button;
    }

    // =========================
    // دکمه استاندارد
    // =========================

    private Button button(String text) {

        Button b = new Button(this);

        b.setText(text);
        b.setTextSize(16);
        b.setTextColor(RNV_DARK);
        b.setAllCaps(false);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        b.setBackground(background(RNV_CARD, 18));

        b.setPadding(15, 8, 15, 8);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, 6, 0, 6);

        b.setLayoutParams(p);

        return b;
    }

    private Button primaryButton(String text) {

        Button b = new Button(this);

        b.setText(text);
        b.setTextSize(16);
        b.setTextColor(Color.WHITE);
        b.setAllCaps(false);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        b.setBackground(background(RNV_PRIMARY, 18));

        b.setPadding(15, 8, 15, 8);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, 8, 0, 8);

        b.setLayoutParams(p);

        return b;
    }

    // =========================
    // ورودی
    // =========================

    private EditText input(String hint) {

        EditText e = new EditText(this);

        e.setHint(hint);
        e.setTextSize(16);
        e.setTextColor(RNV_TEXT);
        e.setHintTextColor(RNV_SECONDARY);
        e.setPadding(16, 10, 16, 10);

        e.setBackground(background(Color.WHITE, 16));

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, 3, 0, 8);

        e.setLayoutParams(p);

        return e;
    }

    // =========================
    // صفحه اصلی
    // =========================

    private void showMainMenu() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "راهاناوند",
                        "ارتباط انسان‌ها، مهارت‌ها، آموزش و کار"));

        TextView welcome = infoText(
                "🌱  یک اکوسیستم برای شناخت توانایی‌ها، "
                        + "یادگیری، همکاری و ساختن آینده.");

        welcome.setGravity(Gravity.CENTER);

        l.addView(welcome);

        Button people =
                cardButton(
                        "👥",
                        "افراد و ارتباط",
                        "پروفایل، مهارت‌ها، تجربه و همکاری");

        Button education =
                cardButton(
                        "🎓",
                        "آموزش و کشف استعداد",
                        "یادگیری و شناسایی توانایی‌ها");

        Button work =
                cardButton(
                        "🛠",
                        "کار و مهارت",
                        "مهارت‌ها و مسیرهای کاری");

        Button market =
                cardButton(
                        "🏪",
                        "بازار و تولید",
                        "تولید، فروش و ارتباط با بازار");

        Button security =
                cardButton(
                        "🔐",
                        "حفاظت و امنیت",
                        "حفاظت از اطلاعات و حریم خصوصی");

        Button management =
                cardButton(
                        "⚙️",
                        "مدیریت سیستم",
                        "ساختار و مدیریت راهاناوند");

        l.addView(people);
        l.addView(education);
        l.addView(work);
        l.addView(market);
        l.addView(security);
        l.addView(management);

        people.setOnClickListener(v -> showPeople());

        education.setOnClickListener(v ->
                comingSoon("آموزش و کشف استعداد"));

        work.setOnClickListener(v ->
                comingSoon("کار و مهارت"));

        market.setOnClickListener(v ->
                comingSoon("بازار و تولید"));

        security.setOnClickListener(v ->
                comingSoon("حفاظت و امنیت"));

        management.setOnClickListener(v ->
                comingSoon("مدیریت سیستم"));

        setContentView(page(l));
    }

    // =========================
    // در حال توسعه
    // =========================

    private void comingSoon(String name) {

        Toast.makeText(
                this,
                name + " در مرحله بعد فعال می‌شود.",
                Toast.LENGTH_SHORT
        ).show();
    }

    // =========================
    // افراد و ارتباط
    // =========================

    private void showPeople() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "افراد و ارتباط",
                        "شناخت افراد، توانایی‌ها و همکاری"));

        Button profile =
                cardButton(
                        "👤",
                        "پروفایل من",
                        "اطلاعات شخصی و معرفی کاری");

        Button skills =
                cardButton(
                        "🧰",
                        "مهارت‌ها و تخصص‌ها",
                        "ثبت و مدیریت مهارت‌های شما");

        Button experience =
                cardButton(
                        "📊",
                        "سابقه و تجربه کاری",
                        "ثبت تجربه‌ها و پروژه‌های انجام‌شده");

        Button search =
                cardButton(
                        "🔎",
                        "پیدا کردن افراد",
                        "جستجوی افراد و متخصصان");

        Button cooperation =
                cardButton(
                        "🤝",
                        "همکاری و ارتباط",
                        "درخواست همکاری و ارتباط کاری");

        Button privacy =
                cardButton(
                        "🛡️",
                        "حریم خصوصی",
                        "کنترل نمایش اطلاعات شما");

        l.addView(profile);
        l.addView(skills);
        l.addView(experience);
        l.addView(search);
        l.addView(cooperation);
        l.addView(privacy);

        Button back = button("←  بازگشت");

        l.addView(back);

        profile.setOnClickListener(v -> showProfile());
        skills.setOnClickListener(v -> showSkills());
        experience.setOnClickListener(v -> showExperience());
        search.setOnClickListener(v -> showSearch());
        cooperation.setOnClickListener(v -> showCooperation());
        privacy.setOnClickListener(v -> showPrivacy());

        back.setOnClickListener(v -> showMainMenu());

        setContentView(page(l));
    }

    // =========================
    // پروفایل
    // =========================

    private void showProfile() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "پروفایل من",
                        "اطلاعات پایه و معرفی کاری"));

        EditText name = input("نام و نام خانوادگی");
        EditText job = input("شغل یا تخصص اصلی");
        EditText city = input("شهر / محدوده فعالیت");
        EditText phone = input("شماره تماس");
        EditText skills = input("مهارت‌های اصلی");
        EditText about = input("معرفی کوتاه");

        name.setText(prefs.getString("name", ""));
        job.setText(prefs.getString("job", ""));
        city.setText(prefs.getString("city", ""));
        phone.setText(prefs.getString("phone", ""));
        skills.setText(prefs.getString("skills", ""));
        about.setText(prefs.getString("about", ""));

        l.addView(label("نام و نام خانوادگی"));
        l.addView(name);

        l.addView(label("شغل یا تخصص اصلی"));
        l.addView(job);

        l.addView(label("شهر / محدوده فعالیت"));
        l.addView(city);

        l.addView(label("شماره تماس"));
        l.addView(phone);

        l.addView(label("مهارت‌های اصلی"));
        l.addView(skills);

        l.addView(label("معرفی کوتاه"));
        l.addView(about);

        Button save = primaryButton("💾  ذخیره پروفایل");
        Button back = button("←  بازگشت");

        l.addView(save);
        l.addView(back);

        save.setOnClickListener(v -> {

            prefs.edit()
                    .putString("name", name.getText().toString())
                    .putString("job", job.getText().toString())
                    .putString("city", city.getText().toString())
                    .putString("phone", phone.getText().toString())
                    .putString("skills", skills.getText().toString())
                    .putString("about", about.getText().toString())
                    .apply();

            Toast.makeText(
                    this,
                    "پروفایل ذخیره شد ✓",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // مهارت‌ها
    // =========================

    private void showSkills() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "مهارت‌ها و تخصص‌ها",
                        "توانایی‌های خود را مشخص کنید"));

        l.addView(
                infoText(
                        "مهارت‌هایی را که در آن‌ها توانایی دارید "
                                + "انتخاب کنید."));

        String[] skills = {
                "ساختمان و عمران",
                "جوشکاری",
                "تأسیسات",
                "برق",
                "نجاری",
                "نقاشی ساختمان",
                "فروش و بازاریابی",
                "حسابداری",
                "تولید",
                "مدیریت",
                "حمل‌ونقل",
                "فناوری و نرم‌افزار"
        };

        for (String skill : skills) {

            CheckBox check = new CheckBox(this);

            check.setText(skill);
            check.setTextSize(16);
            check.setTextColor(RNV_TEXT);
            check.setPadding(8, 7, 8, 7);

            String saved =
                    prefs.getString("selectedSkills", "");

            if (saved.contains("|" + skill + "|")) {
                check.setChecked(true);
            }

            l.addView(check);

            check.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> {

                        String current =
                                prefs.getString("selectedSkills", "");

                        String item = "|" + skill + "|";

                        if (isChecked && !current.contains(item)) {
                            current += item;
                        }

                        if (!isChecked) {
                            current = current.replace(item, "");
                        }

                        prefs.edit()
                                .putString("selectedSkills", current)
                                .apply();
                    });
        }

        Button back = button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // سابقه کاری
    // =========================

    private void showExperience() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "سابقه و تجربه کاری",
                        "تجربه‌های عملی خود را ثبت کنید"));

        EditText years = input("چند سال سابقه کار دارید؟");
        EditText projects = input("مهم‌ترین پروژه‌ها یا کارها");
        EditText specialty = input("تخصص اصلی");
        EditText quality = input("توضیح درباره کیفیت و توانایی کار");

        years.setText(prefs.getString("years", ""));
        projects.setText(prefs.getString("projects", ""));
        specialty.setText(prefs.getString("specialty", ""));
        quality.setText(prefs.getString("quality", ""));

        l.addView(label("سابقه کاری"));
        l.addView(years);

        l.addView(label("پروژه‌ها و تجربه‌ها"));
        l.addView(projects);

        l.addView(label("تخصص اصلی"));
        l.addView(specialty);

        l.addView(label("توانایی و کیفیت کار"));
        l.addView(quality);

        Button save = primaryButton("💾  ذخیره سابقه");
        Button back = button("←  بازگشت");

        l.addView(save);
        l.addView(back);

        save.setOnClickListener(v -> {

            prefs.edit()
                    .putString("years", years.getText().toString())
                    .putString("projects", projects.getText().toString())
                    .putString("specialty", specialty.getText().toString())
                    .putString("quality", quality.getText().toString())
                    .apply();

            Toast.makeText(
                    this,
                    "سابقه کاری ذخیره شد ✓",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // جستجوی افراد
    // =========================

    private void showSearch() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "پیدا کردن افراد",
                        "جستجو بر اساس نام، شغل و مهارت"));

        EditText search =
                input("نام، شغل، تخصص یا مهارت را وارد کنید");

        l.addView(search);

        Button searchButton =
                primaryButton("🔎  جستجو");

        l.addView(searchButton);

        TextView result = infoText(
                "نتایج جستجو در حال حاضر محلی است.\n\n"
                        + "پس از اتصال پایگاه داده RNV، "
                        + "افراد و متخصصان قابل جستجو خواهند بود.");

        result.setTextSize(15);

        l.addView(result);

        searchButton.setOnClickListener(v -> {

            String text =
                    search.getText().toString().trim();

            if (text.isEmpty()) {

                result.setText(
                        "لطفاً عبارت جستجو را وارد کنید.");

            } else {

                result.setText(
                        "جستجو برای:\n\n"
                                + text
                                + "\n\nپایگاه داده افراد RNV "
                                + "در مرحله اتصال آنلاین فعال می‌شود."
                );
            }
        });

        Button back = button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // همکاری
    // =========================

    private void showCooperation() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "همکاری و ارتباط",
                        "ساختن ارتباط‌های کاری سالم و هدفمند"));

        TextView info = infoText(
                "در نسخه‌های بعدی امکانات زیر اضافه می‌شود:\n\n"
                        + "• ارسال درخواست همکاری\n"
                        + "• پذیرش یا رد درخواست\n"
                        + "• ارتباط کاری\n"
                        + "• مشاهده مهارت‌های طرف مقابل\n"
                        + "• تشکیل گروه کاری\n"
                        + "• ثبت سابقه همکاری\n"
                        + "• ارزیابی عملکرد"
        );

        l.addView(info);

        Button request =
                primaryButton("＋  ایجاد درخواست همکاری");

        l.addView(request);

        request.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "سیستم درخواست همکاری در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );

        Button back = button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // حریم خصوصی
    // =========================

    private void showPrivacy() {

        LinearLayout l = layout();

        l.addView(
                header(
                        "حریم خصوصی",
                        "کنترل اطلاعاتی که دیگران می‌بینند"));

        l.addView(
                infoText(
                        "اطلاعات شخصی باید تحت کنترل صاحب پروفایل باشد."
                ));

        l.addView(
                label("کنترل نمایش اطلاعات پروفایل"));

        CheckBox showPhone =
                new CheckBox(this);

        showPhone.setText(
                "نمایش شماره تماس به افراد دیگر"
        );

        showPhone.setTextSize(16);
        showPhone.setTextColor(RNV_TEXT);

        showPhone.setChecked(
                prefs.getBoolean("showPhone", false)
        );

        l.addView(showPhone);

        CheckBox showProfile =
                new CheckBox(this);

        showProfile.setText(
                "نمایش پروفایل برای جستجوی افراد"
        );

        showProfile.setTextSize(16);
        showProfile.setTextColor(RNV_TEXT);

        showProfile.setChecked(
                prefs.getBoolean("showProfile", true)
        );

        l.addView(showProfile);

        Button save =
                primaryButton("💾  ذخیره تنظیمات");

        l.addView(save);

        save.setOnClickListener(v -> {

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
                    "تنظیمات حریم خصوصی ذخیره شد ✓",
                    Toast.LENGTH_SHORT
            ).show();
        });

        Button back = button("←  بازگشت");

        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(page(l));
    }

    // =========================
    // برگشت گوشی
    // =========================

    @Override
    public void onBackPressed() {

        showMainMenu();
    }
}
