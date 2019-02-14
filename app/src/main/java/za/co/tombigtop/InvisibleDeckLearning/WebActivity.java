package za.co.tombigtop.InvisibleDeckLearning;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import za.co.tombigtop.InvisibleDeckLearning.R;

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
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBuiltInZoomControls(true);
        //todo: how to check if internet connected and use backup if necessary? -> see below:
        //doesn't seem to work if wifi connected but no internet...
        //otherwise good check.
        //solution from https://stackoverflow.com/questions/17959561/android-how-to-prevent-webview-to-load-when-no-internet-connection
        //may be a better solution there.
        if (!checkInternetConnection(this)) {
            // LOCAL RESOURCE
            mWebView.loadUrl("file:///android_asset/site.htm");
        } else{
//            mWebView.loadUrl("https://circusscientist.com");
            mWebView.loadUrl("https://www.circusscientist.com/2019/02/10/test-private-post");
            mWebView.setWebViewClient(new MyWebViewClient());
        }
        // REMOTE RESOURCE
//        mWebView.loadUrl("https://circusscientist.com");
//        mWebView.setWebViewClient(new MyWebViewClient());

        //need to have this as backup if no internet connection:

        // LOCAL RESOURCE
//         mWebView.loadUrl("file:///android_asset/site.htm");
//         setContentView(mWebView);
//        mWebView.setWebViewClient(new MyWebViewClient()); //not necessary?
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