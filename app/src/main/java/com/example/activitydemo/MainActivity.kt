package com.example.activitydemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitydemo.activitycontract.SecondActivityContract
import com.example.activitydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val LOG_TAG = MainActivity::class.java.simpleName

    // setup view binding
    private lateinit var mainBinding: ActivityMainBinding

    companion object {
        val EXTRA_NAME = "name"
        val EXTRA_AGE = "age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "inside onCreate()")

        // setup view binding
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val activityView = mainBinding.root
        setContentView(activityView)

        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        mainBinding.btnSecondActivity.setOnClickListener(this)
        mainBinding.btnSecondActivityForResult.setOnClickListener(this)
        mainBinding.btnSecondActivityForCustomResult.setOnClickListener(this)
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

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnSecondActivity -> startActivity(generateIntent())
            R.id.btnSecondActivityForResult -> openSecondActivityForResult.launch(generateIntent())
            R.id.btnSecondActivityForCustomResult -> openSecondActivityForCustomResult.launch(99)
        }
    }

    private fun generateIntent(): Intent {
        return Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_NAME, "Rahul")
            putExtra(EXTRA_AGE, 20)
        }
    }

    // General activity result contract
    private val openSecondActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Result OK from SecondActivity", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_LONG).show()
            }
        }

    // Custom activity result contract
    private val openSecondActivityForCustomResult =
        registerForActivityResult(SecondActivityContract()) { result ->
            if (result != null) {
                Toast.makeText(this, "Result from SecondActivity -> $result", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No Result from SecondActivity", Toast.LENGTH_LONG).show()
            }
        }
}