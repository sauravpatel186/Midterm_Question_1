package com.example.midterm_question_1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num1 = findViewById<EditText>(R.id.edtnum1)
        val num2 = findViewById<EditText>(R.id.edtnum2)
        val result = findViewById<TextView>(R.id.resultText)
        val submit = findViewById<Button>(R.id.submitBtn)
        val spinnerContainer = findViewById<Spinner>(R.id.spinner)
        val operationList= arrayOf("Please select an operation","Addition","Subtraction","Multiplication","Division")
        var operationSelected = ""
        val operationAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,operationList)
        spinnerContainer.adapter = operationAdapter
        spinnerContainer.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                operationSelected = operationList.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        submit.setOnClickListener{
            if ((num1.text).isEmpty()){
                result.text = "Please enter number 1"
            }
            else if((num2.text).isEmpty()){
                result.text = "Please enter number 2"
            }
            else{
                result.text = ""

                when(operationSelected){
                    "Addition" ->{

                        result.text = "Result of Addition is "+add(num1.text.toString().toInt(),num2.text.toString().toInt()).toString()
                    }
                    "Subtraction"->{

                        result.text = "Result of Subtract is "+subtract(num1.text.toString().toInt(),num2.text.toString().toInt()).toString()

                    }
                    "Multiplication"->{

                        result.text = "Result of Multiplication is "+multiplication(num1.text.toString().toInt(),num2.text.toString().toInt()).toString()

                    }
                    "Division"->{

                        result.text = "Result of Division is "+division(num1.text.toString().toInt(),num2.text.toString().toInt()).toString()

                    }
                    "Please select an operation"->{
                        result.text = "Please select an operation"
                    }
                }
            }

        }


    }
    private fun add(x:Int, y:Int):Int{
        return x+y
    }
    private fun subtract(x:Int, y:Int):Int{
        return x-y
    }
    private fun multiplication(x:Int, y:Int):Int{
        return x*y
    }
    private fun division(x:Int, y:Int):Int{
        return x/y
    }
}