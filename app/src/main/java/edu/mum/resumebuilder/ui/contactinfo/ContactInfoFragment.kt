package edu.mum.resumebuilder.ui.contactinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.mum.resumebuilder.R
import kotlinx.android.synthetic.main.fragment_contacts.*
import kotlinx.android.synthetic.main.fragment_contacts.view.*

class ContactInfoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_contacts, container, false)

        root.btn_contact_add.setOnClickListener(){
            var name:String?=contact_name.text.toString()
            var phone:String?=contact_phone.text.toString()
            var email:String?=contact_email.text.toString()
            var linkedin:String?=contact_linkedin.text.toString()

            val Sharedpreference = activity?.getSharedPreferences("contactinfo", Context.MODE_PRIVATE)
            val edit = Sharedpreference?.edit()
            edit?.putString("name", name)
            edit?.putString("phone", phone)
            edit?.putString("email", email)
            edit?.putString("linkedin", linkedin)
            edit?.apply()
            Toast.makeText(activity,"Data Saved",Toast.LENGTH_LONG).show()
            clear()
            displayContact();
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        var sp:SharedPreferences?=null
        sp=activity?.getSharedPreferences("contactinfo",Context.MODE_PRIVATE)
        var name=sp?.getString("name",null)
        if(name !=null){
            displayContact();
        }
    }
    fun displayContact(){
        var sharedPreferences:SharedPreferences?=null
        var name:String?=null
        var phone:String?=null
        var address:String?=null
        var email:String?=null
        var linkedin:String?=null
        var merge:String?=null

        sharedPreferences=activity?.getSharedPreferences("contactinfo",Context.MODE_PRIVATE)
        name=sharedPreferences?.getString("name",null)
        phone=sharedPreferences?.getString("phone",null)
        address=sharedPreferences?.getString("address",null)
        email=sharedPreferences?.getString("email",null)
        linkedin=sharedPreferences?.getString("linkedin",null)

        merge="Name :" + name + "\n" + "Phone # :" + phone + "\n" + "Email :" + email + "\n" +"Address :" + address + "\n" + "Email :" + email + "\n" +"LinkedIn :" + linkedin + "\n"
        if (merge!=null)
            edit_tv_show.text=merge
    }
    fun clear(){
        contact_name.text.clear()
        contact_linkedin.text.clear()
        contact_phone.text.clear()
        contact_email.text.clear()
    }
}