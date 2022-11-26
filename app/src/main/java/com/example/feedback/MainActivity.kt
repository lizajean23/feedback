package com.example.feedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var yes : RadioButton
    private lateinit var no : RadioButton
    private lateinit var name : EditText
    private lateinit var lastname : EditText
    private lateinit var feedback : EditText
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        name =  findViewById(R.id.name)
        lastname = findViewById(R.id.lastname)
        feedback = findViewById(R.id.feedback)
        button = findViewById(R.id.button)

        button.setOnClickListener{

            if(!yes.isChecked && !no.isChecked){
                Toast.makeText(this, "მონიშნე კი ან არა", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(no.isChecked){
                Toast.makeText(this, "თქვენ არ ხართ ჩვენი მომხმარებელი", Toast.LENGTH_SHORT).show()

            }

            else if (yes.isChecked) {

                if (name.text.isEmpty() || lastname.text.isEmpty() || feedback.text.isEmpty()) {
                    Toast.makeText(this, "გთხოვთ უპასუხეთ ორივე შეკითხვას", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                
                else if (name.length() < 3 || !name.text.any { it.isLetter() }){
                    name.error = "სახელი უნდა შეიცავდეს მინიმუმ 3 ციფრს "
                    return@setOnClickListener
                }
                else if (lastname.length() < 5 || !lastname.text.any { it.isLetter() }){
                    lastname.error = "გვარი უნდა შეიცვადეს მინიმუმ 5 ციფრს"
                    return@setOnClickListener
                }
                else if (feedback.length() < 10 || !lastname.text.any{it.isLetter()}){
                    feedback.error = "უნდა შეიცავდეს მინიმუმ 10 სიმბოლოს"
                    return@setOnClickListener
                }
                Toast.makeText(this, "გაგზავნილია", Toast.LENGTH_SHORT).show()
            }

        }

    }
}