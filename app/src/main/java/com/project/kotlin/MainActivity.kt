package com.project.kotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //创建Button对象   也就是activity_main.xml里所设置的ID
    var btn_0: Button? = null
    var btn_1: Button? = null
    var btn_2: Button? = null
    var btn_3: Button? = null
    var btn_4: Button? = null
    var btn_5: Button? = null
    var btn_6: Button? = null
    var btn_7: Button? = null
    var btn_8: Button? = null
    var btn_9: Button? = null
    var btn_pt: Button? = null
    var btn_bai: Button? = null
    var btn_mul: Button? = null
    var btn_div: Button? = null
    var btn_add: Button? = null
    var btn_sub: Button? = null
    var btn_clr: Button? = null
    var btn_del: Button? = null
    var btn_eq: Button? = null

    var btn_sin:Button? = null;
    var btn_cos:Button? = null;
    var btn_tan:Button? = null;
    var btn_log:Button? = null;
    var btn_ln:Button? = null;

    var et_input: TextView? = null
    var clr_flag //判断et编辑文本框中是否清空
            = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0 = findViewById<View>(R.id.btn_0) as Button
        btn_1 = findViewById<View>(R.id.btn_1) as Button
        btn_2 = findViewById<View>(R.id.btn_2) as Button
        btn_3 = findViewById<View>(R.id.btn_3) as Button
        btn_4 = findViewById<View>(R.id.btn_4) as Button
        btn_5 = findViewById<View>(R.id.btn_5) as Button
        btn_6 = findViewById<View>(R.id.btn_6) as Button
        btn_7 = findViewById<View>(R.id.btn_7) as Button
        btn_8 = findViewById<View>(R.id.btn_8) as Button
        btn_9 = findViewById<View>(R.id.btn_9) as Button

        btn_sin = findViewById<View>(R.id.btn_sin) as Button
        btn_cos = findViewById<View>(R.id.btn_cos) as Button
        btn_tan = findViewById<View>(R.id.btn_tan) as Button
        btn_log = findViewById<View>(R.id.btn_log) as Button
        btn_ln = findViewById<View>(R.id.btn_ln) as Button

        btn_bai = findViewById<View>(R.id.btn_bai) as Button
        btn_pt = findViewById<View>(R.id.btn_pt) as Button
        btn_add = findViewById<View>(R.id.btn_add) as Button
        btn_sub = findViewById<View>(R.id.btn_sub) as Button
        btn_mul = findViewById<View>(R.id.btn_mul) as Button
        btn_div = findViewById<View>(R.id.btn_div) as Button
        btn_clr = findViewById<View>(R.id.btn_clr) as Button
        btn_del = findViewById<View>(R.id.btn_del) as Button
        btn_eq = findViewById<View>(R.id.btn_eq) as Button
        et_input = findViewById<View>(R.id.et_input) as TextView

        //给按钮设置的点击事件
        btn_0!!.setOnClickListener(this)
        btn_1!!.setOnClickListener(this)
        btn_2!!.setOnClickListener(this)
        btn_3!!.setOnClickListener(this)
        btn_4!!.setOnClickListener(this)
        btn_5!!.setOnClickListener(this)
        btn_6!!.setOnClickListener(this)
        btn_7!!.setOnClickListener(this)
        btn_8!!.setOnClickListener(this)
        btn_9!!.setOnClickListener(this)

        btn_sin!!.setOnClickListener(this)
        btn_cos!!.setOnClickListener(this)
        btn_tan!!.setOnClickListener(this)
        btn_ln!!.setOnClickListener(this)
        btn_log!!.setOnClickListener(this)

        btn_pt!!.setOnClickListener(this)
        btn_add!!.setOnClickListener(this)
        btn_sub!!.setOnClickListener(this)
        btn_mul!!.setOnClickListener(this)
        btn_div!!.setOnClickListener(this)
        btn_clr!!.setOnClickListener(this)
        btn_del!!.setOnClickListener(this)
        btn_eq!!.setOnClickListener(this)
        btn_bai!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var str = et_input!!.text.toString()
        when (v.id) {
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_pt -> {
                if (clr_flag) {
                    clr_flag = false
                    str = ""
                    et_input!!.text = ""
                }
                et_input!!.text = str + (v as Button).text
            }
            R.id.btn_add, R.id.btn_sub, R.id.btn_mul, R.id.btn_bai, R.id.btn_div -> {
                if (clr_flag) {
                    clr_flag = false
                    str = ""
                    et_input!!.text = ""
                }
                if (str.contains("+") || str.contains("-") || str.contains("×") || str.contains("/") || str.contains(
                        "%"
                    )
                ) {
                    str = str.substring(0, str.indexOf(" "))
                }
                et_input!!.text = str + " " + (v as Button).text + " "
            }
            R.id.btn_clr -> {
                if (clr_flag) clr_flag = false
                str = ""
                et_input!!.text = ""
            }
            R.id.btn_del -> if (str != null && str != "") {
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                    et_input!!.text = "-$str"
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                    et_input!!.text = "+$str"
                } else if (str.toFloat() > 0) {
                    et_input!!.text = "-$str"
                } else if (str.toFloat() < 0) {
                    et_input!!.text = "+$str"
                } else {
                    et_input!!.text = "0"
                }
            }
            R.id.btn_sin->{
                if (str == null && str == ""){
                    return
                }
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                }
                et_input!!.text =  Math.sin(str.toDouble()).toString()

            }
            R.id.btn_cos->{
                if (str == null && str == ""){
                    return
                }
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                }
                et_input!!.text =  Math.cos(str.toDouble()).toString()
            }
            R.id.btn_tan->{
                if (str == null && str == ""){
                    return
                }
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                }
                et_input!!.text =  Math.tan(str.toDouble()).toString()
            }
            R.id.btn_log->{
                if (str == null && str == ""){
                    return
                }
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                }
                et_input!!.text =  Math.log10(str.toDouble()).toString()
            }
            R.id.btn_ln->{
                if (str == null && str == ""){
                    return
                }
                if ("+" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                } else if ("-" == str.substring(0, 1)) {
                    str = str.substring(1, str.length)
                }
                et_input!!.text =  Math.log(str.toDouble()).toString()
            }
            R.id.btn_eq -> result //调用下面的方法
        }
    }

    //因为没有运算符所以不用运算
    //截取运算符前面的字符串
    private val result: Unit
        //截取的运算符
        //截取运算符后面的字符串
        private get() {
            val exp = et_input!!.text.toString()
            if (exp == null || exp == "") return
            //因为没有运算符所以不用运算
            if (!exp.contains(" ")) {
                return
            }
            if (clr_flag) {
                clr_flag = false
                return
            }
            clr_flag = true
            //截取运算符前面的字符串
            val s1 = exp.substring(0, exp.indexOf(" "))
            //截取的运算符
            val op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2)
            //截取运算符后面的字符串
            val s2 = exp.substring(exp.indexOf(" ") + 3)
            var cnt = 0.0
            if (s1 != "" && s2 != "") {
                val d1 = s1.toDouble()
                val d2 = s2.toDouble()
                if (op == "+") {
                    cnt = d1 + d2
                }
                if (op == "-") {
                    cnt = d1 - d2
                }
                if (op == "×") {
                    cnt = d1 * d2
                }
                if (op == "/") {
                    cnt = if (d2 == 0.0) 0.0 else d1 / d2
                }
                if (op == "%") {
                    cnt = if (d2 == 0.0) 0.0 else d1 % d2
                }
                if (!s1.contains(".") && !s2.contains(".") && op != "/" && op != "%") {
                    val res = cnt.toInt()
                    et_input!!.text = res.toString() + ""
                } else {
                    et_input!!.text = cnt.toString() + ""
                }
            } else if (s1 != "" && s2 == "") {
                val d1 = s1.toDouble()
                if (op == "+") {
                    cnt = d1
                }
                if (op == "-") {
                    cnt = d1
                }
                if (op == "×") {
                    cnt = 0.0
                }
                if (op == "/") {
                    cnt = 0.0
                }
                if (op == "%") {
                    cnt = 0.0
                }
                if (!s1.contains(".")) {
                    val res = cnt.toInt()
                    et_input!!.text = res.toString() + ""
                } else {
                    et_input!!.text = cnt.toString() + ""
                }
            } else if (s1 == "" && s2 != "") {
                val d2 = s2.toDouble()
                if (op == "+") {
                    cnt = d2
                }
                if (op == "-") {
                    cnt = 0 - d2
                }
                if (op == "×") {
                    cnt = 0.0
                }
                if (op == "/") {
                    cnt = 0.0
                }
                if (op == "%") {
                    cnt = 0.0
                }
                if (!s2.contains(".")) {
                    val res = cnt.toInt()
                    et_input!!.text = res.toString() + ""
                } else {
                    et_input!!.text = cnt.toString() + ""
                }
            } else {
                et_input!!.text = ""
            }
        }
}