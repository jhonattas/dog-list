package com.soucriador.dogceo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.soucriador.dogceo.R
import kotlinx.android.synthetic.main.breeds_activity.*

class BreedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.breeds_activity)
    addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)
    }


    fun createFragment(): BreedsFragment {
        return BreedsFragment.newInstance()
    }

}
