package com.example.emicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.time.Year

class MainActivity : AppCompatActivity() {
    lateinit var rate: TextView
    lateinit var amt: TextView
    lateinit var year: TextView
    lateinit var seekBar: SeekBar
    lateinit var seekBar2: SeekBar
    lateinit var seekBar3: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rate = findViewById(R.id.rate)
        amt = findViewById(R.id.amt)
        year = findViewById(R.id.year)

        seekBar = findViewById(R.id.seekBar)
        seekBar2 = findViewById(R.id.seekBar2)
        seekBar3 = findViewById(R.id.seekBar3)

        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                amt.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {


            }

        })
        seekBar2.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rate.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {


            }

        })
        seekBar3.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                year.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {


            }

        })
    }
    fun calc(view: View){
        var p=(seekBar.progress).toDouble()
        var r=(seekBar2.progress).toDouble()
        var y=(seekBar3.progress).toDouble()

        var x = p*r*((Math.pow(1+r,y))/(Math.pow(r+1,y)-1))
        Toast.makeText(applicationContext,"EMI: $x",Toast.LENGTH_SHORT).show()
    }
}