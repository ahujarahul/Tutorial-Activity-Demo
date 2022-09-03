package com.example.activitydemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.activitydemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private val LOG_TAG = SecondActivity::class.java.simpleName
    var name: String? = null
    var age: Int? = null
    var id: Int? = null

    // setup view binding
    lateinit var secondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "inside onCreate()")

        // setup view binding
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        val view = secondBinding.root
        setContentView(view)

        setUpClickListeners()
        collectIntentData()
    }

    private fun setUpClickListeners() {
        secondBinding.btnShowDialog.setOnClickListener(this)
        secondBinding.btnGoBack.setOnClickListener(this)
        secondBinding.btnNextActivity.setOnClickListener(this)
    }

    private fun collectIntentData() {
        name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        age = intent.getIntExtra(MainActivity.EXTRA_AGE, 0)
        id = intent.getIntExtra(ID, 0)
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
            R.id.btnShowDialog -> showAlertDialog()
            R.id.btnGoBack -> sendBackResult()
            R.id.btnNextActivity -> ThirdActivity.launch(this).also {
                startActivity(it)
            }
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Activity Demo")
            .setMessage("Intent Data: Name- $name, Age- $age")
            .show()
    }

    private fun sendBackResult() {
        val resultIntent = Intent().apply {
            putExtra(TITLE, "Acknowledgement of id= $id")
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    companion object {
        const val TITLE = "title"
        const val ID = "id"

        fun getIntent(context: Context, id: Int?): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(ID, id)
            }
        }
    }
}