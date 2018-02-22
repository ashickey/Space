package com.example.phobo.space;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by phobo on 21-Feb-18.
 */

public class PortalActivity extends AppCompatActivity {

    WebView mWebView;
    TextView texttab1;
    ImageView Splashfuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portal_activity);

        mWebView = findViewById(R.id.uniklecitie);
        Splashfuck = findViewById(R.id.splashlogo);

        if(NetworkState.isInternetAvailable(this); {

            // Fucking settings for the webview
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setEnableSmoothTransition(true);
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setLoadsImagesAutomatically(true);
            webSettings.getLoadsImagesAutomatically();
            mWebView.getSettings().setAppCacheEnabled(true);
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.getSettings().setBuiltInZoomControls(false);
            mWebView.getSettings().setDisplayZoomControls(false);

            mWebView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Splashfuck.setVisibility(View.GONE);
                    mWebView.setVisibility(View.VISIBLE);


                }
            });
            mWebView.loadUrl("https://online2.unikl.edu.my/");
            mWebView.setVisibility(View.GONE);
            Splashfuck.setVisibility(View.VISIBLE);

        }else{

            texttab1 = findViewById(R.id.tvtab1);
            texttab1.setVisibility(View.VISIBLE);
            Snackbar snackbar = Snackbar
                    .make(PortalActivity.this.findViewById(android.R.id.content), "Please click setting to configure your connection", Snackbar.LENGTH_INDEFINITE)
                    .setAction("SETTING", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                            /*Snackbar snackbar1 = Snackbar.make(getActivity().findViewById(android.R.id.content), "Message is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();*/
                        }
                    });

            snackbar.show();

        }

       /* mWebView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "UniKL");
                DownloadManager dm = (DownloadManager) getContext().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getContext(), "UniKL is downloading your request", //To notify the Client that the file is being downloaded
                        Toast.LENGTH_LONG).show();

            }
        });*/

    }
}
