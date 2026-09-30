package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final int BG = Color.rgb(3, 17, 31);
    private final int PANEL = Color.rgb(4, 25, 42);
    private final int CARD = Color.rgb(7, 34, 55);
    private final int CARD2 = Color.rgb(9, 43, 66);

    private final int CYAN = Color.rgb(0, 235, 215);
    private final int CYAN_DARK = Color.rgb(0, 150, 155);

    private final int WHITE = Color.WHITE;
    private final int MUTED = Color.rgb(165, 196, 210);

    private final int GREEN = Color.rgb(35, 220, 145);
    private final int PURPLE = Color.rgb(145, 95, 245);
    private final int ORANGE = Color.rgb(245, 170, 45);
    private final int RED = Color.rgb(235, 75, 105);
    private final int BLUE = Color.rgb(45, 150, 245);

    private LinearLayout root;
    private LinearLayout content;
    private LinearLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.setStatusBarColor(BG);
        window.setNavigationBarColor(BG);

        buildApp();
    }

    private void buildApp() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BG);
        root.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        root.addView(
                buildTopBar(),
                new LinearLayout.LayoutParams(-1, dp(64))
        );

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setBackgroundColor(BG);
        content.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setVerticalScrollBarEnabled(false);
        scroll.addView(content);

        root.addView(
                scroll,
                new LinearLayout.LayoutParams(-1, 0, 1)
        );

        root.addView(
                buildBottomBar(),
                new LinearLayout.LayoutParams(-1, dp(68))
        );

        drawer = buildDrawer();
        drawer.setVisibility(View.GONE);

        root.addView(
                drawer,
                new LinearLayout.LayoutParams(-1, -1)
        );

        setContentView(root);

        showHome();
    }

    private View buildTopBar() {

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER_VERTICAL);
        bar.setPadding(dp(12), dp(8), dp(12), dp(8));
        bar.setBackgroundColor(PANEL);
        bar.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        TextView profile = text("👤", 24, WHITE);
        profile.setGravity(Gravity.CENTER);
        profile.setBackground(
                round(CARD2, CYAN_DARK, 1, 22)
        );

        bar.addView(
                profile,
                new LinearLayout.LayoutParams(dp(44), dp(44))
        );

        LinearLayout nameBox = new LinearLayout(this);
        nameBox.setOrientation(LinearLayout.VERTICAL);
        nameBox.setGravity(Gravity.CENTER_VERTICAL);
        nameBox.setPadding(dp(10), 0, dp(8), 0);

        TextView name = text("میلاد تشکر", 15, WHITE);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        TextView role = text("کاربر راهاناوند", 11, MUTED);

        nameBox.addView(name);
        nameBox.addView(role);

        bar.addView(
                nameBox,
                new LinearLayout.LayoutParams(0, -1, 1)
        );

        LinearLayout logoBox = new LinearLayout(this);
        logoBox.setOrientation(LinearLayout.VERTICAL);
        logoBox.setGravity(Gravity.CENTER);

        TextView logo = text("RNV", 25, WHITE);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView persian = text("راهاناوند", 10, CYAN);
        persian.setGravity(Gravity.CENTER);

        logoBox.addView(logo);
        logoBox.addView(persian);

        bar.addView(
                logoBox,
                new LinearLayout.LayoutParams(dp(82), -1)
        );

        TextView menu = text("☰", 27, WHITE);
        menu.setGravity(Gravity.CENTER);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDrawer();
            }
        });

        bar.addView(
                menu,
                new LinearLayout.LayoutParams(dp(48), dp(48))
        );

        return bar;
    }

    private void showHome() {

        content.removeAllViews();

        TextView hello = text("سلام میلاد 👋", 18, WHITE);
        hello.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        hello.setGravity(Gravity.RIGHT);

        content.addView(
                hello,
                lp(16, 14, 16, 6)
        );

        TextView subtitle = text(
                "اینجا انسان، مهارت، کار، آموزش و بازار در یک شبکه به هم متصل می‌شوند.",
                12,
                MUTED
        );

        subtitle.setGravity(Gravity.RIGHT);

        content.addView(
                subtitle,
                lp(16, 0, 16, 12)
        );

        TextView welcome = text(
                "به راهاناوند خوش آمدی\nمسیر رشد، همکاری و آینده بهتر را با هم می‌سازیم.",
                16,
                WHITE
        );

        welcome.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        welcome.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        welcome.setPadding(
                dp(18),
                dp(14),
                dp(18),
                dp(14)
        );

        LinearLayout.LayoutParams welcomeParams =
                new LinearLayout.LayoutParams(-1, dp(96));

        welcomeParams.setMargins(
                dp(12),
                dp(4),
                dp(12),
                dp(10)
        );

        content.addView(welcome, welcomeParams);

        welcome.setBackground(
                roundGradient(
                        CARD2,
                        Color.rgb(7, 80, 94),
                        CYAN_DARK
                )
        );

        TextView section = text(
                "هسته‌های اصلی راهاناوند",
                16,
                WHITE
        );

        section.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        section.setGravity(Gravity.RIGHT);

        content.addView(
                section,
                lp(16, 4, 16, 8)
        );

        LinearLayout row1 = new LinearLayout(this);
        row1.setOrientation(LinearLayout.HORIZONTAL);
        row1.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        row1.addView(
                moduleCard(
                        "👥",
                        "افراد",
                        "مهارت‌ها • تجربه • ارتباط",
                        GREEN
                )
        );

        row1.addView(
                moduleCard(
                        "🎓",
                        "آموزش و استعداد",
                        "یادگیری • رشد • مسیر",
                        PURPLE
                )
        );

        content.addView(
                row1,
                new LinearLayout.LayoutParams(-1, dp(124))
        );

        LinearLayout row2 = new LinearLayout(this);
        row2.setOrientation(LinearLayout.HORIZONTAL);
        row2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        row2.addView(
                moduleCard(
                        "🧰",
                        "کار و پروژه",
                        "نیرو • پروژه • اجرا",
                        ORANGE
                )
        );

        row2.addView(
                moduleCard(
                        "📈",
                        "تولید و بازار",
                        "خرید • فروش • خدمات",
                        GREEN
                )
        );

        content.addView(
                row2,
                new LinearLayout.LayoutParams(-1, dp(124))
        );

        LinearLayout row3 = new LinearLayout(this);
        row3.setOrientation(LinearLayout.HORIZONTAL);
        row3.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        row3.addView(
                moduleCard(
                        "🛡️",
                        "امنیت و اعتماد",
                        "هویت • دسترسی • حریم",
                        RED
                )
        );

        row3.addView(
                moduleCard(
                        "⚙️",
                        "مدیریت RNV",
                        "ساختار • گزارش • کنترل",
                        BLUE
                )
        );

        content.addView(
                row3,
                new LinearLayout.LayoutParams(-1, dp(124))
        );

        TextView network = text(
                "🌄  با هم آینده بهتر می‌سازیم\nشبکه‌ای برای فرصت‌های برابر، رشد پایدار و همکاری واقعی.",
                14,
                WHITE
        );

        network.setGravity(
                Gravity.RIGHT | Gravity.CENTER_VERTICAL
        );

        network.setPadding(
                dp(18),
                dp(10),
                dp(18),
                dp(10)
        );

        LinearLayout.LayoutParams networkParams =
                new LinearLayout.LayoutParams(-1, dp(92));

        networkParams.setMargins(
                dp(12),
                dp(10),
                dp(12),
                dp(18)
        );

        content.addView(network, networkParams);

        network.setBackground(
                roundGradient(
                        PANEL,
                        Color.rgb(5, 60, 72),
                        CYAN_DARK
                )
        );
    }

    private View moduleCard(
            String icon,
            String name,
            String desc,
            int accent
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(8)
        );

        card.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        card.setBackground(
                round(CARD, accent, 1, 18)
        );

        TextView iconView = text(
                icon,
                28,
                WHITE
        );

        iconView.setGravity(Gravity.CENTER);

        card.addView(
                iconView,
                new LinearLayout.LayoutParams(-1, dp(42))
        );

        TextView titleView = text(
                name,
                13,
                WHITE
        );

        titleView.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        titleView.setGravity(Gravity.CENTER);

        card.addView(
                titleView,
                new LinearLayout.LayoutParams(-1, dp(24))
        );

        TextView descView = text(
                desc,
                9,
                MUTED
        );

        descView.setGravity(Gravity.CENTER);

        card.addView(
                descView,
                new LinearLayout.LayoutParams(-1, dp(28))
        );

        card.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showModule(name);
                    }
                }
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        0,
                        -1,
                        1
                );

        params.setMargins(
                dp(6),
                dp(5),
                dp(6),
                dp(5)
        );

        card.setLayoutParams(params);

        return card;
    }

    private View buildBottomBar() {

        LinearLayout bar = new LinearLayout(this);

        bar.setOrientation(
                LinearLayout.HORIZONTAL
        );

        bar.setGravity(Gravity.CENTER);
        bar.setBackgroundColor(PANEL);

        bar.setPadding(
                dp(4),
                dp(4),
                dp(4),
                dp(4)
        );

        bar.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        bar.addView(
                navItem(
                        "⌂",
                        "خانه",
                        true,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showHome();
                            }
                        }
                )
        );

        bar.addView(
                navItem(
                        "👥",
                        "افراد",
                        false,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showModule("افراد");
                            }
                        }
                )
        );

        bar.addView(
                navItem(
                        "🧰",
                        "کار",
                        false,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showModule("کار و پروژه");
                            }
                        }
                )
        );

        bar.addView(
                navItem(
                        "📊",
                        "بازار",
                        false,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showModule("تولید و بازار");
                            }
                        }
                )
        );

        bar.addView(
                navItem(
                        "👤",
                        "حساب من",
                        false,
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showModule("حساب من");
                            }
                        }
                )
        );

        return bar;
    }

    private View navItem(
            String icon,
            String label,
            boolean selected,
            View.OnClickListener listener
    ) {

        LinearLayout item = new LinearLayout(this);

        item.setOrientation(
                LinearLayout.VERTICAL
        );

        item.setGravity(Gravity.CENTER);

        TextView i = text(
                icon,
                21,
                selected ? CYAN : MUTED
        );

        i.setGravity(Gravity.CENTER);

        TextView t = text(
                label,
                10,
                selected ? WHITE : MUTED
        );

        t.setGravity(Gravity.CENTER);

        item.addView(i);
        item.addView(t);

        item.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        0,
                        -1,
                        1
                );

        item.setLayoutParams(params);

        return item;
    }

    private LinearLayout buildDrawer() {

        LinearLayout panel = new LinearLayout(this);

        panel.setOrientation(
                LinearLayout.VERTICAL
        );

        panel.setPadding(
                dp(12),
                dp(16),
                dp(12),
                dp(16)
        );

        panel.setBackgroundColor(BG);

        panel.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        LinearLayout head = new LinearLayout(this);

        head.setGravity(
                Gravity.CENTER_VERTICAL
        );

        TextView logo = text(
                "RNV",
                27,
                WHITE
        );

        logo.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        head.addView(
                logo,
                new LinearLayout.LayoutParams(
                        0,
                        dp(45),
                        1
                )
        );

        TextView close = text(
                "✕",
                23,
                WHITE
        );

        close.setGravity(Gravity.CENTER);

        close.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawer.setVisibility(View.GONE);
                    }
                }
        );

        head.addView(
                close,
                new LinearLayout.LayoutParams(
                        dp(48),
                        dp(45)
                )
        );

        panel.addView(head);

        TextView brand = text(
                "راهاناوند",
                20,
                CYAN
        );

        brand.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        brand.setGravity(Gravity.RIGHT);

        panel.addView(
                brand,
                lp(12, 0, 12, 4)
        );

        TextView tagline = text(
                "انسان، مهارت، کار، آموزش و بازار در یک شبکه",
                11,
                MUTED
        );

        tagline.setGravity(Gravity.RIGHT);

        panel.addView(
                tagline,
                lp(12, 0, 12, 18)
        );

        addDrawerItem(
                panel,
                "👤",
                "پروفایل و اطلاعات",
                "مهارت‌ها • سابقه • رزومه",
                "پروفایل"
        );

        addDrawerItem(
                panel,
                "🧰",
                "مهارت‌ها",
                "ثبت و مدیریت مهارت‌ها",
                "مهارت‌ها"
        );

        addDrawerItem(
                panel,
                "🧱",
                "پروژه‌ها",
                "پروژه‌های من و پیشنهادها",
                "پروژه‌ها"
        );

        addDrawerItem(
                panel,
                "🎓",
                "آموزش‌ها",
                "دوره‌ها • مسیر یادگیری",
                "آموزش و استعداد"
        );

        addDrawerItem(
                panel,
                "🏪",
                "بازار و کسب‌وکار",
                "خرید • فروش • خدمات",
                "تولید و بازار"
        );

        addDrawerItem(
                panel,
                "🛡️",
                "امنیت و حریم خصوصی",
                "تنظیمات دسترسی • امنیت",
                "امنیت و اعتماد"
        );

        addDrawerItem(
                panel,
                "💬",
                "پشتیبانی",
                "راهنما • سوالات متداول",
                "پشتیبانی"
        );

        TextView logout = text(
                "⏻  خروج",
                14,
                RED
        );

        logout.setGravity(Gravity.CENTER);

        panel.addView(
                logout,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(58)
                )
        );

        return panel;
    }

    private void addDrawerItem(
            LinearLayout panel,
            String icon,
            String name,
            String desc,
            final String target
    ) {

        LinearLayout item = new LinearLayout(this);

        item.setOrientation(
                LinearLayout.HORIZONTAL
        );

        item.setGravity(
                Gravity.CENTER_VERTICAL
        );

        item.setPadding(
                dp(10),
                dp(7),
                dp(10),
                dp(7)
        );

        item.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        item.setBackground(
                round(
                        CARD,
                        Color.rgb(15, 65, 85),
                        1,
                        16
                )
        );

        TextView iconView = text(
                icon,
                23,
                WHITE
        );

        iconView.setGravity(Gravity.CENTER);

        item.addView(
                iconView,
                new LinearLayout.LayoutParams(
                        dp(45),
                        dp(55)
                )
        );

        LinearLayout info = new LinearLayout(this);

        info.setOrientation(
                LinearLayout.VERTICAL
        );

        TextView n = text(
                name,
                13,
                WHITE
        );

        n.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        TextView d = text(
                desc,
                9,
                MUTED
        );

        info.addView(n);
        info.addView(d);

        item.addView(
                info,
                new LinearLayout.LayoutParams(
                        0,
                        dp(55),
                        1
                )
        );

        TextView arrow = text(
                "‹",
                24,
                CYAN
        );

        arrow.setGravity(Gravity.CENTER);

        item.addView(
                arrow,
                new LinearLayout.LayoutParams(
                        dp(30),
                        dp(55)
                )
        );

        item.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawer.setVisibility(View.GONE);
                        showModule(target);
                    }
                }
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        dp(69)
                );

        params.setMargins(
                0,
                dp(4),
                0,
                dp(4)
        );

        panel.addView(item, params);
    }

    private void toggleDrawer() {

        drawer.setVisibility(
                drawer.getVisibility() == View.VISIBLE
                        ? View.GONE
                        : View.VISIBLE
        );
    }

    private void showModule(String module) {

        content.removeAllViews();

        TextView back = text(
                "‹  بازگشت به خانه",
                13,
                CYAN
        );

        back.setGravity(
                Gravity.RIGHT | Gravity.CENTER_VERTICAL
        );

        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showHome();
                    }
                }
        );

        content.addView(
                back,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(52)
                )
        );

        TextView heading = text(
                module,
                22,
                WHITE
        );

        heading.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        heading.setGravity(Gravity.RIGHT);

        content.addView(
                heading,
                lp(16, 4, 16, 5)
        );

        TextView description = text(
                "این بخش هسته قابل توسعه راهاناوند است. اطلاعات واقعی، ارتباطات و فرآیندها در اینجا قرار می‌گیرند.",
                12,
                MUTED
        );

        description.setGravity(Gravity.RIGHT);

        content.addView(
                description,
                lp(16, 0, 16, 16)
        );

        if (module.equals("افراد")) {

            addInfoCard(
                    "👥",
                    "شبکه افراد",
                    "پروفایل، مهارت، تجربه، سابقه و ارتباطات افراد.",
                    GREEN
            );

            addInfoCard(
                    "⭐",
                    "ارزیابی عملکرد",
                    "ثبت تجربه کاری، کیفیت، رضایت و رشد مهارت.",
                    CYAN
            );

            addInfoCard(
                    "🔗",
                    "ارتباط و همکاری",
                    "اتصال افراد مناسب به پروژه‌ها و فرصت‌های کاری.",
                    BLUE
            );

        } else if (module.equals("آموزش و استعداد")) {

            addInfoCard(
                    "🎓",
                    "مسیر یادگیری",
                    "آموزش مرحله‌ای متناسب با توانایی و هدف فرد.",
                    PURPLE
            );

            addInfoCard(
                    "🧠",
                    "کشف استعداد",
                    "شناخت توانایی‌ها و پیشنهاد مسیرهای مناسب.",
                    CYAN
            );

            addInfoCard(
                    "📚",
                    "دانش عملی",
                    "ثبت روش‌های واقعی انجام کار برای آموزش نسل بعد.",
                    GREEN
            );

        } else if (module.equals("کار و پروژه")) {

            addInfoCard(
                    "🧰",
                    "پروژه‌های فعال",
                    "ثبت پروژه، نیازها، نیروها، زمان و مراحل اجرا.",
                    ORANGE
            );

            addInfoCard(
                    "👷",
                    "تطبیق نیرو و کار",
                    "پیشنهاد افراد بر اساس مهارت و تناسب با پروژه.",
                    BLUE
            );

            addInfoCard(
                    "✅",
                    "کنترل کیفیت",
                    "ثبت نتیجه، کیفیت تحویل، زمان و رضایت مشتری.",
                    GREEN
            );

        } else if (module.equals("تولید و بازار")) {

            addInfoCard(
                    "🏪",
                    "محصول و خدمات",
                    "نمایش و مدیریت محصولات، خدمات و ظرفیت تولید.",
                    GREEN
            );

            addInfoCard(
                    "📦",
                    "منابع و مصالح",
                    "اتصال منابع، تأمین‌کنندگان و نیازهای پروژه.",
                    ORANGE
            );

            addInfoCard(
                    "📈",
                    "بازار",
                    "اتصال عرضه، تقاضا، فروش و همکاری‌های تجاری.",
                    BLUE
            );

        } else if (module.equals("امنیت و اعتماد")) {

            addInfoCard(
                    "🛡️",
                    "حریم خصوصی",
                    "مدیریت سطح دسترسی و حفاظت از اطلاعات حساس.",
                    RED
            );

            addInfoCard(
                    "🔐",
                    "امنیت حساب",
                    "کنترل ورود، دسترسی‌ها و رویدادهای امنیتی.",
                    CYAN
            );

            addInfoCard(
                    "✓",
                    "اعتماد",
                    "ثبت سوابق و شفافیت فرآیندها برای همکاری مطمئن.",
                    GREEN
            );

        } else if (module.equals("مدیریت RNV")) {

            addInfoCard(
                    "📊",
                    "گزارش‌ها و تحلیل",
                    "مشاهده وضعیت افراد، پروژه‌ها، بازار و عملکرد.",
                    BLUE
            );

            addInfoCard(
                    "⚙️",
                    "تنظیمات سیستم",
                    "مدیریت ساختار، نقش‌ها، مجوزها و فرآیندها.",
                    CYAN
            );

            addInfoCard(
                    "🧩",
                    "معماری راهاناوند",
                    "اتصال هسته‌های مختلف برای ساخت یک اکوسیستم یکپارچه.",
                    PURPLE
            );

        } else {

            addInfoCard(
                    "👤",
                    module,
                    "این بخش آماده توسعه و اتصال به داده‌های واقعی RNV است.",
                    CYAN
            );
        }
    }

    private void addInfoCard(
            String icon,
            String heading,
            String desc,
            int accent
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(
                LinearLayout.HORIZONTAL
        );

        card.setGravity(
                Gravity.CENTER_VERTICAL
        );

        card.setPadding(
                dp(12),
                dp(8),
                dp(12),
                dp(8)
        );

        card.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        card.setBackground(
                round(CARD, accent, 1, 18)
        );

        TextView ic = text(
                icon,
                28,
                WHITE
        );

        ic.setGravity(Gravity.CENTER);

        card.addView(
                ic,
                new LinearLayout.LayoutParams(
                        dp(54),
                        dp(70)
                )
        );

        LinearLayout info = new LinearLayout(this);

        info.setOrientation(
                LinearLayout.VERTICAL
        );

        TextView h = text(
                heading,
                15,
                WHITE
        );

        h.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        h.setGravity(Gravity.RIGHT);

        TextView d = text(
                desc,
                10,
                MUTED
        );

        d.setGravity(Gravity.RIGHT);

        info.addView(
                h,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(27)
                )
        );

        info.addView(
                d,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(38)
                )
        );

        card.addView(
                info,
                new LinearLayout.LayoutParams(
                        0,
                        dp(70),
                        1
                )
        );

        content.addView(
                card,
                lp(12, 6, 12, 6)
        );
    }

    private TextView text(
            String value,
            float size,
            int color
    ) {

        TextView view = new TextView(this);

        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);

        view.setGravity(
                Gravity.CENTER_VERTICAL
        );

        view.setLayoutDirection(
                View.LAYOUT_DIRECTION_RTL
        );

        view.setTextDirection(
                View.TEXT_DIRECTION_RTL
        );

        return view;
    }

    private GradientDrawable round(
            int color,
            int strokeColor,
            int strokeWidth,
            int radiusDp
    ) {

        GradientDrawable drawable =
                new GradientDrawable();

        drawable.setColor(color);

        drawable.setCornerRadius(
                dp(radiusDp)
        );

        if (strokeWidth > 0) {
            drawable.setStroke(
                    dp(strokeWidth),
                    strokeColor
            );
        }

        return drawable;
    }

    private GradientDrawable roundGradient(
            int start,
            int end,
            int stroke
    ) {

        GradientDrawable drawable =
                new GradientDrawable(
                        GradientDrawable.Orientation.TL_BR,
                        new int[]{start, end}
                );

        drawable.setCornerRadius(
                dp(20)
        );

        drawable.setStroke(
                dp(1),
                stroke
        );

        return drawable;
    }

    private LinearLayout.LayoutParams lp(
            int left,
            int top,
            int right,
            int bottom
    ) {

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        -2
                );

        params.setMargins(
                dp(left),
                dp(top),
                dp(right),
                dp(bottom)
        );

        return params;
    }

    private int dp(int value) {

        return (int)
                (
                        value *
                        getResources()
                                .getDisplayMetrics()
                                .density
                        + 0.5f
                );
    }
}
