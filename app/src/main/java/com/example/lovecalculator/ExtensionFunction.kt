package com.example.lovecalculator

import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.bread(s: String) {
Toast.makeText(this.activity,s,Toast.LENGTH_LONG).show()
}