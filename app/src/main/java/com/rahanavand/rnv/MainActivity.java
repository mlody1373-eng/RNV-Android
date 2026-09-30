package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.*;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

    private final int BG = Color.rgb(3, 14, 27);
    private final int BG2 = Color.rgb(5, 22, 37);
    private final int CARD = Color.rgb(7, 30, 48);
    private final int CARD2 = Color.rgb(8, 38, 58);
    private final int LINE = Color.rgb(17, 73, 92);
    private final int CYAN = Color.rgb(0, 235, 215);
    private final int BLUE = Color.rgb(67, 178, 255);
    private final int GREEN = Color.rgb(49, 220, 153);
    private final int PURPLE = Color.rgb(157, 112, 255);
    private final int GOLD = Color.rgb(235, 170, 62);
    private final int RED = Color.rgb(238, 92, 117);
    private final int WHITE = Color.WHITE;
    private final int TEXT = Color.rgb(225, 238, 245);
    private final int MUTED = Color.rgb(126, 158, 174);

    private FrameLayout root;
    private LinearLayout content;
    private LinearLayout drawer;

    private int dp(float v) {
        return (int)(v * getResources().getDisplayMetrics().density + .5f);
    }

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setStatusBarColor(BG);
        getWindow().setNavigationBarColor(BG);
        build();
    }

    private void build() {
        root = new FrameLayout(this);
        root.setBackgroundColor(BG);
        root.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        LinearLayout shell = new LinearLayout(this);
        shell.setOrientation(LinearLayout.VERTICAL);
        shell.setBackgroundColor(BG);
        root.addView(shell, new FrameLayout.LayoutParams(-1,-1));

        shell.addView(topBar(), new LinearLayout.LayoutParams(-1, dp(70)));

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setVerticalScrollBarEnabled(false);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(16), dp(12), dp(16), dp(20));

        scroll.addView(content);
        shell.addView(scroll, new LinearLayout.LayoutParams(-1,0,1));

        shell.addView(
            bottomBar(),
            new LinearLayout.LayoutParams(-1,dp(68))
        );

        createDrawer();
        setContentView(root);
        home();
    }

    private View topBar() {
        FrameLayout bar = new FrameLayout(this);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(BG);
        bg.setStroke(dp(1), LINE);
        bar.setBackground(bg);

        TextView menu = roundButton("☰", 22, WHITE);

        FrameLayout.LayoutParams mp =
                new FrameLayout.LayoutParams(
                        dp(48),
                        dp(48),
                        Gravity.START | Gravity.CENTER_VERTICAL
                );

        mp.setMargins(dp(10),0,0,0);

        menu.setOnClickListener(v -> showDrawer());
        bar.addView(menu,mp);

        LinearLayout brand = new LinearLayout(this);
        brand.setOrientation(LinearLayout.VERTICAL);
        brand.setGravity(Gravity.CENTER);

        brand.addView(
                label("RAHANAVAND",18,WHITE,true),
                new LinearLayout.LayoutParams(-2,dp(27))
        );

        brand.addView(
                label("راهاناوند",11,CYAN,true),
                new LinearLayout.LayoutParams(-2,dp(20))
        );

        bar.addView(
                brand,
                new FrameLayout.LayoutParams(-2,-2,Gravity.CENTER)
        );

        TextView profile = roundButton("م",18,CYAN);

        FrameLayout.LayoutParams pp =
                new FrameLayout.LayoutParams(
                        dp(48),
                        dp(48),
                        Gravity.END | Gravity.CENTER_VERTICAL
                );

        pp.setMargins(0,0,dp(10),0);

        profile.setOnClickListener(v -> account());
        bar.addView(profile,pp);

        return bar;
    }

    private LinearLayout bottomBar() {
        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER);
        bar.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(4,20,34));
        bg.setStroke(dp(1),LINE);
        bar.setBackground(bg);

        bottomItem(bar,"⌂","خانه",true,()->home());
        bottomItem(bar,"♙","افراد",false,()->people());
        bottomItem(bar,"◈","کار",false,()->work());
        bottomItem(bar,"▣","بازار",false,()->market());
        bottomItem(bar,"●","حساب من",false,()->account());

        return bar;
    }

    private void bottomItem(
            LinearLayout bar,
            String icon,
            String title,
            boolean active,
            final Runnable action) {

        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.VERTICAL);
        item.setGravity(Gravity.CENTER);
        item.setPadding(0,dp(5),0,dp(3));

        item.addView(
                label(icon,21,active ? CYAN : MUTED,true)
        );

        item.addView(
                label(title,9,active ? CYAN : MUTED,false)
        );

        item.setOnClickListener(v -> action.run());

        bar.addView(
                item,
                new LinearLayout.LayoutParams(0,-1,1)
        );
    }

    private void home() {
        clear();

        content.addView(
                new Hero(this),
                new LinearLayout.LayoutParams(-1,dp(190))
        );

        space(12);

        content.addView(
                label("سلام میلاد 👋",22,WHITE,true)
        );

        content.addView(
                label(
                    "به راهاناوند خوش آمدی؛ شبکه‌ای برای اتصال انسان، مهارت، کار، آموزش و بازار.",
                    12,
                    MUTED,
                    false
                ),
                new LinearLayout.LayoutParams(-1,dp(42))
        );

        space(4);

        LinearLayout stats = row();

        stats.addView(
                stat("افراد","۱۲","♙",CYAN),
                weight(74,1)
        );

        gap(stats,7);

        stats.addView(
                stat("پروژه‌ها","۵","◈",BLUE),
                weight(74,1)
        );

        gap(stats,7);

        stats.addView(
                stat("مهارت‌ها","۲۴","◆",GREEN),
                weight(74,1)
        );

        content.addView(stats);

        space(20);

        content.addView(
                label("هسته‌های اصلی راهاناوند",19,WHITE,true)
        );

        space(9);

        moduleRow(
                card(
                    "افراد",
                    "شبکه انسان‌ها",
                    "♙",
                    CYAN,
                    () -> people()
                ),
                card(
                    "آموزش و استعداد",
                    "یادگیری و رشد",
                    "◆",
                    PURPLE,
                    () -> education()
                )
        );

        space(10);

        moduleRow(
                card(
                    "کار و پروژه",
                    "فرصت و اجرا",
                    "◈",
                    GREEN,
                    () -> work()
                ),
                card(
                    "تولید و بازار",
                    "کالا و تجارت",
                    "▣",
                    BLUE,
                    () -> market()
                )
        );

        space(10);

        moduleRow(
                card(
                    "امنیت و اعتماد",
                    "حفاظت و اعتبار",
                    "⬢",
                    RED,
                    () -> security()
                ),
                card(
                    "مدیریت RNV",
                    "سیستم و تصمیم",
                    "⌘",
                    GOLD,
                    () -> management()
                )
        );

        space(20);

        content.addView(
                label("هسته هوشمند راهاناوند",19,WHITE,true)
        );

        space(8);

        LinearLayout smart = wideCard();

        smart.addView(
                label("RNV",25,CYAN,true),
                new LinearLayout.LayoutParams(dp(62),-1)
        );

        LinearLayout tx = col();

        tx.addView(
                label("اتصال انسان، دانش و فرصت",16,WHITE,true)
        );

        tx.addView(
                label(
                    "اطلاعات، مهارت، پروژه، آموزش و بازار در یک ساختار واحد به هم متصل می‌شوند.",
                    11,
                    MUTED,
                    false
                )
        );

        smart.addView(
                tx,
                new LinearLayout.LayoutParams(0,-2,1)
        );

        content.addView(smart);

        space(22);

        content.addView(
                label("مسیر عضو",16,WHITE,true)
        );

        space(7);

        content.addView(
                pillLine(
                    "ورود  →  استعداد‌یابی  →  آموزش  →  کار  →  درآمد  →  تجربه  →  ارتقا",
                    GREEN
                )
        );

        space(18);
    }
