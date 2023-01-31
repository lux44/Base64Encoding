package com.lux.zena.base64encoding.ui.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.lux.zena.base64encoding.R
import com.lux.zena.base64encoding.databinding.ActivityMainBinding
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var byte:ByteArray
    lateinit var base64:String
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.main=this

        binding.btnEncode.setOnClickListener {
            byte = binding.et.text.toString().toByteArray(charset("UTF-8"))
            base64 = Base64.encodeToString(byte,Base64.DEFAULT )
            binding.tv.text = base64
            binding.btnDecode.visibility=View.VISIBLE
        }
        binding.btnDecode.setOnClickListener {
            val ttt= String(android.util.Base64.decode(base64,android.util.Base64.DEFAULT), Charset.forName("UTF-8"))
            binding.tv.text=ttt.toString()
        }

    }
}