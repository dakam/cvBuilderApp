package edu.mum.resumebuilder.ui.about

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.view.*

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tpro=inflater.inflate(R.layout.fragment_about, container, false)

        tpro.btn_about_add.setOnClickListener {

            val spfpro = activity?.getSharedPreferences("pro", Context.MODE_PRIVATE)
            val spepro = spfpro?.edit()
            spepro?.putString("name", about_pro.text.toString() )
            spepro?.putString("school", about_school.text.toString() )
            spepro?.putString("year", about_year.text.toString() )
            spepro?.apply()
            about_pro.text.clear()
            about_school.text.clear()
            about_year.text.clear()

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
        var school:String? =""
        var year:String? =""



        spf = activity?.getSharedPreferences("pro", Context.MODE_PRIVATE)
        name = spf?.getString("name","")
        school = spf?.getString("school","")
        year = spf?.getString("year","")


        if (name != null){

            str += " \n Project Name :"+name.toString().removeSuffix(",") + " \n" + "Year Executed: "+ year.toString().removeSuffix(",") + " \n" + "School Name"+school.toString().removeSuffix(",") + " \n"


        }

        edit_tv_about.text =str
    }


}