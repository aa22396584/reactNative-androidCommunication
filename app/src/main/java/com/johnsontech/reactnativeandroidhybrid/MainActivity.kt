package com.johnsontech.reactnativeandroidhybrid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler

class MainActivity : AppCompatActivity(), DefaultHardwareBackBtnHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_react_content).setOnClickListener {
            val intent = Intent(this, ReactContentActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_react_communication).setOnClickListener {
            val intent = Intent(this, ReactCommunicationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}
