package com.example.myuitest2018211914

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val extraData = intent.getStringExtra("msg") //获取传递的信息
        /*通过id获取控件*/
        val showText: TextView = findViewById(R.id.textViewMes2) //显示文字的控件
        val btn: TextView = findViewById(R.id.returnBtn) //返回按钮
        /*设置显示的信息*/
        showText.setText(extraData)
        /*点击返回按钮实现此Activity的销毁*/
        btn.setOnClickListener {
            finish()
        }
    }
}