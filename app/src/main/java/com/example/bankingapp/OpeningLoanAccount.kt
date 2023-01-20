package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bankingapp.databinding.ActivityOpeningLoanAccountBinding

class OpeningLoanAccount : AppCompatActivity() {
    private lateinit var binding:ActivityOpeningLoanAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOpeningLoanAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonForOpeningLoanAccount.setOnClickListener {
            if(binding.textView20.text.toString().isNotEmpty()) {
                val intent = Intent(this, AccountDetails::class.java)
                intent.putExtra("acc_no", binding.textView20.text.toString())
                startActivity(intent)
                binding.textView20.text.clear()
            }else {
                Toast.makeText(this,"Enter Your Valid Account Number",Toast.LENGTH_SHORT).show()
            }

        }
        binding.getLoan.setOnClickListener {
            if(binding.textView20.text.toString().isNotEmpty()) {
                val intent = Intent(this, LoanOptionsPage::class.java)
                intent.putExtra("acc_no", binding.textView20.text.toString())
                startActivity(intent)
                binding.textView20.text.clear()
            }else {
                Toast.makeText(this,"Enter Your Valid Account Number",Toast.LENGTH_SHORT).show()
            }
        }
    }
}