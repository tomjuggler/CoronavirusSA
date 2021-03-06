package za.co.tomjuggler.CoronaVirusSA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_web);

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        mWebView.clearCache(true);
        mWebView.clearHistory();
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.setWebChromeClient(new WebChromeClient());
        // Enable Javascript (may need this?)
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBuiltInZoomControls(true);
        //todo: how to check if internet connected and use backup if necessary? -> see below:
        //doesn't seem to work if wifi connected but no internet...
        //otherwise good check.
        //solution from https://stackoverflow.com/questions/17959561/android-how-to-prevent-webview-to-load-when-no-internet-connection
        //may be a better solution there.
        if (!checkInternetConnection(this)) {
            // OFFLINE, USE LOCAL RESOURCE:
            mWebView.loadUrl("file:///android_asset/site.htm");
        } else{
            //todo: test digitalocean hosted video play in webview.
            // REMOTE RESOURCE:
           //center for disease control website here:
            mWebView.loadUrl("https://www.circusscientist.com/coronalinksSA/");
            mWebView.setWebViewClient(new MyWebViewClient());
        }
        //hmmm download?////////////////////////////////////////////////
        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        //////////////////////////////////////////////////////////////////


    }

    // Prevent the back-button from closing the app
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public static boolean checkInternetConnection(Context context) {

        ConnectivityManager con_manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected());
    }
}