package com.example.hp.coffeeh.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hp.coffeeh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment {


    private WebView webView;

    public AboutUs() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        String url = "https://www.facebook.com/coffeehouseyerevan/";

        // or
        webView = view.findViewById(R.id.webView);

        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        return view;
    }
}
