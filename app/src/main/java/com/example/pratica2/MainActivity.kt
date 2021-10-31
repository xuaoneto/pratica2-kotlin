package com.example.pratica2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var fieldtext: TextView
    private lateinit var containerSliders: View
    private lateinit var background: View
    private lateinit var inputslider1: SeekBar
    private lateinit var inputslider2: SeekBar
    private lateinit var inputslider3: SeekBar
    private lateinit var rgbText: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputslider1 = findViewById(R.id.seekBar);
        this.inputslider2 = findViewById(R.id.seekBar2);
        this.inputslider3 = findViewById(R.id.seekBar3);

        this.inputslider1.setOnSeekBarChangeListener(OnChange());
        this.inputslider2.setOnSeekBarChangeListener(OnChange());
        this.inputslider3.setOnSeekBarChangeListener(OnChange());

        this.containerSliders = findViewById(R.id.inputscontainer)
        this.fieldtext = findViewById(R.id.colorrgb);
        this.background = findViewById(R.id.showcolor);

    }

    fun getValuesOfSliders(): MutableList<Int>{
        var lista:MutableList<Int> = mutableListOf();

        lista.add(this.inputslider1.progress);
        lista.add(this.inputslider2.progress);
        lista.add(this.inputslider3.progress);

        return lista
    }

    inner class OnChange : SeekBar.OnSeekBarChangeListener {
        private lateinit var valuesOfSliders: MutableList<Int>

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this.valuesOfSliders = getValuesOfSliders();
            this@MainActivity.setBackgroundOf(valuesOfSliders);
            this@MainActivity.setValueText(valuesOfSliders);

        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {};
        override fun onStopTrackingTouch(seekBar: SeekBar?) {};
    }
    fun setBackgroundOf(array: MutableList<Int>){
        this.background.setBackgroundColor(android.graphics.Color.rgb(array[0],array[1],array[2]));
    }
    fun setValueText(array: MutableList<Int>){
        this.rgbText = "rgb(" + array[0].toString() + "," + array[1].toString() + "," + array[2].toString() + ");"
        this.fieldtext.text = this.rgbText;
    }
}









