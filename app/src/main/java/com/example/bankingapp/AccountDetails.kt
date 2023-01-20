package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.bankingapp.databinding.ActivityAccountDetailsBinding
import kotlinx.coroutines.*

class AccountDetails : AppCompatActivity() {

    private lateinit var binding:ActivityAccountDetailsBinding
    private lateinit var appDb:AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialization is Important
        appDb = AppDatabase.getDatabase(this)
        binding = ActivityAccountDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readData()


        binding.transactionDetails1.setOnClickListener {
            val intent = Intent(this,ForTransactionDetails::class.java)
            startActivity(intent)
        }

    }
    private suspend fun displayData(user: User){

        withContext(Dispatchers.Main){
            binding.textView23.text = "Name = " + user.name.toString()
            binding.textView24.text = "Father's Name = " + user.fatherName.toString()
            binding.textView26.text = "Account Number = " + user.accountNumber.toString()
            binding.textView27.text = "Customer Id = " + user.customerId.toString()
            binding.textView28.text = "Email Id = " + user.emailId.toString()
            binding.textView29.text = "Address = " + user.address.toString()
            binding.textView30.text = "Account Balance = " + user.balance.toString()
            binding.textView31.text = "ATM card Number = " + user.atmNumber.toString()
            binding.textView32.text = "cvv no = " + user.cvvNo.toString()
            binding.textView33.text = "Expiry Date = " + user.expiryDate.toString()
        }
    }
    private fun readData(){
        val accNum = intent.getStringExtra("acc_no")

        if (accNum != null) {
            if(accNum.isNotEmpty()){
                lateinit var user: User
                lifecycleScope.async(Dispatchers.IO) {
                    user = appDb.userDao().findByAccNo(accNum.toInt())
                    displayData(user)
                }

            }
        }


    }

}