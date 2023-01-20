package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bankingapp.databinding.ActivityOpeningCurrentAccountBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class OpeningCurrentAccount : AppCompatActivity() {
    private lateinit var binding:ActivityOpeningCurrentAccountBinding
    private lateinit var appDb:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOpeningCurrentAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)

        binding.btnWritingData.setOnClickListener {
            writeData()

        }

    }
    private fun writeData(){
        val fullName = binding.enterName2.text.toString()
        val fatherName = binding.enterFathersName2.text.toString()
        val accNo = binding.enterMblNo2.text.toString()
        val emailId = binding.enterEmailId2.text.toString()
        val address = binding.enterAddress2.text.toString()
        val amount = binding.enterAddMoney2.text.toString()

        val age = binding.yourAge1.text.toString()

        //key wala
        val customerId = (123456..654321).random()
        //
        val atmCardNo = (1000000000000001..1100000000000000).random()
        val cvvNo = (101..999).random()
        val expiryDate = 1127


        if(fullName.isNotEmpty() && fatherName.isNotEmpty() && accNo.isNotEmpty() && emailId.isNotEmpty()
            && address.isNotEmpty() && amount.isNotEmpty() && amount.toInt()>= 100000 && age.toInt()>= 18 ){

            val user = User(
                customerId,fullName,fatherName,accNo.toLong(),emailId,
                address,amount.toInt(),atmCardNo,cvvNo,expiryDate
            )
            GlobalScope.launch(Dispatchers.IO) {
                appDb.userDao().insert(user)
            }

            Toast.makeText(this,"Successfully Account Created", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,AccountDetails::class.java)
            intent.putExtra("acc_no",accNo)
            startActivity(intent)

            binding.enterName2.text.clear()
            binding.enterFathersName2.text.clear()
            binding.enterMblNo2.text.clear()
            binding.enterEmailId2.text.clear()
            binding.enterAddress2.text.clear()
            binding.enterAddMoney2.text.clear()

        }else{
            Toast.makeText(this,"Fill All the Fields Or You May Not Have Sufficient Age To Open a Current Account", Toast.LENGTH_SHORT).show()
        }

    }
}