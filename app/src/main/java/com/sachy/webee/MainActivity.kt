package com.sachy.webee

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebSettings.PluginState
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView1)
        webView!!.getSettings().setJavaScriptEnabled(true)
        webView!!.getSettings().setLoadWithOverviewMode(true);
        webView!!.getSettings().setUseWideViewPort(true);
        webView!!.getSettings().setPluginState(PluginState.ON);
        webView!!.getSettings().setDomStorageEnabled(true);


        webView!!.loadUrl("https://www.exerciseera.com/search")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webView!!.canGoBack()) {
                        webView!!.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}