package hr.ferit.famouspersons.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.famouspersons.adapters.InspiringPersonsAdapter
import hr.ferit.famouspersons.databinding.ActivityMainBinding
import hr.ferit.famouspersons.listeners.OnInspiringPersonSelectedListener
import hr.ferit.famouspersons.model.InspiringPerson
import hr.ferit.famouspersons.repository.InspiringPersonsRepository

class MainActivity : AppCompatActivity(), OnInspiringPersonSelectedListener {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var onInspiringPersonSelectedListener: OnInspiringPersonSelectedListener
    private val inspiringPersons = InspiringPersonsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddPerson.setOnClickListener{createNewInspiringPerson()}
        setContentView(mainBinding.root)
        if(this is OnInspiringPersonSelectedListener){
            onInspiringPersonSelectedListener = this
        }
        mainBinding.rvPersons.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        mainBinding.rvPersons.adapter =
            InspiringPersonsAdapter(inspiringPersons.getInspiringPersons(), onInspiringPersonSelectedListener)
    }

    override fun onResume() {
        super.onResume()
        (mainBinding.rvPersons.adapter as InspiringPersonsAdapter).refreshData(inspiringPersons.getInspiringPersons())
    }

    private fun createNewInspiringPerson() {
        val newInspiringPersonIntent = Intent(this, NewInspiringPersonActivity::class.java)
        startActivity(newInspiringPersonIntent)
    }

    override fun onInspiringPersonSelected(inspiringPerson: InspiringPerson) {
        Toast.makeText(applicationContext, inspiringPerson.quotes.random(), Toast.LENGTH_SHORT).show()
    }
}