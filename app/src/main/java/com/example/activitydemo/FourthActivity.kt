package com.example.activitydemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitydemo.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {

    val LOG_TAG = FourthActivity::class.java.simpleName
    lateinit var fourthBinding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "inside onCreate()")

        fourthBinding = ActivityFourthBinding.inflate(layoutInflater)
        val view = fourthBinding.root
        setContentView(view)

        fourthBinding.btnSecondActivity.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
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
            return Intent(context, FourthActivity::class.java)
        }
    }
}