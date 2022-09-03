package com.example.activitydemo.activitycontract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.activitydemo.SecondActivity

class SecondActivityContract: ActivityResultContract<Int, String?>() {

    override fun createIntent(context: Context, input: Int?): Intent {
        return SecondActivity.getIntent(context, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        val data = intent?.getStringExtra(SecondActivity.TITLE)
        return if (resultCode == Activity.RESULT_OK && data != null) data else null
    }
}