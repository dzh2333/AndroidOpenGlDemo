package com.mark.androidopengldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mark.androidopengldemo.draw.*
import com.mark.androidopengldemo.render.particle.ParticleSystem
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
                startActivity(object : Intent(MainActivity@this, DrawPointActivity::class.java){})
            }
            R.id.draw_line->{
                startActivity(object : Intent(MainActivity@this, DrawLineActivity::class.java){})
            }
            R.id.draw_rect->{
                startActivity(object : Intent(MainActivity@this, DrawRectActivity::class.java){})
            }
            R.id.draw_cir->{
                startActivity(object : Intent(MainActivity@this, DrawCircularActivity::class.java){})
            }
            R.id.draw_3D_cir->{
                startActivity(object : Intent(MainActivity@this, Draw3DObjectActivity::class.java){})
            }
            R.id.draw_wenli->{
                startActivity(object : Intent(MainActivity@this, DrawTextureActivity::class.java){})
            }
            R.id.draw_particle->{
                startActivity(object : Intent(MainActivity@this, ParticleSystem::class.java){})
            }
        }
    }

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
