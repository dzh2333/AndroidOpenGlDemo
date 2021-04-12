package com.mark.androidopengldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mark.androidopengldemo.draw.DrawTriangleActivity
import com.mark.androidopengldemo.test.GlViewTestActivity
import com.mark.androidopengldemo.test.MyDiyViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    external fun stringFromJNI(): String

    public fun onclick(view : View){
        when(view.id){
            R.id.draw_triangle->{
                startActivity(object : Intent(MainActivity@this, DrawTriangleActivity::class.java){})
            }
            R.id.draw_point->{

            }
            R.id.draw_line->{

            }

        }
    }

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}