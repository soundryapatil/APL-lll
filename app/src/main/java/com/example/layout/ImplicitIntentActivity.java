package com.example.layout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ImplicitIntentActivity extends AppCompatActivity {

    EditText editLink;
    Button btnOpen;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        editLink = findViewById(R.id.editLink);
        btnOpen = findViewById(R.id.btnOpen);
        webView = findViewById(R.id.webView);

        // Important for opening inside app
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        btnOpen.setOnClickListener(v -> {

            String url = editLink.getText().toString().trim();

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }

            webView.loadUrl(url);
        });
    }
}
