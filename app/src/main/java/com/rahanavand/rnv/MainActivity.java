package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("RNV_DATA", MODE_PRIVATE);

        showMainMenu();
    }

    private LinearLayout layout() {
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        l.setPadding(25, 30, 25, 30);
        l.setBackgroundColor(Color.WHITE);
        return l;
    }

    private TextView title(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(27);
        t.setTextColor(Color.BLACK);
        t.setGravity(Gravity.CENTER);
        t.setPadding(5, 15, 5, 25);
        return t;
    }

    private TextView label(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(17);
        t.setTextColor(Color.DKGRAY);
        t.setPadding(5, 12, 5, 5);
        return t;
    }

    private Button button(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(17);
        b.setAllCaps(false);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, 6, 0, 6);
        b.setLayoutParams(p);

        return b;
    }

    private EditText input(String hint) {
        EditText e = new EditText(this);
        e.setHint(hint);
        e.setTextSize(17);
        e.setPadding(15, 8, 15, 8);

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

        l.addView(title("راهاناوند | RNV"));

        TextView intro = new TextView(this);
        intro.setText(
                "RAHANAVAND\n\n" +
                "ارتباط انسان‌ها، مهارت‌ها، آموزش و کار"
        );
        intro.setTextSize(18);
        intro.setGravity(Gravity.CENTER);
        intro.setTextColor(Color.DKGRAY);

        l.addView(intro);

        Button people = button("👥 افراد و ارتباط");
        Button education = button("🎓 آموزش و کشف استعداد");
        Button work = button("🛠 کار و مهارت");
        Button market = button("🏪 بازار و تولید");
        Button security = button("🔐 حفاظت و امنیت");
        Button management = button("⚙️ مدیریت سیستم");

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

        setContentView(l);
    }

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

        l.addView(title("👥 افراد و ارتباط"));

        Button profile = button("👤 پروفایل من");
        Button skills = button("🧰 مهارت‌ها و تخصص‌ها");
        Button experience = button("📊 سابقه و تجربه کاری");
        Button search = button("🔎 پیدا کردن افراد");
        Button cooperation = button("🤝 همکاری و ارتباط");
        Button privacy = button("🛡️ حریم خصوصی");

        l.addView(profile);
        l.addView(skills);
        l.addView(experience);
        l.addView(search);
        l.addView(cooperation);
        l.addView(privacy);

        Button back = button("⬅️ بازگشت");
        l.addView(back);

        profile.setOnClickListener(v -> showProfile());
        skills.setOnClickListener(v -> showSkills());
        experience.setOnClickListener(v -> showExperience());
        search.setOnClickListener(v -> showSearch());
        cooperation.setOnClickListener(v -> showCooperation());
        privacy.setOnClickListener(v -> showPrivacy());

        back.setOnClickListener(v -> showMainMenu());

        setContentView(l);
    }

    // =========================
    // پروفایل
    // =========================

    private void showProfile() {

        LinearLayout l = layout();

        l.addView(title("👤 پروفایل من"));

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

        Button save = button("💾 ذخیره پروفایل");
        Button back = button("⬅️ بازگشت");

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
                    "پروفایل ذخیره شد ✅",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // مهارت‌ها
    // =========================

    private void showSkills() {

        LinearLayout l = layout();

        l.addView(title("🧰 مهارت‌ها و تخصص‌ها"));

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

        l.addView(label("مهارت‌های خود را انتخاب کنید:"));

        for (String skill : skills) {

            CheckBox check = new CheckBox(this);
            check.setText(skill);
            check.setTextSize(17);

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

        Button back = button("⬅️ بازگشت");
        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // سابقه کاری
    // =========================

    private void showExperience() {

        LinearLayout l = layout();

        l.addView(title("📊 سابقه و تجربه کاری"));

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

        Button save = button("💾 ذخیره سابقه");
        Button back = button("⬅️ بازگشت");

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
                    "سابقه کاری ذخیره شد ✅",
                    Toast.LENGTH_SHORT
            ).show();
        });

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // جستجوی افراد
    // =========================

    private void showSearch() {

        LinearLayout l = layout();

        l.addView(title("🔎 پیدا کردن افراد"));

        EditText search = input(
                "نام، شغل، تخصص یا مهارت را وارد کنید"
        );

        l.addView(search);

        Button searchButton = button("🔎 جستجو");

        l.addView(searchButton);

        TextView result = new TextView(this);
        result.setText(
                "\nنتایج جستجو در حال حاضر محلی است.\n" +
                "پس از اتصال پایگاه داده RNV، " +
                "افراد و متخصصان قابل جستجو خواهند بود."
        );
        result.setTextSize(17);
        result.setTextColor(Color.DKGRAY);

        l.addView(result);

        searchButton.setOnClickListener(v -> {

            String text = search.getText().toString().trim();

            if (text.isEmpty()) {

                result.setText("لطفاً عبارت جستجو را وارد کنید.");

            } else {

                result.setText(
                        "جستجو برای:\n\n" +
                        text +
                        "\n\nپایگاه داده افراد RNV در مرحله اتصال آنلاین فعال می‌شود."
                );
            }
        });

        Button back = button("⬅️ بازگشت");
        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // همکاری
    // =========================

    private void showCooperation() {

        LinearLayout l = layout();

        l.addView(title("🤝 همکاری و ارتباط"));

        TextView info = new TextView(this);

        info.setText(
                "در این بخش در نسخه‌های بعدی امکان‌های زیر اضافه می‌شود:\n\n" +
                "• ارسال درخواست همکاری\n" +
                "• پذیرش یا رد درخواست\n" +
                "• ارتباط کاری\n" +
                "• مشاهده مهارت‌های طرف مقابل\n" +
                "• تشکیل گروه کاری\n" +
                "• ثبت سابقه همکاری\n" +
                "• امتیازدهی و ارزیابی عملکرد"
        );

        info.setTextSize(17);
        info.setTextColor(Color.DKGRAY);

        l.addView(info);

        Button request = button("➕ ایجاد درخواست همکاری");

        l.addView(request);

        request.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "سیستم درخواست همکاری در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );

        Button back = button("⬅️ بازگشت");
        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // حریم خصوصی
    // =========================

    private void showPrivacy() {

        LinearLayout l = layout();

        l.addView(title("🛡️ حریم خصوصی"));

        l.addView(label(
                "کنترل نمایش اطلاعات پروفایل"
        ));

        CheckBox showPhone =
                new CheckBox(this);

        showPhone.setText(
                "نمایش شماره تماس به افراد دیگر"
        );
        showPhone.setTextSize(17);

        showPhone.setChecked(
                prefs.getBoolean("showPhone", false)
        );

        l.addView(showPhone);

        CheckBox showProfile =
                new CheckBox(this);

        showProfile.setText(
                "نمایش پروفایل برای جستجوی افراد"
        );
        showProfile.setTextSize(17);

        showProfile.setChecked(
                prefs.getBoolean("showProfile", true)
        );

        l.addView(showProfile);

        Button save = button("💾 ذخیره تنظیمات");

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
                    "تنظیمات حریم خصوصی ذخیره شد ✅",
                    Toast.LENGTH_SHORT
            ).show();
        });

        Button back = button("⬅️ بازگشت");
        l.addView(back);

        back.setOnClickListener(v -> showPeople());

        setContentView(l);
    }

    // =========================
    // دکمه برگشت گوشی
    // =========================

    @Override
    public void onBackPressed() {
        showMainMenu();
    }
}
