package com.arabmingle.demo;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout root, content;
    TextView title;

    TextView tv(String s, int size) {
        TextView t = new TextView(this);
        t.setText(s); t.setTextSize(size); t.setTextColor(Color.WHITE);
        t.setPadding(18,14,18,14);
        return t;
    }

    Button btn(String s) {
        Button b = new Button(this);
        b.setText(s); b.setTextColor(Color.WHITE);
        b.setBackgroundColor(Color.rgb(105,55,180));
        return b;
    }

    void screen(String name) {
        content.removeAllViews();
        title.setText(name);
        if(name.equals("Arab Mingle")) {
            content.addView(tv("🌍 Connect • Chat • Meet", 24));
            content.addView(btn("❤️ اكتشف الأشخاص • Match"));
            content.addView(btn("🎬 Short Mingle"));
            content.addView(btn("💬 Chat"));
            content.addView(btn("📹 Video Call"));
            content.addView(btn("🎲 Ludo Mingle"));
            content.addView(btn("🪙 Coins & Gifts"));
        } else if(name.equals("Short Mingle")) {
            content.addView(tv("🎬 Short Mingle", 24));
            content.addView(tv("فيديوهات قصيرة من المجتمع العربي",18));
            content.addView(btn("❤️ إعجاب"));
            content.addView(btn("💬 تعليق"));
            content.addView(btn("🎁 إرسال Gift"));
        } else if(name.equals("Chat")) {
            content.addView(tv("💬 المحادثات",24));
            content.addView(tv("لا توجد محادثات بعد. اعمل Match للبدء.",18));
        } else if(name.equals("Ludo Mingle")) {
            content.addView(tv("🎲 Ludo Mingle",24));
            content.addView(tv("العب 1 ضد 1 • نقاط وترتيب فقط • بلا قمار",18));
            content.addView(btn("ابدأ مباراة"));
        } else if(name.equals("Privacy & Safety")) {
            content.addView(tv("🔐 مركز الخصوصية والأمان",24));
            content.addView(tv("✓ Email / SMS verification\n✓ Face & Liveness verification\n✓ AI Moderation\n✓ Anti-Bot & Anti-Fraud\n✓ Report / Block\n✓ إدارة صلاحيات الموقع والكاميرا والميكروفون",17));
        }
    }

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        root = new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(11,7,19)); root.setPadding(10,10,10,10);
        title = tv("Arab Mingle",22); title.setTypeface(Typeface.DEFAULT_BOLD);
        root.addView(title);
        content = new LinearLayout(this); content.setOrientation(LinearLayout.VERTICAL);
        ScrollView scroll = new ScrollView(this); scroll.addView(content);
        root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));

        LinearLayout nav = new LinearLayout(this); nav.setGravity(Gravity.CENTER);
        String[] ns={"🏠","🎬","💬","👤"};
        for(String n:ns){ Button x=btn(n); nav.addView(x,new LinearLayout.LayoutParams(0,60,1));
            if(n.equals("🎬")) x.setOnClickListener(v->screen("Short Mingle"));
            else if(n.equals("💬")) x.setOnClickListener(v->screen("Chat"));
            else x.setOnClickListener(v->screen("Arab Mingle"));
        }
        root.addView(nav);
        screen("Arab Mingle");
        setContentView(root);
    }
}
