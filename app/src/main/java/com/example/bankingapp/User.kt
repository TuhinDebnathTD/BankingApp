package com.example.bankingapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "account_details")
data class User(
    @PrimaryKey val customerId:Int?,
    @ColumnInfo(name = "name") val name:String?,
    @ColumnInfo(name = "father_Name") val fatherName:String?,
    @ColumnInfo(name = "account_number") val accountNumber:Long?,
    @ColumnInfo(name = "email_id") val emailId:String?,
    @ColumnInfo(name = "address") val address:String?,
    @ColumnInfo(name = "balance") val balance:Int?,

    //auto generated fields are
    @ColumnInfo(name = "atm_number") val atmNumber: Long?,
    @ColumnInfo(name = "cvv_no") val cvvNo:Int?,
    @ColumnInfo(name = "expiry_date") val expiryDate:Int?,
)
