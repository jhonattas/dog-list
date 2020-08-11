package com.soucriador.dogceo

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
    supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
}

