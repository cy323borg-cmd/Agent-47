package com.agent47

import android.content.Context
import android.net.Uri
import android.util.Log

object ModelManager {

    fun loadModel(context: Context, uri: Uri) {
        Log.d("Agent47", "Model Selected: $uri")

        // এখানে পরে llama.cpp native integrate করবো
    }
}
