package com.yamure.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sayı butonları

        button_0.setOnClickListener{appendOnClick(true,"0")}
        button_1.setOnClickListener{appendOnClick(true,"1") }
        button_2.setOnClickListener{appendOnClick(true,"2") }
        button_3.setOnClickListener{appendOnClick(true,"3") }
        button_4.setOnClickListener{appendOnClick(true,"4") }
        button_5.setOnClickListener{appendOnClick(true,"5")}
        button_6.setOnClickListener{appendOnClick(true,"6") }
        button_7.setOnClickListener{appendOnClick(true,"7")}
        button_8.setOnClickListener{appendOnClick(true,"8")}
        button_9.setOnClickListener{appendOnClick(true,"9")}


        // dört işlem, ac ve esittir butonları

        button_topla.setOnClickListener {appendOnClick(false,"+")}
        button_cikar.setOnClickListener {appendOnClick(false,"-")}
        button_carp.setOnClickListener {appendOnClick(false,"*") }
        button_bol.setOnClickListener {appendOnClick(false,"/")}

        button_ac.setOnClickListener {
            clear()
        }
        button_esittir.setOnClickListener {
            calculate()
        }



    }
        // metodlar

        private fun appendOnClick(clear:Boolean, string:String){
            if(clear){
                textViewOutPut.text = ""
                textViewInput.append(string)
            }else{
                textViewInput.append(textViewOutPut.text)
                textViewInput.append((string))
                textViewOutPut.text = ""
            }
        }

    private fun clear(){
        textViewInput.text = ""
        textViewOutPut.text = ""
    }

    private fun calculate(){
        try {
            val input = ExpressionBuilder(textViewInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()

            if(output == longOutput.toDouble()) {
                textViewOutPut.text = longOutput.toString()
            }else{
                textViewOutPut.text = output.toString()
            }
        }catch (e:Exception) {
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}