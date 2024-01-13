package com.example.daggerdependancyinjectiondemo.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.daggerdependancyinjectiondemo.R
import com.example.daggerdependancyinjectiondemo.databinding.ActivityGetStartBinding
import com.example.daggerdependancyinjectiondemo.prefs.Prefs.Companion.PRIVACY_POLICY_LINK
import com.example.daggerdependancyinjectiondemo.service.UserService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GetStartActivity : BaseActivity<ActivityGetStartBinding>(),
    CompoundButton.OnCheckedChangeListener,
    View.OnClickListener {

    @Inject
    lateinit var userService: UserService
    private var btn_get_start: AppCompatButton? = null
    private var chkByClick: CheckBox? = null
    lateinit var txt_start_privacy: MessagesTextView
    private var isMain: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        UIComponent()

    }

    override fun getViewBinding(inflator: LayoutInflater) =
        ActivityGetStartBinding.inflate(inflator)

    private fun init() {
        if (intent.extras != null) {
            isMain = intent.extras!!.getBoolean("isMain", false)
        }
    }

    private fun UIComponent() {


        chkByClick = binding.chkByClick
        chkByClick!!.setOnCheckedChangeListener(this)
        txt_start_privacy = binding.txtStartPrivacy
        // Access the injected dependency
        val user = userService.getUser()
        txt_start_privacy.text = user
        btn_get_start = binding.btnGetStart
        btn_get_start!!.setBackgroundResource(R.drawable.button_continue)
        btn_get_start!!.setTextColor(ContextCompat.getColor(this, R.color.color_grey_dark))
        txt_start_privacy!!.setOnClickListener(this)
        btn_get_start!!.setOnClickListener(this)

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        btn_get_start!!.setBackgroundResource(if (isChecked) R.drawable.button_continue else R.drawable.button_continue_grey)
        btn_get_start!!.setTextColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.white else R.color.black
            )
        )
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_get_start ->
                onClickStart()

            R.id.txt_start_privacy ->
                openPrivacyPolicy(this)

        }
    }

    private fun openPrivacyPolicy(context: Context) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(PRIVACY_POLICY_LINK))
            context.startActivity(browserIntent)
        } catch (throwable: Throwable) {
            Log.i(
                "Tag",
                "openPrivacyPolicy: " + throwable.message
            )
        }
    }

    private fun onClickStart() {
        startActivity(
            Intent(
                this@GetStartActivity,
                MainActivity::class.java
            ).putExtra("isMain", false)
        )

    }


}