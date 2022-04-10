package edu.mum.resumebuilder.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import edu.mum.resumebuilder.ui.webview.WebViewFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.btn_read_more.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_host_fragment, WebViewFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()

        }

        return root
    }

    override fun onStart(){
        super.onStart()
        displayInfo()
    }

    fun displayInfo(){

        var str =""
        var spf: SharedPreferences? = null
        var name:String? =""
        var qual:String? =""
        var pos:String? =""

        spf = activity?.getSharedPreferences("home", Context.MODE_PRIVATE)
        name = spf?.getString("name","")
        qual = spf?.getString("qual","")
        pos = spf?.getString("pos","")


        if (name != null && name.equals("")==false){
          home_info.visibility=View.VISIBLE
          home_no_info.visibility=View.INVISIBLE
          home_name.text= name.toString()
          home_qualification.text=qual.toString()
          home_position.text=pos.toString()

        }else{

            home_info.visibility=View.INVISIBLE
            home_no_info.visibility=View.VISIBLE
        }

    }
}