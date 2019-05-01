package com.example.intermediatekotlin.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intermediatekotlin.R
import com.example.intermediatekotlin.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            if (this == NavigationActivity.FRAGMENT_VALUE_TASK)
                textView.text = "this is task"
            else if (this == NavigationActivity.FRAGMENT_VALUE_NOTE)
                textView.text = "this is notes"
            else
                textView.text = "something went wrong!!"
        }
    }
}
