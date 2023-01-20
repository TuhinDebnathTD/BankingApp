package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bankingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenNewAccount.setOnClickListener {
            val intent=Intent(this,OptionsForNewAccount::class.java)
            startActivity(intent)
        }
        binding.btnOperateExistingAccount.setOnClickListener {
            val intent = Intent(this,OperatingExistingAccount::class.java)
            startActivity(intent)
        }
    }
}