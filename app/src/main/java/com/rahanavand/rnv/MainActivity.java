package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    private TextView title(String text, int size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(Color.BLACK);
        t.setGravity(Gravity.CENTER);
        t.setTypeface(Typeface.DEFAULT_BOLD);
        t.setPadding(10, 15, 10, 15);
        return t;
    }

    private Button menuButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(17);
        b.setAllCaps(false);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(0, 8, 0, 8);
        b.setLayoutParams(p);

        return b;
    }

    private void showHome() {

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(30, 40, 30, 30);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        mainLayout.setBackgroundColor(Color.WHITE);

        mainLayout.addView(title("RNV", 46));
        mainLayout.addView(title("راهاناوند", 30));
        mainLayout.addView(title("افراد و ارتباط", 24));

        TextView intro = new TextView(this);
        intro.setText(
                "اینجا افراد، مهارت‌ها، تجربه‌ها و ظرفیت‌های همکاری " +
                "در راهاناوند به یکدیگر متصل می‌شوند."
        );
        intro.setTextSize(16);
        intro.setGravity(Gravity.CENTER);
        intro.setTextColor(Color.DKGRAY);
        intro.setPadding(10, 10, 10, 25);
        mainLayout.addView(intro);

        Button profile = menuButton("👤 پروفایل من");
        profile.setOnClickListener(v -> showProfile());
        mainLayout.addView(profile);

        Button people = menuButton("👥 پیدا کردن افراد");
        people.setOnClickListener(v -> showPeople());
        mainLayout.addView(people);

        Button skills = menuButton("🛠 مهارت‌ها و تخصص‌ها");
        skills.setOnClickListener(v -> showSkills());
        mainLayout.addView(skills);

        Button cooperation = menuButton("🤝 همکاری و ارتباط");
        cooperation.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "بخش همکاری در نسخه بعدی فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );
        mainLayout.addView(cooperation);

        Button back = menuButton("← بازگشت به صفحه اصلی");
        back.setOnClickListener(v -> showMainMenu());
        mainLayout.addView(back);

        ScrollView scroll = new ScrollView(this);
        scroll.addView(mainLayout);
        setContentView(scroll);
    }

    private void showProfile() {

        mainLayout.removeAllViews();

        mainLayout.addView(title("👤 پروفایل من", 28));

        EditText name = new EditText(this);
        name.setHint("نام و نام خانوادگی");
        mainLayout.addView(name);

        EditText job = new EditText(this);
        job.setHint("شغل یا تخصص اصلی");
        mainLayout.addView(job);

        EditText experience = new EditText(this);
        experience.setHint("میزان تجربه کاری");
        mainLayout.addView(experience);

        EditText skills = new EditText(this);
        skills.setHint("مهارت‌ها");
        mainLayout.addView(skills);

        EditText about = new EditText(this);
        about.setHint("درباره خودتان");
        about.setMinLines(4);
        mainLayout.addView(about);

        Button save = menuButton("ذخیره اطلاعات");
        save.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "اطلاعات فعلاً در همین نسخه آزمایشی ثبت شد.",
                        Toast.LENGTH_SHORT
                ).show()
        );
        mainLayout.addView(save);

        Button back = menuButton("← بازگشت");
        back.setOnClickListener(v -> showHome());
        mainLayout.addView(back);
    }

    private void showPeople() {

        mainLayout.removeAllViews();

        mainLayout.addView(title("👥 پیدا کردن افراد", 28));

        EditText search = new EditText(this);
        search.setHint("نام، شغل یا مهارت را جست‌وجو کنید");
        mainLayout.addView(search);

        TextView info = new TextView(this);
        info.setText(
                "در نسخه فعلی هنوز اطلاعات کاربران به پایگاه داده متصل نشده است."
        );
        info.setTextSize(16);
        info.setGravity(Gravity.CENTER);
        info.setPadding(10, 30, 10, 30);
        mainLayout.addView(info);

        Button searchButton = menuButton("جست‌وجو");
        searchButton.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "جست‌وجوی واقعی در مرحله اتصال پایگاه داده فعال می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );
        mainLayout.addView(searchButton);

        Button back = menuButton("← بازگشت");
        back.setOnClickListener(v -> showHome());
        mainLayout.addView(back);
    }

    private void showSkills() {

        mainLayout.removeAllViews();

        mainLayout.addView(title("🛠 مهارت‌ها و تخصص‌ها", 28));

        String[] skillList = {
                "ساختمان و عمران",
                "جوشکاری",
                "تأسیسات",
                "برق",
                "فروش و بازاریابی",
                "حسابداری",
                "تولید",
                "مدیریت",
                "فناوری و نرم‌افزار"
        };

        for (String skill : skillList) {
            Button b = menuButton(skill);
            b.setOnClickListener(v ->
                    Toast.makeText(
                            this,
                            "انتخاب شد: " + skill,
                            Toast.LENGTH_SHORT
                    ).show()
            );
            mainLayout.addView(b);
        }

        Button back = menuButton("← بازگشت");
        back.setOnClickListener(v -> showHome());
        mainLayout.addView(back);
    }

    private void showMainMenu() {

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(30, 40, 30, 30);
        mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        mainLayout.setBackgroundColor(Color.WHITE);

        mainLayout.addView(title("RNV", 46));
        mainLayout.addView(title("راهاناوند", 30));
        mainLayout.addView(title("صفحه اصلی", 24));

        Button people = menuButton("👥 افراد و ارتباط");
        people.setOnClickListener(v -> showHome());
        mainLayout.addView(people);

        Button skills = menuButton("🛠 کار و مهارت");
        skills.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        "بخش کار و مهارت در مرحله بعد ساخته می‌شود.",
                        Toast.LENGTH_SHORT
                ).show()
        );
        mainLayout.addView(skills);

        Button education = menuButton("🎓 آموزش و کشف استعداد");
        mainLayout.addView(education);

        Button market = menuButton("🏪 بازار و تولید");
        mainLayout.addView(market);

        Button security = menuButton("🛡 حفاظت و امنیت");
        mainLayout.addView(security);

        Button management = menuButton("⚙ مدیریت سیستم");
        mainLayout.addView(management);

        ScrollView scroll = new ScrollView(this);
        scroll.addView(mainLayout);
        setContentView(scroll);
    }
}
