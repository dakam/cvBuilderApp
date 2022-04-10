package edu.mum.resumebuilder.ui.webview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.activity_web_view, container, false)

        return root
    }

    override fun onStart(){
        super.onStart()
        displayInfo()
    }

    override fun onPause() {
        super.onPause()
        getView()?.setVisibility(View.GONE);
    }

    fun displayInfo(){


        var spf: SharedPreferences? = null
        spf = activity?.getSharedPreferences("home", Context.MODE_PRIVATE)
        var name = spf?.getString("name", "")

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webview.loadUrl("https://www.google.com/search?q=%22${name}")


    }
}