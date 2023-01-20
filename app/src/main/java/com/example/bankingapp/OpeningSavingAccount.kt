package com.example.bankingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.bankingapp.databinding.ActivityOpeningSavingAccountBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class OpeningSavingAccount : AppCompatActivity() {
    private lateinit var binding:ActivityOpeningSavingAccountBinding
    private lateinit var appDb:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpeningSavingAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDb = AppDatabase.getDatabase(this)

        binding.btnWriteData.setOnClickListener {
            writeData()

        }
    }

    private fun writeData(){
        val fullName = binding.enterName1.text.toString()
        val fatherName = binding.enterFathersName1.text.toString()
        val accNo = binding.enterMblNo1.text.toString()
        val emailId = binding.enterEmailId1.text.toString()
        val address = binding.enterAddress1.text.toString()
        val amount = binding.enterAddMoney1.text.toString()

        //key wala
        val customerId = (123456..654321).random()
        //
        val atmCardNo = (1000000000000001..1100000000000000).random()
        val cvvNo = (101..999).random()
        val expiryDate = 1127


        if(fullName.isNotEmpty() && fatherName.isNotEmpty() && accNo.isNotEmpty() && emailId.isNotEmpty()
            && address.isNotEmpty() && amount.isNotEmpty() && amount.toInt()>= 10000){

            val user = User(
                customerId,fullName,fatherName,accNo.toLong(),emailId,
                address,amount.toInt(),atmCardNo,cvvNo,expiryDate
            )
            GlobalScope.launch(Dispatchers.IO) {
                appDb.userDao().insert(user)
            }

            Toast.makeText(this,"Successfully Account Created",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,AccountDetails::class.java)
            intent.putExtra("acc_no",accNo)
            startActivity(intent)

            binding.enterName1.text.clear()
            binding.enterFathersName1.text.clear()
            binding.enterMblNo1.text.clear()
            binding.enterEmailId1.text.clear()
            binding.enterAddress1.text.clear()
            binding.enterAddMoney1.text.clear()

        }else{
            Toast.makeText(this,"Please Fill out All the Fields",Toast.LENGTH_SHORT).show()
        }

    }

}