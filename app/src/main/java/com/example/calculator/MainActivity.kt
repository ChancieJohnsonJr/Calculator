package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.CleartextNetworkViolation
import android.view.View
import android.widget.Button
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var btn4 = findViewById<Button>(R.id.btn4)
        var btn5 = findViewById<Button>(R.id.btn5)
        var btn6 = findViewById<Button>(R.id.btn6)
        var btn7 = findViewById<Button>(R.id.btn7)
        var btn8 = findViewById<Button>(R.id.btn8)
        var btn9 = findViewById<Button>(R.id.btn9)
        var btn0 = findViewById<Button>(R.id.btn0)

        var Addition = findViewById<Button>(R.id.add)
        var Subtraction = findViewById<Button>(R.id.subtract)
        var Multiplication = findViewById<Button>(R.id.multiply)
        var Division = findViewById<Button>(R.id.division)
        var Equals = findViewById<Button>(R.id.equals)
        var Point = findViewById<Button>(R.id.point)





        btn1.setOnClickListener {
            evaluateExpression("1", clear = true)

        }

        btn2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        btn3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        btn4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        btn5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        btn6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        btn7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        btn8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        btn9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        btn0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }


        add.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        subtract.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        multiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        division.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        point.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        clear.setOnClickListener {
            tvinput.text = ""
            tvoutput.text = ""
        }

        equals.setOnClickListener {
            val text = tvinput.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvoutput.text = longResult.toString()
            } else {
                tvoutput.text = result.toString()
            }
        }


    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            tvoutput.text = ""
            tvinput.append(string)
        } else {
            tvinput.append(tvoutput.text)
            tvinput.append(string)
            tvoutput.text = ""
        }
    }

}




