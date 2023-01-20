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
            binding.nameText1.text = "Name = " + user.name.toString()
            binding.fatherNameText2.text = "Father's Name = " + user.fatherName.toString()
            binding.accNumberText1.text = "Account Number = " + user.accountNumber.toString()
            binding.customerIdText1.text = "Customer Id = " + user.customerId.toString()
            binding.emailIdText1.text = "Email Id = " + user.emailId.toString()
            binding.addressText1.text = "Address = " + user.address.toString()
            binding.accountBalanceText1.text = "Account Balance = " + user.balance.toString()
            binding.atmCardNoText1.text = "ATM card Number = " + user.atmNumber.toString()
            binding.cvvNoText1.text = "cvv no = " + user.cvvNo.toString()
            binding.expiryDate1.text = "Expiry Date = " + user.expiryDate.toString()
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