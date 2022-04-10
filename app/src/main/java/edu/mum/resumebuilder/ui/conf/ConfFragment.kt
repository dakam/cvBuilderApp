package edu.mum.resumebuilder.ui.conf

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import edu.mum.resumebuilder.ui.about.ToolsViewModel
import kotlinx.android.synthetic.main.fragment_home_conf.*
import kotlinx.android.synthetic.main.fragment_home_conf.view.*

class ConfFragment: Fragment() {

    private lateinit var toolsViewModel: ToolsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tpro=inflater.inflate(R.layout.fragment_home_conf, container, false)

        tpro.btn_add_conf.setOnClickListener {

            val spfpro = activity?.getSharedPreferences("home", Context.MODE_PRIVATE)
            val spepro = spfpro?.edit()
            spepro?.putString("name", conf_name.text.toString() )
            spepro?.putString("qual", conf_qual.text.toString() )
            spepro?.putString("pos", conf_pos.text.toString() )
            spepro?.apply()
            conf_name.text.clear()
            conf_qual.text.clear()
            conf_pos.text.clear()

        }

        return tpro

    }

    override fun onStart(){
        super.onStart()
        displayInfo();

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

            str += " \n Full Name :"+name.toString().removeSuffix(",") + " \n" + "Qualifications: "+ qual.toString().removeSuffix(",") + " \n" + "Current Position"+pos.toString().removeSuffix(",") + " \n"

        }

        edit_tv_conf.text =str
    }


}