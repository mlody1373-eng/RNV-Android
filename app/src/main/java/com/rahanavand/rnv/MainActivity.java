package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("RNV_PROFILE", MODE_PRIVATE);

        showMainMenu();
    }

    private LinearLayout createLayout() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 40, 30, 30);
        layout.setBackgroundColor(Color.WHITE);
        return layout;
    }

    private TextView createTitle(String text) {
        TextView title = new TextView(this);
        title.setText(text);
        title.setTextSize(28);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        title.setPadding(10, 20, 10, 30);
        return title;
    }

    private Button createButton(String text) {
        Button button = new Button(this);
        button.setText(text);
        button.setTextSize(18);
        button.setAllCaps(false);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 8);
        button.setLayoutParams(params);

        return button;
    }

    private EditText createInput(String hint) {
        EditText input = new EditText(this);
        input.setHint(hint);
        input.setTextSize(17);
        input.setPadding(15, 10, 15, 10);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 5, 0, 10);
        input.setLayoutParams(params);

        return input;
    }

    private void showMainMenu() {

        LinearLayout layout = createLayout();

        layout.addView(createTitle("راهاناوند | RNV"));

        TextView subtitle = new TextView(this);
        subtitle.setText(
                "RAHANAVAND\n\n" +
                "ارتباط انسان‌ها، مهارت‌ها، آموزش و کار"
        );
        subtitle.setTextSize(18);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setTextColor(Color.DKGRAY);
        layout.addView(subtitle);

        Button peopleButton = createButton("👥 افراد و ارتباط");
        layout.addView(peopleButton);

        Button educationButton = createButton("🎓 آموزش و کشف استعداد");
        layout.addView(educationButton);

        Button workButton = createButton("🛠 کار و مهارت");
        layout.addView(workButton);

        Button marketButton = createButton("🏪 بازار و تولید");
        layout.addView(marketButton);

        Button securityButton = createButton("🔐 حفاظت و امنیت");
        layout.addView(securityButton);

        Button managementButton = createButton("⚙️ مدیریت سیستم");
        layout.addView(managementButton);

        peopleButton.setOnClickListener(v -> showPeopleSection());

        educationButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "بخش آموزش و کشف استعداد در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        workButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "بخش کار و مهارت در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        marketButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "بخش بازار و تولید در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        securityButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "لایه حفاظت و امنیت در حال طراحی است.",
                        Toast.LENGTH_SHORT).show()
        );

        managementButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "بخش مدیریت سیستم در مرحله بعد فعال می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        setContentView(layout);
    }

    private void showPeopleSection() {

        LinearLayout layout = createLayout();

        layout.addView(createTitle("👥 افراد و ارتباط"));

        Button profileButton = createButton("👤 پروفایل من");
        Button searchButton = createButton("🔎 پیدا کردن افراد");
        Button skillsButton = createButton("🧰 مهارت‌ها و تخصص‌ها");
        Button cooperationButton = createButton("🤝 همکاری و ارتباط");
        Button backButton = createButton("⬅️ بازگشت");

        layout.addView(profileButton);
        layout.addView(searchButton);
        layout.addView(skillsButton);
        layout.addView(cooperationButton);

        layout.addView(backButton);

        profileButton.setOnClickListener(v -> showMyProfile());

        searchButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "جستجوی افراد در مرحله اتصال به پایگاه داده فعال می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        skillsButton.setOnClickListener(v -> showSkills());

        cooperationButton.setOnClickListener(v ->
                Toast.makeText(this,
                        "سیستم همکاری و ارتباط در مرحله بعد توسعه داده می‌شود.",
                        Toast.LENGTH_SHORT).show()
        );

        backButton.setOnClickListener(v -> showMainMenu());

        setContentView(layout);
    }

    private void showMyProfile() {

        LinearLayout layout = createLayout();

        layout.addView(createTitle("👤 پروفایل من"));

        EditText name = createInput("نام و نام خانوادگی");
        EditText job = createInput("شغل یا تخصص اصلی");
        EditText experience = createInput("میزان تجربه کاری");
        EditText skills = createInput("مهارت‌ها");
        EditText about = createInput("درباره خودتان");

        name.setText(preferences.getString("name", ""));
        job.setText(preferences.getString("job", ""));
        experience.setText(preferences.getString("experience", ""));
        skills.setText(preferences.getString("skills", ""));
        about.setText(preferences.getString("about", ""));

        layout.addView(name);
        layout.addView(job);
        layout.addView(experience);
        layout.addView(skills);
        layout.addView(about);

        Button saveButton = createButton("💾 ذخیره پروفایل");
        Button backButton = createButton("⬅️ بازگشت");

        layout.addView(saveButton);
        layout.addView(backButton);

        saveButton.setOnClickListener(v -> {

            preferences.edit()
                    .putString("name", name.getText().toString())
                    .putString("job", job.getText().toString())
                    .putString("experience", experience.getText().toString())
                    .putString("skills", skills.getText().toString())
                    .putString("about", about.getText().toString())
                    .apply();

            Toast.makeText(this,
                    "پروفایل با موفقیت ذخیره شد ✅",
                    Toast.LENGTH_SHORT).show();
        });

        backButton.setOnClickListener(v -> showPeopleSection());

        setContentView(layout);
    }

    private void showSkills() {

        LinearLayout layout = createLayout();

        layout.addView(createTitle("🧰 مهارت‌ها و تخصص‌ها"));

        String[] skills = {
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

        for (String skill : skills) {

            Button button = createButton(skill);

            button.setOnClickListener(v ->
                    Toast.makeText(this,
                            "مهارت انتخاب‌شده: " + skill,
                            Toast.LENGTH_SHORT).show()
            );

            layout.addView(button);
        }

        Button backButton = createButton("⬅️ بازگشت");
        layout.addView(backButton);

        backButton.setOnClickListener(v -> showPeopleSection());

        setContentView(layout);
    }

    @Override
    public void onBackPressed() {

        showMainMenu();
    }
}
