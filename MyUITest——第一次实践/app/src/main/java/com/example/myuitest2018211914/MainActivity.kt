package com.example.myuitest2018211914

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*通过id获取控件*/
        val button1: Button = findViewById(R.id.button1) //显示信息按钮
        val button2: Button = findViewById(R.id.button2) //删除信息按钮
        val showText: TextView = findViewById(R.id.textViewMes)

        /*基本内容*/
        /*点击左侧按钮后在下方用文字展示出输入框输入的信息*/
/*        button1.setOnClickListener {
            val showMeg = getUserInput() //获取要显示的信息
            showText.setText(showMeg) //在下方用文字展示输入的信息
        }
        *//*点击右侧按钮清空上方输入的内容以及下方已经展示出来的内容*//*
        button2.setOnClickListener {
            init() //清空上方输入的内容
            showText.setText("") //清空下方已经展示出来的内容
        }*/

        /*附加内容*/
        /*点击主Activity“显示信息”按钮弹出另一个Activity以显示信息*/
        button1.setOnClickListener {
            val showMeg = getUserInput() //获取要显示的信息
            val intent = Intent(this, SecondActivity::class.java) //明确指定启动SecondActivity
            intent.putExtra("msg", showMeg) //传递要显示的信息
            startActivity(intent) //启动SecondActivity
            showText.setText(showMeg) //在首页中显示信息
        }
        /*点击“删除显示”按钮清空上方输入部分的内容*/
        button2.setOnClickListener {
            init() //仅清空上方输入的内容
        }
    }
    //获取要显示的信息
    fun getUserInput(): String {
        val inputName: EditText = findViewById(R.id.editTextName)
        val inputAge: EditText = findViewById(R.id.editTextAge)
        val inputHeight: EditText = findViewById(R.id.editTextHeight)
        val name = inputName.getText().toString()
        val age = inputAge.getText().toString()
        val height = inputHeight.getText().toString()
        if(name!=""&&age!=""&&height!=""){ //若用户正确输入
            return "在这里显示输入的信息：\n"+name+age+"岁了，身高是"+height+"米"
        }
        else{ //若用户有某些项为输入，则提示用户
            return "您未输入姓名、年龄或身高"
        }
    }
    //清空上方输入的内容
    fun init(){
        val inputName: EditText = findViewById(R.id.editTextName)
        val inputAge: EditText = findViewById(R.id.editTextAge)
        val inputHeight: EditText = findViewById(R.id.editTextHeight)
        inputAge.setText("")
        inputName.setText("")
        inputHeight.setText("")
    }

    //调用inflate方法创建菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    //设置点击菜单项的响应操作，在此为弹出Toast提醒（提醒内容为“你点击了XX菜单项”）。
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Setting_item -> Toast.makeText(this, "你点击了设置菜单项", Toast.LENGTH_SHORT).show()
            R.id.new_item -> Toast.makeText(this, "你点击了新建菜单项", Toast.LENGTH_SHORT).show()
            R.id.print_item -> Toast.makeText(this, "你点击了打印菜单项", Toast.LENGTH_SHORT).show()
            R.id.mail_item -> Toast.makeText(this, "你点击了邮件菜单项", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}