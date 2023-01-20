package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.bankingapp.databinding.ActivityAccountDetailsBinding
import com.example.bankingapp.databinding.ActivityAccountDetailsForOperatingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class AccountDetailsForOperating : AppCompatActivity() {

    private lateinit var binding: ActivityAccountDetailsForOperatingBinding
    private lateinit var appDb:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appDb = AppDatabase.getDatabase(this)
        binding = ActivityAccountDetailsForOperatingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readData()


        binding.transactionDetails2.setOnClickListener {
            val intent = Intent(this,ForTransactionDetails::class.java)
            startActivity(intent)
        }
    }
    private suspend fun displayData(user: User){

        withContext(Dispatchers.Main){
            binding.textView37.text = "Name = " + user.name.toString()
            binding.textView38.text = "Father's Name = " + user.fatherName.toString()
            binding.textView39.text = "Account Number = " + user.accountNumber.toString()
            binding.textView40.text = "Customer Id = " + user.customerId.toString()
            binding.textView41.text = "Email Id = " + user.emailId.toString()
            binding.textView42.text = "Address = " + user.address.toString()
            binding.textView43.text = "Account Balance = " + user.balance.toString()
            binding.textView44.text = "ATM card Number = " + user.atmNumber.toString()
            binding.textView45.text = "cvv no = " + user.cvvNo.toString()
            binding.textView46.text = "Expiry Date = " + user.expiryDate.toString()
        }
    }
    private fun readData(){
        val accNum = intent.getStringExtra("ACC_NO")

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