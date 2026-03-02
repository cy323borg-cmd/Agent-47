package com.agent47

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(50,50,50,50)

        val text = TextView(this)
        text.text = "Agent-47 App Running"

        layout.addView(text)
        setContentView(layout)
    }
}
