package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
        return (int) (v * getResources().getDisplayMetrics().density + .5f);
    }

    @Override
    public void onCreate(Bundle b) {
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

        root.addView(
                shell,
                new FrameLayout.LayoutParams(-1, -1)
        );

        shell.addView(
                topBar(),
                new LinearLayout.LayoutParams(-1, dp(70))
        );

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setVerticalScrollBarEnabled(false);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(
                dp(16),
                dp(12),
                dp(16),
                dp(20)
        );

        scroll.addView(content);

        shell.addView(
                scroll,
                new LinearLayout.LayoutParams(-1, 0, 1)
        );

        shell.addView(
                bottomBar(),
                new LinearLayout.LayoutParams(-1, dp(68))
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

        mp.setMargins(dp(10), 0, 0, 0);

        menu.setOnClickListener(v -> showDrawer());

        bar.addView(menu, mp);

        LinearLayout brand = new LinearLayout(this);
        brand.setOrientation(LinearLayout.VERTICAL);
        brand.setGravity(Gravity.CENTER);

        brand.addView(
                label("RAHANAVAND", 18, WHITE, true),
                new LinearLayout.LayoutParams(-2, dp(27))
        );

        brand.addView(
                label("راهاناوند", 11, CYAN, true),
                new LinearLayout.LayoutParams(-2, dp(20))
        );

        bar.addView(
                brand,
                new FrameLayout.LayoutParams(
                        -2,
                        -2,
                        Gravity.CENTER
                )
        );

        TextView profile = roundButton("م", 18, CYAN);

        FrameLayout.LayoutParams pp =
                new FrameLayout.LayoutParams(
                        dp(48),
                        dp(48),
                        Gravity.END | Gravity.CENTER_VERTICAL
                );

        pp.setMargins(0, 0, dp(10), 0);

        profile.setOnClickListener(v -> account());

        bar.addView(profile, pp);

        return bar;
    }

    private LinearLayout bottomBar() {

        LinearLayout bar = new LinearLayout(this);

        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER);
        bar.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(4, 20, 34));
        bg.setStroke(dp(1), LINE);

        bar.setBackground(bg);

        bottomItem(bar, "⌂", "خانه", true, () -> home());
        bottomItem(bar, "♙", "افراد", false, () -> people());
        bottomItem(bar, "◈", "کار", false, () -> work());
        bottomItem(bar, "▣", "بازار", false, () -> market());
        bottomItem(bar, "●", "حساب من", false, () -> account());

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
        item.setPadding(0, dp(5), 0, dp(3));

        item.addView(
                label(
                        icon,
                        21,
                        active ? CYAN : MUTED,
                        true
                )
        );

        item.addView(
                label(
                        title,
                        9,
                        active ? CYAN : MUTED,
                        false
                )
        );

        item.setOnClickListener(v -> action.run());

        bar.addView(
                item,
                new LinearLayout.LayoutParams(0, -1, 1)
        );
    }

    private void home() {

        clear();

        content.addView(
                new Hero(),
                new LinearLayout.LayoutParams(-1, dp(190))
        );

        space(12);

        content.addView(
                label("سلام میلاد 👋", 22, WHITE, true)
        );

        content.addView(
                label(
                        "به راهاناوند خوش آمدی؛ شبکه‌ای برای اتصال انسان، مهارت، کار، آموزش و بازار.",
                        12,
                        MUTED,
                        false
                ),
                new LinearLayout.LayoutParams(-1, dp(42))
        );

        space(4);

        LinearLayout stats = row();

        stats.addView(
                stat("افراد", "۱۲", "♙", CYAN),
                weight(74, 1)
        );

        gap(stats, 7);

        stats.addView(
                stat("پروژه‌ها", "۵", "◈", BLUE),
                weight(74, 1)
        );

        gap(stats, 7);

        stats.addView(
                stat("مهارت‌ها", "۲۴", "◆", GREEN),
                weight(74, 1)
        );

        content.addView(stats);

        space(20);

        content.addView(
                label(
                        "هسته‌های اصلی راهاناوند",
                        19,
                        WHITE,
                        true
                )
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
                label(
                        "هسته هوشمند راهاناوند",
                        19,
                        WHITE,
                        true
                )
        );

        space(8);

        LinearLayout smart = wideCard();

        smart.addView(
                label("RNV", 25, CYAN, true),
                new LinearLayout.LayoutParams(dp(62), -1)
        );

        LinearLayout tx = col();

        tx.addView(
                label(
                        "اتصال انسان، دانش و فرصت",
                        16,
                        WHITE,
                        true
                )
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
                new LinearLayout.LayoutParams(0, -2, 1)
        );

        content.addView(smart);

        space(22);

        content.addView(
                label(
                        "مسیر عضو",
                        16,
                        WHITE,
                        true
                )
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

    private void people() {
        simplePage(
                "افراد",
                "شبکه انسانی راهاناوند",
                "افراد، تخصص‌ها، تجربه‌ها و توانایی‌ها در این بخش ثبت و به فرصت‌های مناسب متصل می‌شوند.",
                CYAN
        );
    }

    private void work() {
        simplePage(
                "کار و پروژه",
                "اتصال نیروی انسانی به پروژه",
                "پروژه‌ها، نیروها، مهارت‌ها، زمان، اجرا و ارزیابی عملکرد در یک مسیر واحد قرار می‌گیرند.",
                GREEN
        );
    }

    private void market() {
        simplePage(
                "تولید و بازار",
                "کالا، خدمات و بازار",
                "تولیدکننده، فروشنده، خریدار، تأمین‌کننده و بازار در یک شبکه متصل قرار می‌گیرند.",
                BLUE
        );
    }

    private void education() {
        simplePage(
                "آموزش و استعداد",
                "یادگیری و رشد",
                "آموزش، کشف استعداد، مهارت‌آموزی و مسیر ورود به کار بخشی از چرخه رشد عضو است.",
                PURPLE
        );
    }

    private void security() {
        simplePage(
                "امنیت و اعتماد",
                "حفاظت از انسان و اطلاعات",
                "امنیت اطلاعات، دسترسی‌ها، اعتبار اعضا و حفاظت از ساختار راهاناوند در این بخش قرار می‌گیرد.",
                RED
        );
    }

    private void management() {
        simplePage(
                "مدیریت RNV",
                "سیستم، تصمیم و کنترل",
                "مدیریت ساختار، قوانین، تصمیم‌ها، ارزیابی و مسیر توسعه راهاناوند.",
                GOLD
        );
    }

    private void account() {
        simplePage(
                "حساب من",
                "پروفایل عضو",
                "اطلاعات شخصی، مهارت‌ها، سوابق، پروژه‌ها، درآمد و مسیر رشد عضو.",
                CYAN
        );
    }

    private void simplePage(
            String title,
            String subtitle,
            String description,
            int accent) {

        clear();

        space(10);

        LinearLayout header = wideCard();

        LinearLayout texts = col();

        texts.addView(
                label(title, 23, WHITE, true)
        );

        texts.addView(
                label(subtitle, 12, accent, true)
        );

        header.addView(
                texts,
                new LinearLayout.LayoutParams(0, -2, 1)
        );

        header.addView(
                label("RNV", 22, accent, true),
                new LinearLayout.LayoutParams(dp(60), -1)
        );

        content.addView(header);

        space(16);

        content.addView(
                label(description, 14, TEXT, false)
        );

        space(20);

        content.addView(
                sectionBox(
                        "این بخش در حال ساخت است",
                        "در نسخه بعدی، اطلاعات واقعی و ارتباط این بخش با هسته اصلی RNV اضافه می‌شود.",
                        accent
                )
        );
    }

    private LinearLayout sectionBox(
            String title,
            String text,
            int accent) {

        LinearLayout box = cardContainer();

        box.addView(
                label(title, 16, accent, true)
        );

        spaceIn(box, 7);

        box.addView(
                label(text, 12, MUTED, false)
        );

        return box;
    }

    private LinearLayout card(
            String title,
            String subtitle,
            String icon,
            int color,
            final Runnable action) {

        LinearLayout c = cardContainer();

        c.setOnClickListener(v -> action.run());

        TextView ic = label(icon, 26, color, true);

        c.addView(
                ic,
                new LinearLayout.LayoutParams(-1, dp(38))
        );

        c.addView(
                label(title, 14, WHITE, true)
        );

        c.addView(
                label(subtitle, 10, MUTED, false)
        );

        return c;
    }

    private LinearLayout stat(
            String title,
            String value,
            String icon,
            int color) {

        LinearLayout c = cardContainer();

        c.setGravity(Gravity.CENTER);

        c.addView(
                label(icon, 20, color, true)
        );

        c.addView(
                label(value, 20, WHITE, true)
        );

        c.addView(
                label(title, 9, MUTED, false)
        );

        return c;
    }

    private LinearLayout wideCard() {

        LinearLayout c = new LinearLayout(this);

        c.setOrientation(LinearLayout.HORIZONTAL);
        c.setGravity(Gravity.CENTER_VERTICAL);
        c.setPadding(
                dp(14),
                dp(12),
                dp(14),
                dp(12)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(CARD);
        bg.setCornerRadius(dp(18));
        bg.setStroke(dp(1), LINE);

        c.setBackground(bg);

        return c;
    }

    private LinearLayout cardContainer() {

        LinearLayout c = new LinearLayout(this);

        c.setOrientation(LinearLayout.VERTICAL);
        c.setGravity(Gravity.CENTER_VERTICAL);

        c.setPadding(
                dp(13),
                dp(12),
                dp(13),
                dp(12)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(CARD);
        bg.setCornerRadius(dp(18));
        bg.setStroke(dp(1), LINE);

        c.setBackground(bg);

        return c;
    }

    private void moduleRow(
            LinearLayout a,
            LinearLayout b) {

        LinearLayout row = row();

        row.addView(
                a,
                new LinearLayout.LayoutParams(0, dp(120), 1)
        );

        gap(row, 9);

        row.addView(
                b,
                new LinearLayout.LayoutParams(0, dp(120), 1)
        );

        content.addView(row);
    }

    private LinearLayout row() {

        LinearLayout r = new LinearLayout(this);

        r.setOrientation(LinearLayout.HORIZONTAL);
        r.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        return r;
    }

    private LinearLayout col() {

        LinearLayout c = new LinearLayout(this);

        c.setOrientation(LinearLayout.VERTICAL);

        return c;
    }

    private TextView label(
            String text,
            float size,
            int color,
            boolean bold) {

        TextView t = new TextView(this);

        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER_VERTICAL);
        t.setFontFeatureSettings("kern");

        if (bold) {
            t.setTypeface(
                    Typeface.create(
                            "sans",
                            Typeface.BOLD
                    )
            );
        }

        return t;
    }

    private TextView roundButton(
            String text,
            float size,
            int color) {

        TextView t = label(text, size, color, true);

        t.setGravity(Gravity.CENTER);

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(CARD);
        bg.setCornerRadius(dp(16));
        bg.setStroke(dp(1), LINE);

        t.setBackground(bg);

        return t;
    }

    private TextView pillLine(
            String text,
            int color) {

        TextView t = label(
                text,
                10,
                color,
                true
        );

        t.setGravity(Gravity.CENTER);

        t.setPadding(
                dp(10),
                dp(12),
                dp(10),
                dp(12)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(BG2);
        bg.setCornerRadius(dp(18));
        bg.setStroke(dp(1), LINE);

        t.setBackground(bg);

        return t;
    }

    private void clear() {
        if (content != null) {
            content.removeAllViews();
        }
    }

    private void space(int value) {

        View v = new View(this);

        content.addView(
                v,
                new LinearLayout.LayoutParams(
                        1,
                        dp(value)
                )
        );
    }

    private void spaceIn(
            LinearLayout parent,
            int value) {

        View v = new View(this);

        parent.addView(
                v,
                new LinearLayout.LayoutParams(
                        1,
                        dp(value)
                )
        );
    }

    private void gap(
            LinearLayout parent,
            int value) {

        View v = new View(this);

        parent.addView(
                v,
                new LinearLayout.LayoutParams(
                        dp(value),
                        1
                )
        );
    }

    private LinearLayout.LayoutParams weight(
            int width,
            float weight) {

        return new LinearLayout.LayoutParams(
                dp(width),
                -1,
                weight
        );
    }

    private void createDrawer() {

        drawer = new LinearLayout(this);

        drawer.setOrientation(LinearLayout.VERTICAL);
        drawer.setGravity(Gravity.TOP);
        drawer.setPadding(
                dp(18),
                dp(24),
                dp(18),
                dp(20)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(Color.rgb(4, 24, 39));
        bg.setStroke(dp(1), LINE);

        drawer.setBackground(bg);

        drawer.setVisibility(View.GONE);

        FrameLayout.LayoutParams lp =
                new FrameLayout.LayoutParams(
                        dp(300),
                        -1,
                        Gravity.START
                );

        root.addView(drawer, lp);

        drawer.addView(
                label(
                        "RAHANAVAND",
                        22,
                        WHITE,
                        true
                )
        );

        drawer.addView(
                label(
                        "راهاناوند",
                        12,
                        CYAN,
                        true
                )
        );

        drawerItem("⌂  خانه", () -> {
            hideDrawer();
            home();
        });

        drawerItem("♙  افراد", () -> {
            hideDrawer();
            people();
        });

        drawerItem("◆  آموزش و استعداد", () -> {
            hideDrawer();
            education();
        });

        drawerItem("◈  کار و پروژه", () -> {
            hideDrawer();
            work();
        });

        drawerItem("▣  تولید و بازار", () -> {
            hideDrawer();
            market();
        });

        drawerItem("⬢  امنیت و اعتماد", () -> {
            hideDrawer();
            security();
        });

        drawerItem("⌘  مدیریت RNV", () -> {
            hideDrawer();
            management();
        });
    }

    private void drawerItem(
            String title,
            final Runnable action) {

        TextView item = label(
                title,
                14,
                TEXT,
                true
        );

        item.setPadding(
                dp(10),
                dp(16),
                dp(10),
                dp(16)
        );

        item.setOnClickListener(v -> action.run());

        drawer.addView(item);
    }

    private void showDrawer() {

        drawer.setVisibility(View.VISIBLE);
        drawer.bringToFront();
    }

    private void hideDrawer() {

        drawer.setVisibility(View.GONE);
    }

    private class Hero extends View {

        private final Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        Hero() {
            super(MainActivity.this);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);

            int w = getWidth();
            int h = getHeight();

            LinearGradient gradient =
                    new LinearGradient(
                            0,
                            0,
                            w,
                            h,
                            BG2,
                            Color.rgb(4, 44, 58),
                            Shader.TileMode.CLAMP
                    );

            p.setShader(gradient);

            canvas.drawRoundRect(
                    0,
                    0,
                    w,
                    h,
                    dp(24),
                    dp(24),
                    p
            );

            p.setShader(null);

            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(dp(1));
            p.setColor(LINE);

            canvas.drawRoundRect(
                    dp(1),
                    dp(1),
                    w - dp(1),
                    h - dp(1),
                    dp(24),
                    dp(24),
                    p
            );

            p.setStyle(Paint.Style.FILL);

            p.setColor(CYAN);

            canvas.drawCircle(
                    w - dp(48),
                    dp(46),
                    dp(7),
                    p
            );

            p.setColor(Color.argb(35, 0, 235, 215));

            canvas.drawCircle(
                    w - dp(48),
                    dp(46),
                    dp(27),
                    p
            );

            p.setColor(WHITE);
            p.setTextSize(dp(28));
            p.setTypeface(Typeface.DEFAULT_BOLD);
            p.setTextAlign(Paint.Align.CENTER);

            canvas.drawText(
                    "RNV",
                    w / 2f,
                    dp(78),
                    p
            );

            p.setColor(CYAN);
            p.setTextSize(dp(13));

            canvas.drawText(
                    "RAHANAVAND",
                    w / 2f,
                    dp(104),
                    p
            );

            p.setColor(TEXT);
            p.setTextSize(dp(11));

            canvas.drawText(
                    "انسان  •  دانش  •  کار  •  بازار",
                    w / 2f,
                    dp(138),
                    p
            );

            p.setColor(MUTED);
            p.setTextSize(dp(9));

            canvas.drawText(
                    "یک شبکه برای ساختن، یادگرفتن و رشد کردن",
                    w / 2f,
                    dp(164),
                    p
            );
        }
    }
}
