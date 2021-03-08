package com.example.activityfragmentcommunication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*
import java.lang.ClassCastException


class BlankFragment : Fragment(), OnCommunicatorActivityToFragment {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        view.btn_send_answer.setOnClickListener {
            val textAnswer = editTextAnswer.text.toString()
            val activity = requireActivity() as? OnCommunicatorFragmentToActivity
            activity?.onPassData(textAnswer) ?: throw ClassCastException("ERROR!!!")
        }
        return view
    }

    override fun onPassData(name: String, surname: String, fatherName: String) {
        text_name.text = name
        text_surname.text = surname
        text_fatherName.text = fatherName
    }
}


//    override fun onPassData(name: String, surname: String, fatherName: String) {
//        text_name.text = name
//        text_surname.text = surname
//        text_fatherName.text = fatherName
//    }
//
//
//    interface OnCommunicatorFragmentToActivity {
//        fun onPassData(textAnswer: String)
//    }