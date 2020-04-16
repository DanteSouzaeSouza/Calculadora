package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.calculadora.R
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        bt_01.setOnClickListener { appendOnExpression(string = "1", canClear = true) }
        bt_02.setOnClickListener { appendOnExpression(string = "2", canClear = true) }
        bt_03.setOnClickListener { appendOnExpression(string = "3", canClear = true) }
        bt_04.setOnClickListener { appendOnExpression(string = "4", canClear = true) }
        bt_05.setOnClickListener { appendOnExpression(string = "5", canClear = true) }
        bt_06.setOnClickListener { appendOnExpression(string = "6", canClear = true) }
        bt_07.setOnClickListener { appendOnExpression(string = "7", canClear = true) }
        bt_08.setOnClickListener { appendOnExpression(string = "8", canClear = true) }
        bt_09.setOnClickListener { appendOnExpression(string = "9", canClear = true) }
        bt_0.setOnClickListener { appendOnExpression(string = "0", canClear = true) }
        btPonto.setOnClickListener { appendOnExpression(string = ".", canClear = true) }

        //Operators
        btMais.setOnClickListener { appendOnExpression(string = "+", canClear = false) }
        btMenos.setOnClickListener { appendOnExpression(string = "-", canClear = false) }
        btMultiplicacao.setOnClickListener { appendOnExpression(string = "*", canClear = false) }
        btDivisao.setOnClickListener { appendOnExpression(string = "/", canClear = false) }
        btSeparador.setOnClickListener { appendOnExpression(string = "()", canClear = false) }
        btPercentual.setOnClickListener { appendOnExpression(string = "%", canClear = false) }
        btIgual.setOnClickListener { appendOnExpression(string = "=", canClear = false) }

        btLimpar.setOnClickListener {
            btExpressao.text = ""
            btResultado.text = ""
        }
        btApagar.setOnClickListener {
            val string = btExpressao.text.toString()
            if (string.isNotEmpty()) {
                btExpressao.text = string.substring(0, string.length - 1)
            }
            btResultado.text = ""
        }
        btIgual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(btExpressao.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    btResultado.text = longResult.toString()
                else
                    btResultado.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }

        }
    }

    fun appendOnExpression(string: String, canClear: Boolean) {

        if (btResultado.text.isNotEmpty()) {
            btExpressao.text = ""
        }
        if (canClear) {
            btResultado.text = ""
            btExpressao.append(string)
        } else {
            btExpressao.append(btResultado.text)
            btExpressao.append(string)
            btResultado.text = ""
        }
    }
}


