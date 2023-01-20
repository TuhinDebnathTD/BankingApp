package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankingapp.databinding.ActivityOperatingExistingAccountBinding

class OperatingExistingAccount : AppCompatActivity() {
    private lateinit var binding: ActivityOperatingExistingAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperatingExistingAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener {

            val intent = Intent(this,AccountDetailsForOperating::class.java)
            intent.putExtra("ACC_NO",binding.textView35.text.toString())

            binding.textView35.text.clear()
            startActivity(intent)
        }
    }
}