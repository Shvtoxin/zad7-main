package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        El1 = findViewById<TextView>(R.id.ABut)
        El2 = findViewById<TextView>(R.id.Bbut)
        ProvBtn = findViewById<TextView>(R.id.CBut)
        Znak = findViewById<TextView>(R.id.znak)
        True = findViewById<TextView>(R.id.TrueT)
        Faulse = findViewById<TextView>(R.id.FaulseT)

    }

    lateinit var True: TextView
    lateinit var Faulse: TextView
    lateinit var Znak: TextView
    lateinit var El1: TextView
    lateinit var El2: TextView
    lateinit var ProvBtn: TextView
    var i: Int = 0
    var j: Int = 0
    var Resheno: Int = 0
    val RandZnak = arrayOf("+", "-", "*", "/")
    var a: Int = 0
    var b: Int = 0
    var c: Int = 0
    var Proc = 0.00


    fun StartPr(view: View) {
        val Check = findViewById<Button>(R.id.CheckBut)
        Check.isEnabled = true
        val start = 0
        val end = 99
        val randomNumber = start + (Math.random() * end).toInt()
        val randomNumber2 = start + (Math.random() * end).toInt()
        El1.setText("" + randomNumber)
        El2.setText("" + randomNumber2)
    }

    fun Check(view: View) {

        if (ProvBtn.text.toString().isEmpty()) return
        a = El1.text.toString().toInt()
        b = El2.text.toString().toInt()
        c = ProvBtn.text.toString().toInt()
        val start = 0
        val end = 99
        when (Znak.text.toString()) {
            "+" -> {
                if ((a + b) == c) {

                    i++
                } else {

                    j++
                }
            }
            "-" -> {
                if ((a - b) == c) {

                    i++
                } else {

                    j++
                }
            }
            "*" -> {
                if ((a * b) == c) {

                    i++
                } else {

                    j++
                }
            }
            "/" -> {
                if ((a / b) == c) {

                    i++
                } else {

                    j++
                }
            }
        }
        Resheno = i + j
        val res = findViewById<TextView>(R.id.Resh)
        res.text = Resheno.toString()
        True.text = i.toString()
        Faulse.text = j.toString()
        val randomNumber = start + (Math.random() * end).toInt()
        val randomNumber2 = start + (Math.random() * end).toInt()
        El1.setText("" + randomNumber)
        El2.setText("" + randomNumber2)
        var Rnd = RandZnak.random()
        Znak.text = Rnd
        ProvBtn.text = ""
        Proc = 0.00
        Proc = ((i.toDouble() / (Resheno.toDouble() / 100)))
        val Procent: TextView = findViewById(R.id.edit)
        Procent.text = "%.2f".format(Proc)

    }

}

