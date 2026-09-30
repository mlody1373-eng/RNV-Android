package com.rahanavand.rnv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    // =========================
    // RNV COLOR SYSTEM
    // =========================

    private final int BG = Color.rgb(3, 13, 25);
    private final int BG2 = Color.rgb(5, 21, 36);

    private final int CARD = Color.rgb(7, 29, 47);
    private final int CARD2 = Color.rgb(9, 39, 60);

    private final int CYAN = Color.rgb(0, 235, 215);
    private final int CYAN2 = Color.rgb(0, 180, 190);

    private final int WHITE = Color.WHITE;
    private final int TEXT = Color.rgb(225, 239, 245);
    private final int MUTED = Color.rgb(130, 160, 175);

    private FrameLayout root;
    private LinearLayout mainLayout;
    private LinearLayout content;
    private LinearLayout drawer;

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(BG);
        getWindow().setNavigationBarColor(BG);

        buildApp();
    }

    // =========================
    // MAIN APP
    // =========================

    private void buildApp() {

        root = new FrameLayout(this);
        root.setBackgroundColor(BG);

        mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(BG);

        root.addView(
                mainLayout,
                new FrameLayout.LayoutParams(
                        -1,
                        -1
                )
        );

        createTopBar();

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setVerticalScrollBarEnabled(false);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(
                dp(16),
                dp(10),
                dp(16),
                dp(18)
        );

        scroll.addView(content);

        mainLayout.addView(
                scroll,
                new LinearLayout.LayoutParams(
                        -1,
                        0,
                        1
                )
        );

        createHome();

        createBottomBar();

        createDrawer();

        setContentView(root);
    }

    // =========================
    // TOP BAR
    // =========================

    private void createTopBar() {

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER_VERTICAL);
        bar.setPadding(
                dp(16),
                dp(10),
                dp(14),
                dp(8)
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(BG);
        bg.setStroke(dp(1), Color.rgb(15, 55, 72));
        bar.setBackground(bg);

        TextView profile = circleButton("م");
        profile.setTextColor(CYAN);
        profile.setOnClickListener(v -> showDrawer());

        bar.addView(
                profile,
                new LinearLayout.LayoutParams(
                        dp(44),
                        dp(44)
                )
        );

        LinearLayout titleBox = new LinearLayout(this);
        titleBox.setOrientation(LinearLayout.VERTICAL);
        titleBox.setGravity(Gravity.CENTER);
        titleBox.setPadding(dp(12), 0, dp(12), 0);

        TextView title = text(
                "RAHANAVAND",
                17,
                WHITE,
                true
        );

        TextView subtitle = text(
                "راهاناوند",
                12,
                CYAN,
                false
        );

        titleBox.addView(title);
        titleBox.addView(subtitle);

        bar.addView(
                titleBox,
                new LinearLayout.LayoutParams(
                        0,
                        -2,
                        1
                )
        );

        TextView menu = circleButton("☰");
        menu.setTextColor(WHITE);
        menu.setTextSize(21);
        menu.setOnClickListener(v -> showDrawer());

        bar.addView(
                menu,
                new LinearLayout.LayoutParams(
                        dp(44),
                        dp(44)
                )
        );

        mainLayout.addView(
                bar,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(66)
                )
        );
    }

    // =========================
    // HOME
    // =========================

    private void createHome() {

        // HERO
        content.addView(
                new HeroView(this),
                new LinearLayout.LayoutParams(
                        -1,
                        dp(180)
                )
        );

        addSpace(14);

        TextView welcome = text(
                "به راهاناوند خوش آمدی",
                22,
                WHITE,
                true
        );

        content.addView(welcome);

        TextView welcomeSub = text(
                "انسان • مهارت • کار • آموزش • تولید • بازار",
                13,
                MUTED,
                false
        );

        content.addView(
                welcomeSub,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(28)
                )
        );

        addSpace(10);

        // QUICK STATUS
        LinearLayout status = new LinearLayout(this);
        status.setOrientation(LinearLayout.HORIZONTAL);
        status.setGravity(Gravity.CENTER_VERTICAL);

        status.addView(
                miniStat("افراد", "۰", "👥"),
                weightParams()
        );

        addHorizontalSpace(8);

        status.addView(
                miniStat("پروژه‌ها", "۰", "◈"),
                weightParams()
        );

        addHorizontalSpace(8);

        status.addView(
                miniStat("مهارت‌ها", "۰", "◆"),
                weightParams()
        );

        content.addView(status);

        addSpace(22);

        TextView section = text(
                "هسته‌های اصلی راهاناوند",
                18,
                WHITE,
                true
        );

        content.addView(section);

        addSpace(10);

        // GRID ROW 1
        LinearLayout row1 = horizontalRow();

        row1.addView(
                moduleCard(
                        "افراد",
                        "شبکه انسان‌ها",
                        "👥",
                        CYAN
                ),
                weightParams()
        );

        addHorizontalSpace(10);

        row1.addView(
                moduleCard(
                        "آموزش و استعداد",
                        "یادگیری و رشد",
                        "◆",
                        Color.rgb(90, 200, 255)
                ),
                weightParams()
        );

        content.addView(row1);

        addSpace(10);

        // GRID ROW 2
        LinearLayout row2 = horizontalRow();

        row2.addView(
                moduleCard(
                        "کار و پروژه",
                        "فرصت و اجرا",
                        "◈",
                        Color.rgb(0, 220, 180)
                ),
                weightParams()
        );

        addHorizontalSpace(10);

        row2.addView(
                moduleCard(
                        "تولید و بازار",
                        "کالا و تجارت",
                        "▣",
                        Color.rgb(70, 180, 255)
                ),
                weightParams()
        );

        content.addView(row2);

        addSpace(10);

        // GRID ROW 3
        LinearLayout row3 = horizontalRow();

        row3.addView(
                moduleCard(
                        "امنیت و اعتماد",
                        "حفاظت و اعتبار",
                        "⬢",
                        Color.rgb(0, 200, 210)
                ),
                weightParams()
        );

        addHorizontalSpace(10);

        row3.addView(
                moduleCard(
                        "مدیریت RNV",
                        "سیستم و تصمیم",
                        "⌘",
                        Color.rgb(120, 220, 255)
                ),
                weightParams()
        );

        content.addView(row3);

        addSpace(22);

        TextView systemTitle = text(
                "هسته هوشمند راهاناوند",
                18,
                WHITE,
                true
        );

        content.addView(systemTitle);

        addSpace(8);

        LinearLayout systemCard = glassCard();

        TextView systemIcon = text(
                "RNV",
                22,
                CYAN,
                true
        );

        systemCard.addView(
                systemIcon,
                new LinearLayout.LayoutParams(
                        dp(60),
                        dp(60)
                )
        );

        LinearLayout systemText = new LinearLayout(this);
        systemText.setOrientation(LinearLayout.VERTICAL);
        systemText.setGravity(Gravity.CENTER_VERTICAL);

        TextView st1 = text(
                "اتصال انسان، دانش و فرصت",
                16,
                WHITE,
                true
        );

        TextView st2 = text(
                "راهاناوند اطلاعات، مهارت، پروژه، آموزش و بازار را در یک ساختار واحد به هم متصل می‌کند.",
                12,
                MUTED,
                false
        );

        systemText.addView(st1);
        systemText.addView(st2);

        systemCard.addView(
                systemText,
                new LinearLayout.LayoutParams(
                        0,
                        -2,
                        1
                )
        );

        content.addView(systemCard);

        addSpace(30);
    }

    // =========================
    // HERO VIEW
    // =========================

    private class HeroView extends View {

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        public HeroView(android.content.Context context) {
            super(context);
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
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
                            Color.rgb(4, 30, 47),
                            Color.rgb(2, 12, 26),
                            Shader.TileMode.CLAMP
                    );

            paint.setShader(gradient);

            canvas.drawRoundRect(
                    0,
                    0,
                    w,
                    h,
                    dp(22),
                    dp(22),
                    paint
            );

            paint.setShader(null);

            // glow
            paint.setShadowLayer(
                    dp(28),
                    0,
                    0,
                    CYAN
            );

            paint.setColor(Color.rgb(0, 80, 85));

            canvas.drawCircle(
                    w - dp(45),
                    dp(40),
                    dp(45),
                    paint
            );

            paint.clearShadowLayer();

            // network lines
            paint.setStrokeWidth(dp(1));
            paint.setColor(Color.rgb(0, 120, 135));

            for (int i = 0; i < 6; i++) {

                float x1 = w - dp(30) - i * dp(32);
                float y1 = dp(35) + i * dp(20);

                canvas.drawLine(
                        x1,
                        y1,
                        w - dp(10),
                        dp(130),
                        paint
                );
            }

            // main RNV
            paint.setColor(CYAN);
            paint.setTextSize(dp(38));
            paint.setTypeface(Typeface.create(
                    Typeface.DEFAULT,
                    Typeface.BOLD
            ));

            canvas.drawText(
                    "RNV",
                    dp(22),
                    dp(60),
                    paint
            );

            paint.setColor(WHITE);
            paint.setTextSize(dp(19));

            canvas.drawText(
                    "راهاناوند",
                    dp(24),
                    dp(91),
                    paint
            );

            paint.setColor(MUTED);
            paint.setTextSize(dp(12));

            canvas.drawText(
                    "یک شبکه برای ساختن آینده",
                    dp(24),
                    dp(118),
                    paint
            );

            // glowing node
            paint.setColor(CYAN);

            for (int i = 0; i < 4; i++) {

                canvas.drawCircle(
                        dp(26 + i * 22),
                        h - dp(25),
                        dp(3),
                        paint
                );
            }

            paint.setColor(Color.rgb(90, 130, 145));
            paint.setTextSize(dp(10));

            canvas.drawText(
                    "HUMAN  •  SKILL  •  WORK  •  MARKET",
                    dp(24),
                    h - dp(10),
                    paint
            );
        }
    }

    // =========================
    // MODULE CARD
    // =========================

    private LinearLayout moduleCard(
            String title,
            String sub,
            String icon,
            int accent
    ) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER_VERTICAL);
        card.setPadding(
                dp(13),
                dp(13),
                dp(13),
                dp(13)
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(dp(18));
        bg.setStroke(dp(1), Color.rgb(17, 65, 82));

        card.setBackground(bg);

        TextView iconView = text(
                icon,
                25,
                accent,
                true
        );

        card.addView(
                iconView,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(34)
                )
        );

        TextView titleView = text(
                title,
                14,
                WHITE,
                true
        );

        card.addView(titleView);

        TextView subView = text(
                sub,
                10,
                MUTED,
                false
        );

        card.addView(subView);

        card.setOnClickListener(v ->
                openModule(title)
        );

        return card;
    }

    // =========================
    // MINI STAT
    // =========================

    private LinearLayout miniStat(
            String title,
            String value,
            String icon
    ) {

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setGravity(Gravity.CENTER);
        box.setPadding(
                dp(6),
                dp(8),
                dp(6),
                dp(8)
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(BG2);
        bg.setCornerRadius(dp(14));
        bg.setStroke(dp(1), Color.rgb(15, 55, 72));

        box.setBackground(bg);

        TextView ic = text(
                icon,
                17,
                CYAN,
                true
        );

        TextView val = text(
                value,
                15,
                WHITE,
                true
        );

        TextView name = text(
                title,
                10,
                MUTED,
                false
        );

        box.addView(ic);
        box.addView(val);
        box.addView(name);

        return box;
    }

    // =========================
    // BOTTOM BAR
    // =========================

    private void createBottomBar() {

        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setGravity(Gravity.CENTER);
        bar.setPadding(
                dp(8),
                dp(7),
                dp(8),
                dp(7)
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(4, 20, 33));
        bg.setStroke(dp(1), Color.rgb(13, 52, 69));

        bar.setBackground(bg);

        addBottomItem(bar, "⌂", "خانه", true);
        addBottomItem(bar, "♙", "افراد", false);
        addBottomItem(bar, "◈", "کار", false);
        addBottomItem(bar, "▣", "بازار", false);
        addBottomItem(bar, "●", "حساب من", false);

        mainLayout.addView(
                bar,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(70)
                )
        );
    }

    private void addBottomItem(
            LinearLayout bar,
            String icon,
            String name,
            boolean active
    ) {

        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.VERTICAL);
        item.setGravity(Gravity.CENTER);

        TextView ic = text(
                icon,
                20,
                active ? CYAN : MUTED,
                true
        );

        TextView title = text(
                name,
                10,
                active ? CYAN : MUTED,
                false
        );

        item.addView(ic);
        item.addView(title);

        bar.addView(
                item,
                new LinearLayout.LayoutParams(
                        0,
                        -1,
                        1
                )
        );
    }

    // =========================
    // DRAWER
    // =========================

    private void createDrawer() {

        drawer = new LinearLayout(this);
        drawer.setOrientation(LinearLayout.VERTICAL);
        drawer.setPadding(
                dp(20),
                dp(45),
                dp(20),
                dp(20)
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(4, 22, 37));
        bg.setStroke(dp(1), CYAN2);

        drawer.setBackground(bg);

        FrameLayout.LayoutParams params =
                new FrameLayout.LayoutParams(
                        dp(310),
                        -1,
                        Gravity.END
                );

        params.setMargins(
                dp(25),
                0,
                0,
                0
        );

        TextView close = text(
                "×",
                34,
                WHITE,
                false
        );

        close.setGravity(Gravity.END);

        close.setOnClickListener(
                v -> hideDrawer()
        );

        drawer.addView(
                close,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(50)
                )
        );

        TextView logo = text(
                "RNV",
                38,
                CYAN,
                true
        );

        drawer.addView(logo);

        TextView name = text(
                "راهاناوند",
                20,
                WHITE,
                true
        );

        drawer.addView(name);

        TextView desc = text(
                "شبکه انسان، مهارت، کار و بازار",
                12,
                MUTED,
                false
        );

        drawer.addView(desc);

        addSpaceTo(drawer, 25);

        drawerItem(drawer, "⌂", "خانه");
        drawerItem(drawer, "♙", "افراد");
        drawerItem(drawer, "◆", "آموزش و استعداد");
        drawerItem(drawer, "◈", "کار و پروژه");
        drawerItem(drawer, "▣", "تولید و بازار");
        drawerItem(drawer, "⬢", "امنیت و اعتماد");
        drawerItem(drawer, "⌘", "مدیریت RNV");

        drawer.setVisibility(View.GONE);

        root.addView(drawer, params);
    }

    private void drawerItem(
            LinearLayout parent,
            String icon,
            String title
    ) {

        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.HORIZONTAL);
        item.setGravity(Gravity.CENTER_VERTICAL);
        item.setPadding(
                dp(12),
                dp(10),
                dp(12),
                dp(10)
        );

        TextView ic = text(
                icon,
                20,
                CYAN,
                true
        );

        item.addView(
                ic,
                new LinearLayout.LayoutParams(
                        dp(45),
                        dp(45)
                )
        );

        TextView t = text(
                title,
                14,
                WHITE,
                false
        );

        item.addView(
                t,
                new LinearLayout.LayoutParams(
                        0,
                        -2,
                        1
                )
        );

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(7, 31, 48));
        bg.setCornerRadius(dp(14));

        item.setBackground(bg);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        -1,
                        dp(58)
                );

        p.setMargins(0, 0, 0, dp(8));

        parent.addView(item, p);
    }

    private void showDrawer() {

        if (drawer != null) {
            drawer.setVisibility(View.VISIBLE);
            drawer.bringToFront();
        }
    }

    private void hideDrawer() {

        if (drawer != null) {
            drawer.setVisibility(View.GONE);
        }
    }

    // =========================
    // MODULE PAGE
    // =========================

    private void openModule(String title) {

        content.removeAllViews();

        TextView back = text(
                "‹  بازگشت",
                15,
                CYAN,
                true
        );

        back.setPadding(
                dp(4),
                dp(10),
                0,
                dp(10)
        );

        back.setOnClickListener(v -> {
            content.removeAllViews();
            createHome();
        });

        content.addView(back);

        addSpace(10);

        TextView header = text(
                title,
                28,
                WHITE,
                true
        );

        content.addView(header);

        TextView line = text(
                "ماژول در حال آماده‌سازی ساختار عملیاتی RNV",
                13,
                MUTED,
                false
        );

        content.addView(line);

        addSpace(25);

        LinearLayout card = glassCard();

        TextView rnv = text(
                "RNV",
                34,
                CYAN,
                true
        );

        card.addView(
                rnv,
                new LinearLayout.LayoutParams(
                        -1,
                        dp(65)
                )
        );

        TextView info = text(
                "این بخش به هسته اصلی راهاناوند متصل است و در نسخه‌های بعدی اطلاعات، افراد، پروژه‌ها، آموزش، بازار و فرآیندهای مرتبط را مدیریت خواهد کرد.",
                14,
                TEXT,
                false
        );

        card.addView(info);

        content.addView(card);
    }

    // =========================
    // HELPERS
    // =========================

    private TextView text(
            String value,
            float size,
            int color,
            boolean bold
    ) {

        TextView t = new TextView(this);

        t.setText(value);
        t.setTextColor(color);
        t.setTextSize(size);
        t.setGravity(Gravity.CENTER_VERTICAL);

        if (bold) {
            t.setTypeface(
                    Typeface.create(
                            Typeface.DEFAULT,
                            Typeface.BOLD
                    )
            );
        }

        return t;
    }

    private TextView circleButton(String value) {

        TextView t = text(
                value,
                17,
                WHITE,
                true
        );

        t.setGravity(Gravity.CENTER);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setShape(GradientDrawable.OVAL);
        bg.setStroke(
                dp(1),
                Color.rgb(20, 75, 90)
        );

        t.setBackground(bg);

        return t;
    }

    private LinearLayout glassCard() {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.HORIZONTAL);
        card.setGravity(Gravity.CENTER_VERTICAL);

        card.setPadding(
                dp(15),
                dp(15),
                dp(15),
                dp(15)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(CARD2);
        bg.setCornerRadius(dp(19));
        bg.setStroke(
                dp(1),
                Color.rgb(18, 78, 95)
        );

        card.setBackground(bg);

        return card;
    }

    private LinearLayout horizontalRow() {

        LinearLayout row = new LinearLayout(this);

        row.setOrientation(LinearLayout.HORIZONTAL);

        row.setGravity(Gravity.CENTER);

        return row;
    }

    private LinearLayout.LayoutParams weightParams() {

        return new LinearLayout.LayoutParams(
                0,
                dp(115),
                1
        );
    }

    private void addSpace(int size) {

        SpaceView space = new SpaceView(this);

        content.addView(
                space,
                new LinearLayout.LayoutParams(
                        1,
                        dp(size)
                )
        );
    }

    private void addHorizontalSpace(int size) {

        SpaceView space = new SpaceView(this);

        space.setLayoutParams(
                new LinearLayout.LayoutParams(
                        dp(size),
                        1
                )
        );
    }

    private void addSpaceTo(
            LinearLayout parent,
            int size
    ) {

        SpaceView space = new SpaceView(this);

        parent.addView(
                space,
                new LinearLayout.LayoutParams(
                        1,
                        dp(size)
                )
        );
    }

    private class SpaceView extends View {

        public SpaceView(android.content.Context context) {
            super(context);
        }
    }
}
