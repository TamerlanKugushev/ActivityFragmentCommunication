package com.example.activityfragmentcommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class MainActivity : AppCompatActivity(), OnCommunicatorFragmentToActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val blankFragment = BlankFragment()
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, blankFragment)
                    .commit()
        }

        btn_pass_data.setOnClickListener {
            val name = edit_name.text.toString()
            val surname = edit_surname.text.toString()
            val fatherName = edit_fatherName.text.toString()
            val fragment = supportFragmentManager.findFragmentById(R.id.container) as? OnCommunicatorActivityToFragment
            fragment?.onPassData(name, surname, fatherName) ?: throw ClassCastException("ERROR!!!")

        }
    }

    override fun onPassData(textAnswer: String) {
        textViewAnswer.text = textAnswer
    }
}


//    interface OnCommunicatorActivityToFragment {
//        fun onPassData(name: String, surname: String, fatherName: String)
//    }