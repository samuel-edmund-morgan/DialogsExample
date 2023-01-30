package com.example.dialogsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val dialog1 =  AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add this contact?")
            .setIcon(R.drawable.baseline_person_add_24)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "You added this contact!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "You didn't add this person to a contact list!", Toast.LENGTH_SHORT).show()
            }
            .create()
        activityMainBinding.dialog1.setOnClickListener {
            dialog1.show()
        }

        val options = arrayOf("First item", "Second item", "Third Item")
        val dialog2 =  AlertDialog.Builder(this)
            .setTitle("Choose one of these options:")
            .setSingleChoiceItems(options,0 ){ dialogInterface, i ->
                Toast.makeText(this, "You clicked on option ${options[i]} !", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "You added this contact!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "You didn't add this person to a contact list!", Toast.LENGTH_SHORT).show()
            }
            .create()
        activityMainBinding.dialog2.setOnClickListener {
            dialog2.show()
        }


        val dialog3 =  AlertDialog.Builder(this)
            .setTitle("Choose one of these options:")
            .setMultiChoiceItems(options, booleanArrayOf(true,false,true)) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(
                        this,
                        "You checked on option ${options[i]} !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else
                    Toast.makeText(
                        this,
                        "You unchecked on option ${options[i]} !",
                        Toast.LENGTH_SHORT
                    ).show()
            }
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this, "You accepted multichoice dialog!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this, "You didn't aaccept multichoice dialog!", Toast.LENGTH_SHORT).show()
            }
            .create()
        activityMainBinding.dialog3.setOnClickListener {
            dialog3.show()
        }
    }
}