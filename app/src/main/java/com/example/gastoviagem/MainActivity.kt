package com.example.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
             /** FUNÇÃO RESPONSÁVEL POR FAZER A CRIAÇÃO DO ACTIVITY **/
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ADICIONA EVENTO AO ELEMENTO DE INTERFACE
        binding.buttonCalculate.setOnClickListener(this)

    }

    /** FUNÇÃO RESPONSÁVEL POR TRATAR QUALQUER EVENTO DE CLICK NOS ELEMENTOS **/
    override fun onClick(view: View) {
        if(view.id == R.id.buttonCalculate){
            calculate()
        }
    }
    private fun isValid(): Boolean{
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)

    }

    private fun calculate(){

        if(isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"

            binding.textResult.text = totalValueStr
        }
        else {
            Toast.makeText(this,R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }

    }

}