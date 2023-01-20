package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankingapp.databinding.ActivityOptionsForNewAccountBinding

class OptionsForNewAccount : AppCompatActivity() {
    private lateinit var binding: ActivityOptionsForNewAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsForNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSavingAccount.setOnClickListener {

            val intent = Intent(this,OpeningSavingAccount::class.java)
            startActivity(intent)
        }
        binding.btnCurrentAccount.setOnClickListener {
            val intent = Intent(this,OpeningCurrentAccount::class.java)
            startActivity(intent)
        }
        binding.btnLoanAccount.setOnClickListener {
            val intent = Intent(this,OpeningLoanAccount::class.java)
            startActivity(intent)
        }
    }
}