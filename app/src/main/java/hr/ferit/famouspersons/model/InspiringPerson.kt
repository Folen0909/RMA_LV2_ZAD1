package hr.ferit.famouspersons.model

data class InspiringPerson
    (val name: String,
     val dateOfBirth: String,
     val dateOfDeath: String,
     val shortDescription: String,
     val imageLink: String,
     val quotes: MutableList<String>
     )