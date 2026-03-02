package com.agent47

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var modelPath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(40,40,40,40)

        val selectBtn = Button(this)
        selectBtn.text = "Select Model"

        val loadBtn = Button(this)
        loadBtn.text = "Load Model"

        val status = TextView(this)
        status.text = "Model: Not Selected"

        val debug = TextView(this)
        debug.text = "Debug Console"

        layout.addView(selectBtn)
        layout.addView(loadBtn)
        layout.addView(status)
        layout.addView(debug)

        setContentView(layout)

        selectBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "*/*"
            startActivityForResult(intent, 100)
        }

        loadBtn.setOnClickListener {
            if (modelPath != null) {
                debug.text = "Loading Model...\n$modelPath"
                ModelManager.loadModel(this, modelPath!!)
                debug.append("\nModel Loaded!")
            } else {
                debug.text = "Select model first!"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            modelPath = data?.data
        }
    }
}
