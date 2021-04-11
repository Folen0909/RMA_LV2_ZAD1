package hr.ferit.famouspersons.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.ferit.famouspersons.databinding.ActivityNewInspiringPersonBinding
import hr.ferit.famouspersons.model.InspiringPerson
import hr.ferit.famouspersons.repository.InspiringPersonsRepository

class NewInspiringPersonActivity : AppCompatActivity() {

    private lateinit var newInspiringPersonBinding: ActivityNewInspiringPersonBinding
    private val inspiringPersonsRepository = InspiringPersonsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newInspiringPersonBinding = ActivityNewInspiringPersonBinding.inflate(layoutInflater)
        newInspiringPersonBinding.bNewPersonSave.setOnClickListener{saveInspiringPerson()}
        setContentView(newInspiringPersonBinding.root)
    }

    private fun saveInspiringPerson() {
        val name = newInspiringPersonBinding.etNewPersonNameInput.text.toString()
        val birth = newInspiringPersonBinding.etNewPersonBirthInput.text.toString()
        val death = newInspiringPersonBinding.etNewPersonDeathInput.text.toString()
        val description = newInspiringPersonBinding.etNewPersonDescriptionInput.text.toString()
        val imageLink = newInspiringPersonBinding.etNewPersonImageLinkInput.text.toString()
        val quote = newInspiringPersonBinding.etNewPersonQuotesInput.text.toString()
        val inspiringPerson = InspiringPerson(name, birth, death, description, imageLink, quotes = mutableListOf(quote))
        inspiringPersonsRepository.insert(inspiringPerson)
        finish()
    }
}