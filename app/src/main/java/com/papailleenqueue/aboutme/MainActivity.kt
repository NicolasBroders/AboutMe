package com.papailleenqueue.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.papailleenqueue.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //findViewById<Button>(R.id.done_button).setOnClickListener{
        //    addNickName(it)
        //}

        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }



    private fun addNickName(view: View){
/*      val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)*/

        binding.apply {
            nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        //Hide the keyboard
        val ihm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        ihm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
