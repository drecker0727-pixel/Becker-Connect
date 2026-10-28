package br.com.becker.connect;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;

public class MainActivity extends Activity {
    private final int background = Color.rgb(12, 20, 19);
    private final int foreground = Color.rgb(236, 246, 241);
    private final int secondary = Color.rgb(155, 173, 165);
    private final int green = Color.rgb(45, 211, 141);

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        renderHome();
    }

    private int dp(int v) { return (int)(getResources().getDisplayMetrics().density * v); }

    private TextView label(String text, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(color);
        t.setTextSize(size);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    private GradientDrawable shape(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radius));
        return d;
    }

    private void renderHome() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(background);
        root.setPadding(dp(20), dp(36), dp(20), dp(16));
        setContentView(root);

        TextView title = label("Becker Connect", 29, foreground, true);
        root.addView(title);
        TextView subtitle = label("Seu espaço privado de comunicação", 14, secondary, false);
        subtitle.setPadding(0, dp(6), 0, dp(30));
        root.addView(subtitle);

        TextView tabs = label("Conversas     Grupos     Chamadas", 16, green, true);
        tabs.setPadding(0, 0, 0, dp(22));
        root.addView(tabs);

        ScrollView scroll = new ScrollView(this);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(content);

        addCard(content, "💬", "Conversas particulares", "Troque mensagens com pessoas convidadas.");
        addCard(content, "👥", "Grupos privados", "Converse com amigos e familiares.");
        addCard(content, "📞", "Chamadas e vídeo", "Em preparação: chamadas em tempo real.");
        addCard(content, "🔐", "Acesso por convite", "Em preparação: cadastro e autenticação segura.");

        TextView disclaimer = label("Protótipo visual • mensagens e ligações ainda não estão conectadas.", 12, secondary, false);
        disclaimer.setGravity(Gravity.CENTER);
        disclaimer.setPadding(dp(4), dp(14), dp(4), dp(8));
        root.addView(disclaimer);
    }

    private void addCard(LinearLayout parent, String emoji, String headline, String description) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(18), dp(16), dp(18), dp(16));
        card.setBackground(shape(Color.rgb(26, 42, 37), 18));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.bottomMargin = dp(13);
        parent.addView(card, lp);

        TextView heading = label(emoji + "  " + headline, 17, foreground, true);
        card.addView(heading);
        TextView details = label(description, 14, secondary, false);
        details.setPadding(0, dp(10), 0, 0);
        card.addView(details);
    }
}
