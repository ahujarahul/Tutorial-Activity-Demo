package com.example.activitydemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.activitydemo.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    val LOG_TAG = ThirdActivity::class.java.simpleName
    lateinit var thirdBinding: ActivityThirdBinding

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         Log.d(LOG_TAG, "inside onCreate()")

         thirdBinding = ActivityThirdBinding.inflate(layoutInflater)
         val view = thirdBinding.root
         setContentView(view)

         thirdBinding.btnLaunchSelf.setOnClickListener {
             launch(this).also {
                 startActivity(it)
             }
         }

         thirdBinding.btnNextActivity.setOnClickListener {
             FourthActivity.launch(this).also {
                 startActivity(it)
             }
         }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "inside onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "inside onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "inside onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "inside onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "inside onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "inside onRestart()")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d(LOG_TAG, "inside onNewIntent()")
    }

    companion object {
        fun launch(context: Context): Intent {
            return Intent(context, ThirdActivity::class.java)
        }
    }
}